/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:22
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Receives {

    private int id;
    private Shoe shoeId;
    private Review reviewId;

    public Receives(int id, Shoe shoeId, Review reviewId){
        this.id = id;
        this.shoeId = shoeId;
        this.reviewId = reviewId;
    }

    public int getId(){return id;}
    public Shoe getShoeId(){return shoeId;}
    public Review getReviewId(){return reviewId;}

    @Override
    public String toString() {
        return "Receives{" +
                "id=" + id +
                ", shoeId=" + shoeId +
                ", reviewId=" + reviewId +
                '}';
    }
}
