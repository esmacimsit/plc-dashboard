package com.sistek.sos.analysis_dashboard.dto;

import java.time.LocalDateTime;

public class Activity {
    private final LocalDateTime time;
    private final String source;  // "PLC" | "LINE"
    private final String message;

    public Activity(LocalDateTime time, String source, String message) {
        this.time = time;
        this.source = source;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }
}
