package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.entities.PlcInfo;
import com.sistek.sos.analysis_dashboard.repositories.PlcInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service // its the service layer (business logic)
public class PlcInfoService {
    private final PlcInfoRepository plcInfoRepository;

    @Autowired // to inject
    public PlcInfoService(PlcInfoRepository plcInfoRepository) {
        this.plcInfoRepository = plcInfoRepository;
    } // constructor injection (safest and suggested)

    public List<PlcInfo> getPlcInfo() {
        return plcInfoRepository.findAll();
    } // SELECT * FROM plc_info

//    public PlcInfo getPlcInfoById(String plcId) {
//        return plcInfoRepository.findById(plcId).orElse(null);
//    } // get primary key if its found

    public String getPlcId() {
        return plcInfoRepository.findAll().get(0).getPlcId(); // return plcid from first row
    } // get plc_id cell

    public String getPlcStatus() {
        PlcInfo plc = plcInfoRepository.findAll().get(0); // we know its single row

        if ("ACTIVE".equals(plc.getStatus())) {
            return "ACTIVE";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm") // lastStatusDate formatted
                    .withZone(ZoneId.of("Europe/Istanbul"));
            return formatter.format(plc.getLastStatusDate());
        } // if its active display status otherwise display laststatusdate
    }


}