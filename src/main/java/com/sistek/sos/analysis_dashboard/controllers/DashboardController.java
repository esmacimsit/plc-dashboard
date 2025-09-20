package com.sistek.sos.analysis_dashboard.controllers;

import com.sistek.sos.analysis_dashboard.services.PlcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired // dependency (bean) injection
    private PlcInfoService plcInfoService; // field injection
    // you dont have to write @Autowired if its constructor injection (other type is setter injection)
    @GetMapping("/dashboard") // if /example url triggered by GET request this method runs
    public String dashboardPage(Model model) { // return by dynamic status
        // Fetch the all exist plc information
//        List<PlcInfo> plcInfo = plcInfoService.getPlcInfo(); // fetch filtered or all plcs
        model.addAttribute("plcId", plcInfoService.getPlcId()); // get as ${plcId} on thymeleaf
        model.addAttribute("plcInfo", plcInfoService.getPlcStatus());

        return "dashboard"; // render on dashboard.html
    }
}