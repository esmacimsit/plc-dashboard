package com.sistek.sos.analysis_dashboard.entities.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// must if there are multiple pks
@Embeddable
@NoArgsConstructor
@Data

public class BarcodeDataId implements Serializable { // a marker interface (empty)
    @Column(name = "barcode")
    private String barcode;

    @Column(name = "line_id")
    private String lineId;
}