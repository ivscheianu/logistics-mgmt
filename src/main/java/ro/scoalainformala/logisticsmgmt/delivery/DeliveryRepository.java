package ro.scoalainformala.logisticsmgmt.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<DeliveryDO, Long> {
    List<DeliveryDO> findDeliveryDOByStatus(DeliveryStatus deliveryStatus);
    List<DeliveryDO> findDeliveryDOByStatusEqualsAndContactNameContainingAndAddressStartsWith(DeliveryStatus status, String contactName, String address);
}
