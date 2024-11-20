package test.smbatyan.smbatyan.config;

import test.smbatyan.smbatyan.service.StatisticsService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerConfig {
    private final StatisticsService statisticsService;

    public SchedulerConfig(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void updateDatabaseFromFile() {
        statisticsService.updateStatisticsFromFile();
    }
}