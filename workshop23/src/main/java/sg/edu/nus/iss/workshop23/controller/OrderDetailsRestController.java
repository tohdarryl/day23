package sg.edu.nus.iss.workshop23.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.workshop23.model.OrderDetails;
import sg.edu.nus.iss.workshop23.service.OrderService;

@RestController
@RequestMapping(path ="/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsRestController {
    @Autowired
    OrderService oSvc;

    // @GetMapping(path = "/{orderId}")
    // public ResponseEntity<OrderDetails> getOrderDetailsWithDiscountedPrice(@PathVariable("orderId") Integer orderId) {
    //     OrderDetails o = oSvc.getOrderDetails(orderId);
    //     return ResponseEntity
    //             .status(HttpStatus.OK)
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .body(o);
    // }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<String> getOrderDetailsWithDiscountedPrice(@PathVariable("orderId") Integer orderId) {
        OrderDetails o = oSvc.getOrderDetails(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(o.toJSON().toString());
    }

}
