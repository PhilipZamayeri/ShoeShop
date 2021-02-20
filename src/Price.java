/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:19
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Price {

    private int id;
    private int amount;

    public Price(int id, int amount){
        this.id = id;
        this.amount = amount;
    }

    public int getId(){return id;}
    public int getAmount(){return amount;}

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
