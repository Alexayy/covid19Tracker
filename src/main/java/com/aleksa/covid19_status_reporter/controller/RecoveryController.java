package com.aleksa.covid19_status_reporter.controller;

import com.aleksa.covid19_status_reporter.model.LocationStats;
import com.aleksa.covid19_status_reporter.service.COVIDRecovered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecoveryController {
    @Autowired
    COVIDRecovered covidRecovered;

    @GetMapping("/recovery")
    public String recovery(Model model) {
        List<LocationStats> allStats = covidRecovered.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "recovery";
    }
}
