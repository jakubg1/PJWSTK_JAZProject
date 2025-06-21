package pl.pja.jaz_s32362_nbp.query.service;

import org.springframework.stereotype.Service;
import pl.pja.jaz_s32362_nbp.Currency;
import pl.pja.jaz_s32362_nbp.query.model.Query;
import pl.pja.jaz_s32362_nbp.query.repository.QueryRepository;

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
