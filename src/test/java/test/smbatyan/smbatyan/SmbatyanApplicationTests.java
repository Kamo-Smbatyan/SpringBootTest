package test.smbatyan.smbatyan;

import test.smbatyan.smbatyan.model.Statistics;
import test.smbatyan.smbatyan.repository.StatisticsRepository;
import test.smbatyan.smbatyan.service.StatisticsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test") // Use the "test" profile
class SmbatyanApplicationTests {

    @Autowired
    private StatisticsService statisticsService;

    @MockBean
    private StatisticsRepository statisticsRepository;

    @Test
    void contextLoads() {
        // Test if the application context loads without errors
        assertThat(statisticsService).isNotNull();
        assertThat(statisticsRepository).isNotNull();
    }

    @Test
    void testGetAllStatistics() {
        // Mock repository behavior
        when(statisticsRepository.findAll()).thenReturn(Collections.emptyList());

        // Call the service method
        List<Statistics> statistics = statisticsService.getAllStatistics();

        // Assert the result
        assertThat(statistics).isEmpty();
        Mockito.verify(statisticsRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testGetStatisticsByDate() {
        // Mock repository behavior
        String startDate = "2024-01-01";
        String endDate = "2024-01-31";

        when(statisticsRepository.findByDateBetween(startDate, endDate))
                .thenReturn(Collections.emptyList());

        // Call the service method
        List<Statistics> statistics = statisticsService.getStatisticsByDate(startDate, endDate);

        // Assert the result
        assertThat(statistics).isEmpty();
        Mockito.verify(statisticsRepository, Mockito.times(1))
                .findByDateBetween(startDate, endDate);
    }
}
