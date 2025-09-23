package com.sistek.sos.analysis_dashboard.controllers;

import com.sistek.sos.analysis_dashboard.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public String unifiedLogs(Model model) {
        model.addAttribute("logs", logService.getUnifiedLogs());
        return "logs"; // templates/logs.html
    }
}
//@GetMapping("/logs")
//@ResponseBody
//public String probe() { return "logs-ok"; }

