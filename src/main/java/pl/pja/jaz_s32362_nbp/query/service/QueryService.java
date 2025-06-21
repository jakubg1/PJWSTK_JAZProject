package pl.pja.jaz_s32362_nbp.query.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pja.jaz_s32362_nbp.nbp.Rate;
import pl.pja.jaz_s32362_nbp.nbp.RateSeries;
import pl.pja.jaz_s32362_nbp.query.exception.InvalidQueryException;
import pl.pja.jaz_s32362_nbp.query.exception.NoRatesFoundException;
import pl.pja.jaz_s32362_nbp.query.exception.QueryFailedException;
import pl.pja.jaz_s32362_nbp.query.model.Query;
import pl.pja.jaz_s32362_nbp.query.repository.QueryRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class QueryService {
    private final QueryRepository queryRepository;

    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public Query getAverageRate(LocalDate from, LocalDate to, String currency) {
        if (from.isAfter(to)) {
            throw new InvalidQueryException();
        }
        Query query = new Query();
        query.setStartDate(from);
        query.setEndDate(to);
        query.setCurrency(currency);
        query.setQueryTime(LocalDateTime.now());
        query.setRate(getRate(from, to, currency));
        queryRepository.save(query);
        return query;
    }

    private double getRate(LocalDate from, LocalDate to, String currency) {
        RestTemplate restTemplate = new RestTemplate();
        RateSeries rateSeries = restTemplate.getForObject("https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + from + "/" + to, RateSeries.class);
        if (rateSeries == null) {
            throw new QueryFailedException();
        }
        ArrayList<Rate> rates = rateSeries.getRates();
        if (rates.isEmpty()) {
            throw new NoRatesFoundException();
        }
        double result = 0;
        for (Rate rate : rates) {
            result += rate.getMid();
        }
        return result / rates.size();
    }
}
