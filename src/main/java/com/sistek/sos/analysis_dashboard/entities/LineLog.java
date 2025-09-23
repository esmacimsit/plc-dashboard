package com.sistek.sos.analysis_dashboard.entities;

import com.sistek.sos.analysis_dashboard.entities.keys.LineLogId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "line_log")
public class LineLog {
    @EmbeddedId
    private LineLogId lineLogId;

    @Column(name = "proc_date", nullable = false)
    private LocalDateTime procDate;

    @Column(name = "status", nullable = false)
    private String status;

//    public String getLineId() {
//        return lineLogId != null ? lineLogId.getLineId() : null;
//    }
}
