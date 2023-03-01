package sg.edu.nus.iss.workshop23.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop23.model.OrderDetails;
import sg.edu.nus.iss.workshop23.respository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo oRepo;

    public OrderDetails getOrderDetails(Integer id){
        return oRepo.getOrderDetails(id);
}
}
