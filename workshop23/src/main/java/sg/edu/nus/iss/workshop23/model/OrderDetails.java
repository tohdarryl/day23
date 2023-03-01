package sg.edu.nus.iss.workshop23.model;

import java.sql.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Integer orderId;
    private Date orderDate;
    private Integer customerId;
    private Double totalPrice;
    private Double discount;
    private Double discountedPrice;
    private Double costPrice;


    public static OrderDetails create(SqlRowSet rs) {
        OrderDetails od = new OrderDetails();
        od.setOrderId(rs.getInt("order_id"));
        od.setOrderDate(rs.getDate("order_date"));
        od.setCustomerId(rs.getInt("customer_id"));
        od.setDiscountedPrice(rs.getDouble("discounted_price"));
        od.setCostPrice(rs.getDouble("cost_price"));
        return od;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("order_id", getOrderId())
                .add("order_date", getOrderDate() != null ? getOrderDate().toString() : "")
                .add("customer_id", getCustomerId())
                .add("discounted_price", getDiscountedPrice().toString())
                .add("cost_price", getCostPrice().toString())
                .build();
    }
}
