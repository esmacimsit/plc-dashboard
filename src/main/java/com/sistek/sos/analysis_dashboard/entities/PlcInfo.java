package com.sistek.sos.analysis_dashboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // jpa interface
import lombok.Data; // a java dependency, generates boilerplate (repeatitive)
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // getter setter, toString(), equals(), hashCode() from lombok
@NoArgsConstructor // i know it added automatically but i wanted to secure it for jpa
@Entity // its the entity class
@Table(name = "plc_info") // table name, if you didnt write it table name would be same as class name

public class PlcInfo {
    @Id // primary key
    @Column(name = "plc_id", nullable = false) // defining not nullable columns
    private String plcId; // assigning column to field

    @Column(name = "last_status_date", nullable = false)
    private LocalDateTime lastStatusDate; // camelCase to snake_case

    @Column(name = "plc_ip", nullable = false)
    private String plcIp;

    @Column(name = "status", nullable = false)
    private String status;
}