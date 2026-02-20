package ro.scoalainformala.logisticsmgmt.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;


/**
 * The representation of a Delivery concept for our internal matters.
 * Should NEVER be exposed to the exterior world. e.g: clients (browsers, mobile apps, etc.)
 */
@Data
@Entity(name = "delivery")
public class DeliveryDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DeliveryStatus status;

    private String courierName;

    private String courierContact;

//    private List<PackageDO> packages;

    private String contactName;

    private String phoneNumber;

    private String address;

    private String note;

    private Instant plannedDelivery;

    private Instant actualDelivery;

    private boolean enabled = true;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updateAt;
}
