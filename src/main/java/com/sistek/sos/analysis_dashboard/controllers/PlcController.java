package com.sistek.sos.analysis_dashboard.controllers;

import com.sistek.sos.analysis_dashboard.entities.PlcInfo;
import com.sistek.sos.analysis_dashboard.services.PlcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlcController {
    @Autowired // dependency (bean) injection
    private PlcInfoService plcInfoService; // field injection
    // you dont have to write @Autowired if its constructor injection (other type is setter injection)
    @GetMapping("/dashboard") // if /example url triggered by GET request this method runs
    public String examplePage(Model model) { // return by dynamic status
        // Fetch the all exist plc information
        List<PlcInfo> plcInfoList = plcInfoService.getAllPlcInfo(); // fetch filtered or all plcs

        model.addAttribute("message", "We have " + plcInfoList.size() + " PLCs in the system.");
        model.addAttribute("plcList", plcInfoList);

        return "dashboard"; // render on dashboard.html
    }
}