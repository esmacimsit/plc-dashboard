package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.entities.BarcodeData;
import com.sistek.sos.analysis_dashboard.repositories.BarcodeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class BarcodeDataService {
    private final BarcodeDataRepository barcodeDataRepository;

    @Autowired
    public BarcodeDataService(BarcodeDataRepository barcodeDataRepository) {
        this.barcodeDataRepository = barcodeDataRepository;
    }

    public List<BarcodeData> getAllBarcodeData() {
        return barcodeDataRepository.findAllByOrderByBarcodeIdLineIdAsc();
    }

    public Map<String, List<BarcodeData>> getBarcodesByLine() {
        return barcodeDataRepository.findAllByOrderByBarcodeIdLineIdAsc().stream()
                .collect(Collectors.groupingBy(
                        BarcodeData::getLineId,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    public long getTotalBarcodeCount() {
        return barcodeDataRepository.count();
    }

//    public long getBarcodeCountByLine(String lineId) {
//        return barcodeDataRepository.countByBarcodeId_LineId(lineId);
//    }
}