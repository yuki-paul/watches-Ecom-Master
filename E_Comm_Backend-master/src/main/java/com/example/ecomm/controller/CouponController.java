package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Coupon;
import com.example.ecomm.entity.Event;
import com.example.ecomm.repository.CouponRepository;
import com.example.ecomm.repository.EventRepository;

@RestController
@CrossOrigin
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/GetAllCoupon")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(couponRepository.findAll());
    }

    @PostMapping("/Addcoupon")
    public ResponseEntity<?> add(@RequestBody Coupon coupon) {
        if (coupon.getEventId() != null) {
            Event event = eventRepository.getReferenceById(coupon.getEventId());
            coupon.setExpireDate(event.getEventExpireDate());
        }
        couponRepository.save(coupon);
        return ResponseEntity.ok("Coupon Added");
    }
    
    @GetMapping("/GetCouponDiscount/{couponCode}")
    public int getDiscount(@PathVariable String couponCode){
        return couponRepository.getCouponDiscount(couponCode);
    }
    
    @DeleteMapping("/deleteCoupon/{id}")
    public String delete(@PathVariable int id) {
    	couponRepository.deleteById(id);
    	return "coupon deleted Successfully";
    }
    

}
