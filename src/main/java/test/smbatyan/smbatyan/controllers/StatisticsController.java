package test.smbatyan.smbatyan.controllers;

import test.smbatyan.smbatyan.service.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/by-date")
    public ResponseEntity<?> getStatisticsByDate(@RequestParam String startDate, @RequestParam String endDate) {
        return ResponseEntity.ok(statisticsService.getStatisticsByDate(startDate, endDate));
    }
}