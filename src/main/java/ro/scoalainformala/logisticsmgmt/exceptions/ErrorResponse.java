package ro.scoalainformala.logisticsmgmt.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
public class ErrorResponse {

    private final int statusCode;
    private final String message;
    private final Instant timestamp;
    private final String requestId;
}
