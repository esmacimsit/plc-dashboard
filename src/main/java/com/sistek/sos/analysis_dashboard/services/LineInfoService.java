package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.entities.LineInfo;
import com.sistek.sos.analysis_dashboard.repositories.LineInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineInfoService {
    private final LineInfoRepository lineInfoRepository;

    @Autowired
    public LineInfoService(LineInfoRepository lineInfoRepository) {
        this.lineInfoRepository = lineInfoRepository;
    } // constructor injection

//    public List<LineInfo> getAllLineInfo() {
//        return lineInfoRepository.findAll();
//    } // select * from line_info
//
//    public LineInfo getLineInfoById(String lineId) {
//        return lineInfoRepository.findById(lineId).orElse(null);
//    }

    public List<LineInfo> getAllLinesAsc() {
        return lineInfoRepository.findAllByOrderByLineIdAsc();
    } // ordered list

//    public List<String> getLineNames(List<LineInfo> lines) {
//        return lines.stream() // stream started
//                .map(LineInfo::getLineName) // mapping: fetch lineName
//                .collect(Collectors.toList()); // create new list
//    }

    public List<String> getLineNamesAndStatus(List<LineInfo> lines) {
        DateTimeFormatter ft = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");

        return lines.stream()
                .map(line -> {
                    if ("RUN".equals(line.getStatus())) {
                        return line.getLineName() + " - running...";
                    } else if ("STOP".equals(line.getStatus())) {
                        return line.getLineName() + " - stopped at " + ft.format(line.getLastStatusDate());
                    } else {
                        return line.getLineName() + " - unknown";
                    }
                })
                .collect(Collectors.toList());
    }
}