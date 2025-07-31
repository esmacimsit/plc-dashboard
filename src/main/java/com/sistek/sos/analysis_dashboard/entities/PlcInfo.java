package com.sistek.sos.analysis_dashboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "plc_info")
public class PlcInfo {
    @Id
    @Column(name = "plc_id", nullable = false)
    private String plcId;

    @Column(name = "last_status_date", nullable = false)
    private LocalDateTime lastStatusDate;

    @Column(name = "plc_ip", nullable = false)
    private String plcIp;

    @Column(name = "status", nullable = false)
    private String status;
}

