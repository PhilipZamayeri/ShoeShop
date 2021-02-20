/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:34
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Added {
    private int id;
    private Shoe shoeId;
    private Orders orderId;

    public Added(int id, Shoe shoeId, Orders orderId) {
        this.id = id;
        this.shoeId = shoeId;
        this.orderId = orderId;

    }

    public Added() {
    }

    public int getId() {
        return id;
    }

    public Shoe getShoeId() {
        return shoeId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Added{" +
                "id=" + id +
                ", shoeId=" + shoeId +
                ", orderId=" + orderId +
                '}';
    }
}

