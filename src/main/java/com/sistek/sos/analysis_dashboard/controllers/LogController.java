package com.sistek.sos.analysis_dashboard.controllers;

import com.sistek.sos.analysis_dashboard.services.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public String unifiedLogs(
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String lineId,
            @RequestParam(required = false) String status,
            Model model) {

        var logs = logService.getUnifiedLogs(source, lineId, status, null, null);
        model.addAttribute("logs", logs);
        model.addAttribute("source", source);
        model.addAttribute("lineId", lineId);
        model.addAttribute("status", status);
        return "logs";
    }
}
