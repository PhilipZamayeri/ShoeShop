/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:23
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Review {

    private int id;
    private String comment;
    private Rating ratingId;
    private Customer customerId;

    public Review(int id, String comment, Rating ratingId, Customer customerId){
        this.id = id;
        this.comment = comment;
        this.ratingId = ratingId;
        this.customerId = customerId;
    }


    public int getId(){return id;}
    public String getComment(){return comment;}
    public Rating getRatingId(){return ratingId;}
    public Customer getCustomerId(){return customerId;}

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", ratingId=" + ratingId +
                ", customerId=" + customerId +
                '}';
    }
}
