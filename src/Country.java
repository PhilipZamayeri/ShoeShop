/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 13:55
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Country {

    private int id;
    private String name;

    public Country(int id, String name){
        this.id = id;
        this.name = name;

    }

    public Country(){}

    public int getId(){return id;}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
