/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:47
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Category {

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){return id;}

    public String getName(){return name;}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}