package ro.scoalainformala.logisticsmgmt.delivery;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDTO> getAllDeliveries();

    DeliveryDTO saveDelivery(DeliveryDTO delivery);

    DeliveryDTO updateDelivery(DeliveryDTO updatedDelivery, Long id);

    void delete(Long deliveryId);
}
