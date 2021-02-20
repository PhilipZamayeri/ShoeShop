/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:10
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Lives {

    private int id;
    private Customer customerId;
    private City cityId;

    public Lives(int id, Customer customerId, City cityId){
        this.id = id;
        this.customerId = customerId;
        this.cityId = cityId;
    }

    public int getId(){return id;}
    public Customer getCustomerId(){return customerId;}
    public City getCityId(){return cityId;}

    @Override
    public String toString() {
        return "Lives{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", cityId=" + cityId +
                '}';
    }
}
