package ro.scoalainformala.logisticsmgmt.delivery;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import ro.scoalainformala.logisticsmgmt.pckg.PackageDO;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DeliveryRepository deliveryRepository;


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

    @GetMapping("/test")
    private ResponseEntity<?> test() {
        DeliveryDO myDelivery = new DeliveryDO();
        myDelivery.setAddress("addr123");
        myDelivery.setPhoneNumber("0733983631");
        myDelivery.setContactName("Ionut");

        PackageDO package1 = new PackageDO();
        package1.setVolume(1);
        package1.setWeight(2);

        PackageDO package2 = new PackageDO();
        package2.setVolume(10);
        package2.setWeight(4);

        myDelivery.setPackages(List.of(package1, package2));
        package1.setDelivery(myDelivery);
        package2.setDelivery(myDelivery);

        deliveryRepository.save(myDelivery);
        return ResponseEntity.ok("");
    }
}
