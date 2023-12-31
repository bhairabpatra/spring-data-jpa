package springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springdatajpa.model.Delivery;
import springdatajpa.model.Mobile;
import springdatajpa.repositery.DeliveryRepository;
import springdatajpa.repositery.MobileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    MobileRepository mobileRepository;
    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public Mobile createMobile(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    @Override
    public List<Mobile> createBulkMobile(List<Mobile> mobile) {
        return mobileRepository.saveAll(mobile);
    }

    @Override
    public List<Mobile> getMobiles() {
        return mobileRepository.findAll();
    }

    @Override
    public Page<Mobile> getMobilePagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return mobileRepository.findAll(pageable);
    }

    @Override
    public Page<Mobile> getMobilePaginationWithSort(Integer pageNumber, Integer pageSize, String type, String sortProperty) {
        Pageable pageable = null;
        if (type.equalsIgnoreCase("ASC")) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, sortProperty);
        }
        return mobileRepository.findAll(pageable);
    }

    @Override
    public List<Delivery> getByDeliveryId(Long pin) {
          List<Delivery> mob = deliveryRepository.findByPin(pin);
          return mob;
    }

    @Override
    public Mobile getMobile(Long id) {
        Optional<Mobile> mobile = mobileRepository.findById(id);
        return mobile.get();
    }
}