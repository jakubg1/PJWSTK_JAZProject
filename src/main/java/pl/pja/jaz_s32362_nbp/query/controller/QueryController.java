package pl.pja.jaz_s32362_nbp.query.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pja.jaz_s32362_nbp.query.model.Query;
import pl.pja.jaz_s32362_nbp.query.service.QueryService;

import java.time.LocalDate;

@RestController
@RequestMapping("/rates")
public class QueryController {
    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/average")
    public ResponseEntity<Query> getAverage(@RequestParam LocalDate from, @RequestParam LocalDate to, @RequestParam String currency) {
        return ResponseEntity.ok(queryService.getAverageRate(from, to, currency));
    }
}
