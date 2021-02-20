

/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:41
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Belongs {

    private int id;
    private Shoe shoeId;
    private Category categoryId;

    public Belongs(int id, Shoe shoeId, Category categoryId) {
        this.id = id;
        this.shoeId = shoeId;
        this.categoryId = categoryId;

    }

    public int getId(){return id;}

    public Shoe getShoeId(){return shoeId;}

    public Category getCategoryId(){return categoryId;}

    @Override
    public String toString() {
        return "Belongs{" +
                "id=" + id +
                ", shoeId=" + shoeId +
                ", categoryId=" + categoryId +
                '}';
    }
}
