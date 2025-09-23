package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.dto.UnifiedLog;
import com.sistek.sos.analysis_dashboard.entities.LineLog;
import com.sistek.sos.analysis_dashboard.entities.PlcLog;
import com.sistek.sos.analysis_dashboard.repositories.LineLogRepository;
import com.sistek.sos.analysis_dashboard.repositories.PlcLogRepository;
import org.springframework.stereotype.Service;

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

    public List<UnifiedLog> getUnifiedLogs() {
        List<PlcLog> plc = plcLogRepository.findTop200ByOrderByProcDateDesc();
        List<LineLog> line = lineLogRepository.findTop200ByOrderByProcDateDesc();

        return Stream.concat(
                        plc.stream().map(p ->
                                new UnifiedLog(
                                        "PLC",
                                        p.getPlcLogId().getPlcId(),
                                        p.getPlcLogId().getSeqNo(),
                                        p.getProcDate(),
                                        p.getStatus()
                                )
                        ),
                        line.stream().map(l ->
                                new UnifiedLog(
                                        "LINE",
                                        l.getLineLogId().getLineId(),
                                        l.getLineLogId().getSeqNo(),
                                        l.getProcDate(),
                                        l.getStatus()
                                )
                        )
                )
                .sorted(Comparator.comparing(UnifiedLog::getProcDate).reversed())
                .toList();
    }
}
