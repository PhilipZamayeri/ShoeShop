/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:15
 * Project: ShoeShop
 * Copyright: MIT
 */
public class OutOfStock {

    private int id;
    private Shoe shoeId;
    private String outOfDate;

    public OutOfStock(int id, Shoe shoeId, String outOfDate){
        this.id = id;
        this.shoeId = shoeId;
        this.outOfDate = outOfDate;
    }


    public int getId(){return id;}
    public Shoe getShoeId(){return shoeId;}
    public String getOutOfDate(){return outOfDate;}

    @Override
    public String toString() {
        return "OutOfStock{" +
                "id=" + id +
                ", shoeId=" + shoeId +
                ", outOfDate='" + outOfDate + '\'' +
                '}';
    }
}
