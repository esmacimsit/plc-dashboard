package com.sistek.sos.analysis_dashboard.controllers;

import com.sistek.sos.analysis_dashboard.services.BarcodeDataService;
import com.sistek.sos.analysis_dashboard.services.LineInfoService;
import com.sistek.sos.analysis_dashboard.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // spring mvc controller, http request to view
public class IndexController {
    @Autowired
    private LineInfoService lineInfoService;

    @Autowired
    private LogService logService;

    @Autowired
    private BarcodeDataService barcodeDataService;

    @GetMapping("/") // GET request, triggered when page loads or user refreshes
    public String examplePage(Model model) { // you can reach here on thymeleaf with ${}
        model.addAttribute("message", "Welcome to Analysis Dashboard");
        model.addAttribute("runningLines", lineInfoService.getRunningLineCount());
        model.addAttribute("stoppedLines", lineInfoService.getStoppedLineCount());
        model.addAttribute("activeLines", lineInfoService.getTotalLineCount());

        model.addAttribute("totalLogs", logService.getTotalLogCount());
        model.addAttribute("errorCount", logService.getActiveErrorCount());
        model.addAttribute("totalBarcodes", barcodeDataService.getTotalBarcodeCount());

        model.addAttribute("recentActivities", logService.getRecentActivities(5));
        return "index"; // display it on index.html
    }
}