import jdk.jfr.Category;

/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:52
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Color {

    private int id;
    private String type;

    public Color(int id, String type){

        this.id = id;
        this.type = type;
    }

    public int getId(){return id;}

    public String getType(){return type;}

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
