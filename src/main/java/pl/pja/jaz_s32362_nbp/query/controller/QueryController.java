package pl.pja.jaz_s32362_nbp.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get average exchange rate", description = "Get average exchange rate over provided period of time for specific currency. Uses https://api.nbp.pl to fetch data. Successful query results are saved in the database.")
    @Parameter(name = "from", description = "Starting date (inclusive)", example = "2022-01-01")
    @Parameter(name = "to", description = "Final date (inclusive)", example = "2022-06-11")
    @Parameter(name = "currency", description = "Currency for which exchange rate should be provided (always relative to PLN)", example = "chf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters were provided.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "404", description = "No data is available for the provided parameters.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error. This should never happen.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "502", description = "External service has trouble fetching data, is either down, or has returned no response.", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "504", description = "Server cannot connect to the external service.", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @GetMapping("/average")
    public ResponseEntity<Query> getAverage(@RequestParam LocalDate from, @RequestParam LocalDate to, @RequestParam String currency) {
        return ResponseEntity.ok(queryService.getAverageRate(from, to, currency));
    }
}
