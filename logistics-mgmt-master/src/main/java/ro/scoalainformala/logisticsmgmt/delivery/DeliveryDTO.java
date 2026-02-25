package ro.scoalainformala.logisticsmgmt.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * The representation of a Delivery concept for the exterior world
 * e.g: clients (browsers, mobile apps, etc.).
 * Usually a subset of fields of the DO
 */
@Data
public class DeliveryDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeliveryStatus status = DeliveryStatus.INITIATED;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String courierName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String courierContact;

    @NotBlank
    private String contactName;

    @Size(min = 10, max = 12, message = "Phone number should be between 10 and 12 characters")
    private String phoneNumber;

    @NotBlank
    private String address;

    private String note;
}
