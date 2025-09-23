package com.sistek.sos.analysis_dashboard.entities.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class LineLogId implements Serializable {
    @Column(name = "line_id")
    private String lineId;
    @Column(name = "seq_no")
    private Integer seqNo;
}