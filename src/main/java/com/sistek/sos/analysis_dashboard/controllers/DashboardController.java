package com.sistek.sos.analysis_dashboard.controllers;

import com.sistek.sos.analysis_dashboard.entities.BarcodeData;
import com.sistek.sos.analysis_dashboard.entities.LineInfo;
import com.sistek.sos.analysis_dashboard.services.BarcodeDataService;
import com.sistek.sos.analysis_dashboard.services.LineInfoService;
import com.sistek.sos.analysis_dashboard.services.PlcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {
    @Autowired // dependency (bean) injection
    private PlcInfoService plcInfoService; // field injection

    @Autowired
    private LineInfoService lineInfoService; // inject another service
    // you dont have to write @Autowired if its constructor injection (other type is setter injection)

    @Autowired
    private BarcodeDataService barcodeDataService;

    @GetMapping("/dashboard") // if /example url triggered by GET request this method runs
    public String dashboardPage(Model model) { // return by dynamic status
        // Fetch the all exist plc information
//        List<PlcInfo> plcInfo = plcInfoService.getPlcInfo(); // fetch filtered or all plcs
        model.addAttribute("plcId", plcInfoService.getPlcId()); // get as ${plcId} on thymeleaf
        model.addAttribute("plcStatus", plcInfoService.getPlcStatus());
//        model.addAttribute("lineAsc", lineInfoService.getAllLinesAsc());

        List<LineInfo> lines = lineInfoService.getAllLinesAsc(); // fetch all ordered
        List<String> lineTexts = lineInfoService.getLineNamesAndStatus(lines);

        model.addAttribute("lineTexts", lineTexts);

        Map<String, List<BarcodeData>> grouped = barcodeDataService.getBarcodesByLine();

        model.addAttribute("groupedBarcodes", grouped);

        return "dashboard"; // render on dashboard.html
    }
}