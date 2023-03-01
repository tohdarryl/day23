package sg.edu.nus.iss.workshop23.respository;



import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;



import sg.edu.nus.iss.workshop23.model.OrderDetails;

@Repository
public class OrderRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public static final String selectSQL =
        "select o.id order_id, " +
        "date(o.order_date) order_date, " +
        "o.customer_id customer_id, " +
        "sum(od.quantity * od.unit_price) total_price, " +
        "sum(od.quantity * od.unit_price * od.discount) discount, " + 
        "sum(od.quantity * od.unit_price) - sum(od.quantity * od.unit_price * od.discount) discounted_price, " +
        "sum(od.quantity * p.standard_cost) cost_price " +
        "from orders o " +
        "left join " +
        "order_details od " +
        "on o.id = od.order_id " +
        "left join " +
        "products p " +
        "on od.product_id = p.id " +
        "where o.id = ? ";

        
    public OrderDetails getOrderDetails(Integer id){
        OrderDetails o = new OrderDetails();
        o = jdbcTemplate.queryForObject(selectSQL, BeanPropertyRowMapper.newInstance(OrderDetails.class),id);
        System.out.println(o);
        return o;
        // List<OrderDetails> oDetails = new LinkedList<>();

        // SqlRowSet rs = jdbcTemplate.queryForRowSet(selectSQL,id);

        // while (rs.next()){
        //     oDetails.add(OrderDetails.create(rs));
        // }

        // return oDetails.get(0);
    }
        
    
}
