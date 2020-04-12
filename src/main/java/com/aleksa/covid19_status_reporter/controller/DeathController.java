package com.aleksa.covid19_status_reporter.controller;

import com.aleksa.covid19_status_reporter.model.LocationStats;
import com.aleksa.covid19_status_reporter.service.COVIDDeathToll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeathController {

    @Autowired
    COVIDDeathToll covidDeathToll;

    @GetMapping("/deaths")
    public String death(Model model) {
        List<LocationStats> allStats = covidDeathToll.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "death";
    }
}
