package pl.pja.jaz_s32362_nbp.query.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import pl.pja.jaz_s32362_nbp.query.exception.InvalidQueryException;
import pl.pja.jaz_s32362_nbp.query.exception.NoRatesFoundException;
import pl.pja.jaz_s32362_nbp.query.exception.QueryFailedException;

import java.net.ConnectException;

@RestControllerAdvice
public class QueryAdvice {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Void> handleClientError(HttpClientErrorException e) {
        return ResponseEntity.status(e.getStatusCode()).build();
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Void> handleServerError(HttpServerErrorException e) {
        return ResponseEntity.status(502).build();
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Void> handleConnectionError(ConnectException e) {
        return ResponseEntity.status(504).build();
    }

    @ExceptionHandler(InvalidQueryException.class)
    public ResponseEntity<Void> handleInvalidQuery(InvalidQueryException e) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(QueryFailedException.class)
    public ResponseEntity<Void> handleQueryFailed(QueryFailedException e) {
        return ResponseEntity.status(502).build();
    }

    @ExceptionHandler(NoRatesFoundException.class)
    public ResponseEntity<Void> handleNoRatesFound(NoRatesFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
