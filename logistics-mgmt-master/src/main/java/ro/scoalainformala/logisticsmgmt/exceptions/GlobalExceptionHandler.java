package ro.scoalainformala.logisticsmgmt.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponse> handleUnprocessableEntityException(final UnprocessableEntityException unprocessableEntityException) {
        log.error("Received an unprocessable entity error", unprocessableEntityException);
        final ErrorResponse errorResponse = new ErrorResponse(
                422,
                unprocessableEntityException.getMessage(),
                Instant.now(),
                UUID.randomUUID().toString()
        );
        return ResponseEntity.unprocessableContent().body(errorResponse);
    }
}
