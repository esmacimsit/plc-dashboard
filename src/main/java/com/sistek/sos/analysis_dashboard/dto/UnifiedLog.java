package com.sistek.sos.analysis_dashboard.dto;

import java.time.LocalDateTime;

public class UnifiedLog {
    private String source;   // "PLC" veya "LINE"
    private String id;       // plcId veya lineId
    private Integer seqNo;
    private LocalDateTime procDate;
    private String status;

    public UnifiedLog(String source, String id, Integer seqNo, LocalDateTime procDate, String status) {
        this.source = source;
        this.id = id;
        this.seqNo = seqNo;
        this.procDate = procDate;
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public String getId() {
        return id;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public LocalDateTime getProcDate() {
        return procDate;
    }

    public String getStatus() {
        return status;
    }
}
