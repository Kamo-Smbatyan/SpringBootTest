package test.smbatyan.smbatyan.service;

import test.smbatyan.smbatyan.model.Statistics;
import test.smbatyan.smbatyan.repository.StatisticsRepository;
import test.smbatyan.smbatyan.util.*;

import java.io.IOException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    private final StatisticsRepository repository;
    private final JsonUtil jsonUtil;

    public StatisticsService(StatisticsRepository repository, JsonUtil jsonUtil) {
        this.repository = repository;
        this.jsonUtil = jsonUtil;
    }

    @Cacheable(value = "statisticsByDate", key = "#startDate + '-' + #endDate")
    public List<Statistics> getStatisticsByDate(String startDate, String endDate) {
        return repository.findByDateBetween(startDate, endDate);
    }

    public List<Statistics> getAllStatistics() {
        return repository.findAll();
    }

    public void updateStatisticsFromFile() {
        try {
            // Parse JSON data from the file
            List<Statistics> newStatistics = jsonUtil.parseStatisticsFromFile("src/main/resources/test_report.json");

            // Save or update statistics in the database
            repository.saveAll(newStatistics);

            System.out.println("Statistics updated from file successfully.");
        } catch (IOException e) {
            System.err.println("Failed to update statistics: " + e.getMessage());
        }
    }
}