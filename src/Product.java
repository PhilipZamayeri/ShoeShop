/**
 * Created by Philip Zamayeri
 * Date: 2021-02-19
 * Time: 13:55
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Product {

    private int id;
    private Price price;
    private Color color;
    private Sizing size;
    private Model model;
    private Brand brand;

    public Product(int id, Price price, Color color, Sizing size, Model model, Brand brand) {
        this.id = id;
        this.price = price;
        this.color = color;
        this.size = size;
        this.model = model;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public Sizing getSize() {
        return size;
    }

    public Model getModel() {
        return model;
    }

    public Brand getBrand() {
        return brand;

    }




    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", color=" + color +
                ", size=" + size +
                ", model=" + model +
                ", brand=" + brand +
                '}';
    }
}
