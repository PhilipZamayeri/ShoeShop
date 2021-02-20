/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:25
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Shoe {

    private int id;
    private int stock;
    private Model modelId;
    private Price priceId;
    private Brand brandId;

    public Shoe(int id, int stock, Model modelId, Price priceId, Brand brandId){
        this.id = id;
        this.stock = stock;
        this.modelId = modelId;
        this.priceId = priceId;
        this.brandId = brandId;
    }


    public int getId(){return id;}
    public int getStock(){return stock;}
    public Model getModelId(){return modelId;}
    public Price getPriceId(){return priceId;}
    public Brand getBrandId(){return brandId;}



    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + id +
                ", stock=" + stock +
                ", modelId=" + modelId +
                ", priceId=" + priceId +
                ", brandId=" + brandId +
                '}';
    }
}
