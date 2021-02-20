/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:45
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Brand {

    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){return id;}

    public String getName(){return name;}

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
