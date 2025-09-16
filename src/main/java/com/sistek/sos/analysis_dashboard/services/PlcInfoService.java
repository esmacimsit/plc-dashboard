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

//    public  List<PlcInfo> getPlcInfoByStatus(String status) {
//        return plcInfoRepository.findByStatus(status);
//    } // no need to write this, jpa magic

    public List<PlcInfo> getPlcInfoByStatus(String status, String sortOrder){
        List<PlcInfo> result;
        if (status == null || status.isEmpty() || status.equals("ALL")){ // defaultly fetch all
            result = getAllPlcInfo();
        } else{
            result = plcInfoRepository.findByStatus(status); // get by status, jpa automatically produced sql query
        }

        if ("oldest".equals(sortOrder)) { // lambda comparator
            result.sort((p1, p2) -> p1.getLastStatusDate().compareTo(p2.getLastStatusDate())); // p1 < p2 (oldest)
        } else {
            result.sort((p1, p2) -> p2.getLastStatusDate().compareTo(p1.getLastStatusDate())); // p2 < p1 (newest)
        }
        return result;
    }
}