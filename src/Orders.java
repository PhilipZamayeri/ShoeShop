import java.time.LocalDateTime;

/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:12
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Orders {

    private int id;
    private String orderDate;
    private Customer customerId;

    public Orders(int id, String orderDate, Customer customerId){
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public int getId(){return id;}
    public String getOrderDate(){return orderDate;}
    public Customer getCustomerId(){return customerId;}

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", customerId=" + customerId +
                '}';
    }

}
