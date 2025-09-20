package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.entities.PlcInfo;
import com.sistek.sos.analysis_dashboard.repositories.PlcInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // its the service layer (business logic)
public class PlcInfoService {
    private final PlcInfoRepository plcInfoRepository;

    @Autowired // to inject
    public PlcInfoService(PlcInfoRepository plcInfoRepository) {
        this.plcInfoRepository = plcInfoRepository;
    } // constructor injection (safest and suggested)

    public List<PlcInfo> getAllPlcInfo() {
        return plcInfoRepository.findAll();
    } // SELECT * FROM plc_info

    public PlcInfo getPlcInfoById(String plcId) {
        return plcInfoRepository.findById(plcId).orElse(null);
    } // search by primary key if its found
}