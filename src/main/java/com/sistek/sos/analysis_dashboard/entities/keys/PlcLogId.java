package com.sistek.sos.analysis_dashboard.entities.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class PlcLogId implements Serializable {
    @Column(name = "plc_id")
    private String plcId;

    @Column(name = "seq_no")
    private Integer seqNo;
}
