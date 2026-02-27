package ro.scoalainformala.logisticsmgmt.delivery;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;
import ro.scoalainformala.logisticsmgmt.pckg.PackageDO;

import java.time.Instant;
import java.util.List;


/**
 * The representation of a Delivery concept for our internal matters.
 * Should NEVER be exposed to the exterior world. e.g: clients (browsers, mobile apps, etc.)
 */
@Data
@SQLDelete(sql = "UPDATE delivery SET enabled = false WHERE id = ?")
@SQLRestriction("enabled <> false")
@Entity(name = "delivery")
public class DeliveryDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DeliveryStatus status;

    private String courierName;

    private String courierContact;

    @OneToMany(
            mappedBy = "delivery",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PackageDO> packages;

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
