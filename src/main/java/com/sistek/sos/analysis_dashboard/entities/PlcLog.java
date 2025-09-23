package com.sistek.sos.analysis_dashboard.entities;

import com.sistek.sos.analysis_dashboard.entities.keys.PlcLogId;
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
@Table(name = "plc_log")

public class PlcLog {
    @EmbeddedId
    private PlcLogId plcLogId;

    @Column(name = "proc_date", nullable = false)
    private LocalDateTime procDate;

    @Column(name = "status", nullable = false)
    private String status;
}
