package ro.scoalainformala.logisticsmgmt.delivery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.scoalainformala.logisticsmgmt.exceptions.NotFoundException;
import ro.scoalainformala.logisticsmgmt.exceptions.UnprocessableEntityException;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<DeliveryDTO> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{deliveryId}")
    public DeliveryDTO getDeliveryById(@PathVariable("deliveryId") Long deliveryId) {
        return deliveryService.getById(deliveryId);
    }

    @PostMapping
    public DeliveryDTO createDelivery(@Validated @RequestBody DeliveryDTO delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    @PutMapping("/{deliveryId}")
    public DeliveryDTO updateDelivery(@Validated @RequestBody DeliveryDTO updatedDelivery, @PathVariable("deliveryId") Long deliveryId) {
        return deliveryService.updateDelivery(updatedDelivery, deliveryId);
    }

    @DeleteMapping("/{deliveryId}")
    public void deleteDelivery(@PathVariable("deliveryId") Long deliveryId) {
        deliveryService.delete(deliveryId);
    }

//    @DeleteMapping("/soft-delete/{deliveryId}")
//    private void softDelete(@PathVariable("deliveryId") Long deliveryId) {
//        deliveryService.softDelete(deliveryId);
//    }
}
