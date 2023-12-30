package springdatajpa.service;

import org.springframework.data.domain.Page;
import springdatajpa.model.Delivery;
import springdatajpa.model.Mobile;

import java.util.List;

public interface MobileService {
    Mobile createMobile(Mobile mobile);
    List<Mobile> createBulkMobile(List<Mobile> mobile);
    List<Mobile> getMobiles();
    Page<Mobile> getMobilePagination(Integer pageNumber, Integer pageSize);
    Page<Mobile> getMobilePaginationWithSort(Integer pageNumber, Integer pageSize, String type, String sortProperty);
    List<Delivery> getByDeliveryId(Long id);
    Mobile getMobile(Long id);
}
