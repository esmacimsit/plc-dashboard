package com.sistek.sos.analysis_dashboard.services;

import com.sistek.sos.analysis_dashboard.entities.PlcInfo;
import com.sistek.sos.analysis_dashboard.repositories.PlcInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service // its the service layer (business logic)
public class PlcInfoService {
    private final PlcInfoRepository plcInfoRepository;

    @Autowired // to inject
    public PlcInfoService(PlcInfoRepository plcInfoRepository) {
        this.plcInfoRepository = plcInfoRepository;
    } // constructor injection (safest and suggested)

    private PlcInfo singleRow() { // we know its single row
        return plcInfoRepository.findAll().get(0);
    }

    public String getPlcId() {
        return singleRow().getPlcId(); // return plcid from first row
    } // get plc_id cell

    public String getPlcStatus() {
        PlcInfo plc = singleRow();

        if ("ACTIVE".equals(plc.getStatus())) {
            return "ACTIVE";
        } else {
            DateTimeFormatter ft = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"); // lastStatusDate formatted
            return "Last activity was at " + ft.format(plc.getLastStatusDate());
        } // if its active display status otherwise display laststatusdate
    }
}