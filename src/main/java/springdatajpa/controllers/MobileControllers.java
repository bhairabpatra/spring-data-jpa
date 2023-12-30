package springdatajpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdatajpa.model.Delivery;
import springdatajpa.model.Mobile;
import springdatajpa.model.User;
import springdatajpa.repositery.UserRepository;
import springdatajpa.service.MobileService;
import springdatajpa.service.UserService;

import java.util.List;

@RestController
@RequestMapping("v1/api/")
@CrossOrigin
public class MobileControllers {

    @Autowired
    MobileService mobileService;

    @Autowired
    UserService userService;

    @PostMapping("create")
    public ResponseEntity<Mobile> createMobile(@RequestBody Mobile mobile) {
        Mobile newMobile = mobileService.createMobile(mobile);
        return new ResponseEntity<>(newMobile, HttpStatus.CREATED);
    }

    @PostMapping("createBulk")
    public ResponseEntity<List<Mobile>> createBulkMobile(@RequestBody List<Mobile> mobile) {
        List<Mobile> newMobile = mobileService.createBulkMobile(mobile);
        return new ResponseEntity<>(newMobile, HttpStatus.CREATED);
    }

    @GetMapping(value = "getMobiles")
    public ResponseEntity<List<?>> getMobiles() {
        List<Mobile> mobiles = mobileService.getMobiles();
        if (mobiles != null) {
            return new ResponseEntity<>(mobiles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "pagination/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<Page<Mobile>> pagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        Page<Mobile> mobiles = mobileService.getMobilePagination(pageNumber, pageSize);
        return new ResponseEntity<>(mobiles, HttpStatus.OK);
    }

    @RequestMapping(value = "paginationWithSort/{pageNumber}/{pageSize}/{type}/{sortProperty}", method = RequestMethod.GET)
    public ResponseEntity<Page<Mobile>> pagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String type, @PathVariable String sortProperty) {
        Page<Mobile> mobiles = mobileService.getMobilePaginationWithSort(pageNumber, pageSize, type, sortProperty);
        return new ResponseEntity<>(mobiles, HttpStatus.OK);
    }

    @GetMapping(value = "getMobilesByPin/{pin}")
    public ResponseEntity<List<Delivery>> getMobilesByPin(@PathVariable Long pin) {
        List<Delivery> mobiles = mobileService.getByDeliveryId(pin);
        if (mobiles != null) {
            return new ResponseEntity<>(mobiles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
