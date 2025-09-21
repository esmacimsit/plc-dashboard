package com.sistek.sos.analysis_dashboard.entities;

import com.sistek.sos.analysis_dashboard.entities.keys.BarcodeDataId;
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
@Table(name = "barcode_data")

public class BarcodeData {
    @EmbeddedId
    private BarcodeDataId barcodeId;

    @Column(name = "last_status_date", nullable = false)
    private LocalDateTime lastStatusDate;

    @Column(name = "cre_date", nullable = false)
    private LocalDateTime creDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "api_result", nullable = false)
    private String apiResult;

    public String getLineId() {
        return barcodeId != null ? barcodeId.getLineId() : null;
    }

//    public String getBarcode() {
//        return barcodeId != null ? barcodeId.getBarcode() : null;
//    }
}
