package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.dto.UnifiedLog;
import com.sistek.sos.analysis_dashboard.repositories.LineLogRepository;
import com.sistek.sos.analysis_dashboard.repositories.PlcLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LogService {
    private final LineLogRepository lineLogRepository;
    private final PlcLogRepository plcLogRepository;

    public LogService(LineLogRepository lineLogRepository, PlcLogRepository plcLogRepository) {
        this.lineLogRepository = lineLogRepository;
        this.plcLogRepository = plcLogRepository;
    }

    // 3) Birleşik liste (status sadece LINE için uygulanır)
    public List<UnifiedLog> getUnifiedLogs(String source,
                                           String lineId,
                                           String status,
                                           LocalDateTime start,
                                           LocalDateTime end) {
        Stream<UnifiedLog> merged =
                "PLC".equalsIgnoreCase(source) ? getPlcLogs(start, end).stream()
                        : "LINE".equalsIgnoreCase(source) ? getLineLogs(start, end, lineId, status).stream()
                        : Stream.concat(getPlcLogs(start, end).stream(),
                        getLineLogs(start, end, lineId, status).stream());

        return merged.sorted(Comparator.comparing(UnifiedLog::getProcDate).reversed())
                .toList();
    }

    // 1) PLC logs (status yok)
    public List<UnifiedLog> getPlcLogs(LocalDateTime start, LocalDateTime end) {
        return plcLogRepository.findAllByOrderByProcDateDesc().stream()
                .filter(p -> start == null || !p.getProcDate().isBefore(start))
                .filter(p -> end == null || !p.getProcDate().isAfter(end))
                .map(p -> new UnifiedLog(
                        "PLC",
                        p.getPlcLogId().getPlcId(),
                        p.getPlcLogId().getSeqNo(),
                        p.getProcDate(),
                        p.getStatus()))
                .toList();
    }

    // 2) LINE logs (status + lineId filtreleri)
    public List<UnifiedLog> getLineLogs(LocalDateTime start,
                                        LocalDateTime end,
                                        String lineId,
                                        String status) {
        String wanted = (status == null || status.isBlank()) ? null : status.trim().toUpperCase();

        return lineLogRepository.findAllByOrderByProcDateDesc().stream()
                .filter(l -> start == null || !l.getProcDate().isBefore(start))
                .filter(l -> end == null || !l.getProcDate().isAfter(end))
                .filter(l -> lineId == null || lineId.isBlank()
                        || l.getLineLogId().getLineId().equalsIgnoreCase(lineId))
                .filter(l -> wanted == null
                        || (l.getStatus() != null && l.getStatus().trim().toUpperCase().equals(wanted)))
                .map(l -> new UnifiedLog(
                        "LINE",
                        l.getLineLogId().getLineId(),
                        l.getLineLogId().getSeqNo(),
                        l.getProcDate(),
                        l.getStatus()))
                .toList();
    }
}
