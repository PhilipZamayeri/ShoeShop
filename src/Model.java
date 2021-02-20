/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:11
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Model {

    private int id;
    private String name;
    private int year;

    public Model(int id, String name, int year){
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public int getYear(){return year;}

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
