package pl.pja.jaz_s32362_nbp;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class QueryService {
    private final QueryRepository queryRepository;

    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
        Query query = new Query();
        query.setStartDate(LocalDate.of(2025, 6, 11));
        query.setEndDate(LocalDate.of(2025, 6, 20));
        query.setCurrency(Currency.USD);
        query.setRate(new BigDecimal("3.52"));
        query.setQueryTime(LocalDateTime.of(2025, 6, 21, 12, 54));
        queryRepository.save(query);
    }
}
