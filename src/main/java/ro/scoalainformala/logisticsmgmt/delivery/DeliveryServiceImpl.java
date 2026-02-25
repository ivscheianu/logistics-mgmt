package ro.scoalainformala.logisticsmgmt.delivery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, ModelMapper modelMapper) {
        this.deliveryRepository = deliveryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DeliveryDTO> getAllDeliveries() {
        List<DeliveryDO> allDeliveriesFromDatabase = deliveryRepository.findAll();
        List<DeliveryDTO> deliveriesForUI = new ArrayList<>();
        for (DeliveryDO deliveryDO : allDeliveriesFromDatabase) {
            // fixed by @SQLRestriction annotation from DeliveryDO
//            if (!deliveryDO.isEnabled()) {
//                continue;
//            }
            final DeliveryDTO deliveryDTO = new DeliveryDTO();
            mapDOToDTO(deliveryDO, deliveryDTO);
            deliveriesForUI.add(deliveryDTO);
        }
        return deliveriesForUI;
    }

    @Override
    public DeliveryDTO saveDelivery(final DeliveryDTO deliveryDTO) {
        final DeliveryDO deliveryTobeSaved = new DeliveryDO();
        mapDTOToDO(deliveryDTO, deliveryTobeSaved);
        DeliveryDO savedDelivery = deliveryRepository.save(deliveryTobeSaved);
        DeliveryDTO savedDTO = new DeliveryDTO();
        mapDOToDTO(savedDelivery, savedDTO);
        return savedDTO;
    }

    @Override
    public DeliveryDTO updateDelivery(DeliveryDTO updatedDelivery, Long deliveryId) {
        updatedDelivery.setId(deliveryId);
        Optional<DeliveryDO> deliveryFromDatabase = deliveryRepository.findById(deliveryId);
        if (deliveryFromDatabase.isPresent()) {
            DeliveryDO deliveryDO = deliveryFromDatabase.get();
            BeanUtils.copyProperties(updatedDelivery, deliveryDO);
            deliveryRepository.save(deliveryDO);
            return updatedDelivery;
        } else {
            throw new RuntimeException("Delivery with id = " + deliveryId + " does not exist");
        }
    }

    @Override
    public void delete(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }

    // soft deleted handled by @SQLDelete from DeliveryDO
//    @Override
//    public void softDelete(Long deliveryId) {
//        deliveryRepository
//                .findById(deliveryId)
//                .ifPresent(foundDelivery -> {
//                    foundDelivery.setEnabled(false);
//                    deliveryRepository.save(foundDelivery);
//                });
//    }

    @Override
    public DeliveryDTO getById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(foundDelivery -> {
                    // fixed by @SQLRestriction annotation from DeliveryDO
//                    if (!foundDelivery.isEnabled()) {
//                        return null;
//                    }
                    final DeliveryDTO deliveryDTO = new DeliveryDTO();
                    mapDOToDTO(foundDelivery, deliveryDTO);
                    return deliveryDTO;
                })
                .orElse(null);
    }

    private void mapDTOToDO(DeliveryDTO deliveryDTO, DeliveryDO deliveryTobeSaved) {
//        deliveryTobeSaved.setStatus(deliveryDTO.getStatus());
//        deliveryTobeSaved.setCourierName(deliveryDTO.getCourierName());
//        deliveryTobeSaved.setContactName(deliveryDTO.getContactName());
//        deliveryTobeSaved.setPhoneNumber(deliveryDTO.getPhoneNumber());
//        deliveryTobeSaved.setAddress(deliveryDTO.getAddress());
//        deliveryTobeSaved.setNote(deliveryDTO.getNote());
        modelMapper.map(deliveryDTO, deliveryTobeSaved);
    }

    private void mapDOToDTO(DeliveryDO deliveryDO, DeliveryDTO deliveryDTO) {
//        deliveryDTO.setId(deliveryDO.getId());
//        deliveryDTO.setStatus(deliveryDO.getStatus());
//        deliveryDTO.setCourierName(deliveryDO.getCourierName());
//        deliveryDTO.setContactName(deliveryDO.getContactName());
//        deliveryDTO.setPhoneNumber(deliveryDO.getPhoneNumber());
//        deliveryDTO.setAddress(deliveryDO.getAddress());
//        deliveryDTO.setNote(deliveryDO.getNote());
        modelMapper.map(deliveryDO, deliveryDTO);
    }
}
