package test.smbatyan.smbatyan.repository;

import test.smbatyan.smbatyan.model.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, String> {
    List<Statistics> findByDateBetween(String startDate, String endDate);
}