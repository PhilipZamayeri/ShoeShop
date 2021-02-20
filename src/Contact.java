/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:54
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Contact {

    private int id;
    private String email;
    private String name;
    private Brand brandId;

    public Contact(int id, String email, String name, Brand brandId){
        this.id = id;
        this.email = email;
        this.name = name;
        this.brandId = brandId;
    }


    public int getId(){return id;}

    public String getEmail(){return email;}

    public String getName(){return name;}

    public Brand getBrandId(){return brandId;}

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", brandId=" + brandId +
                '}';
    }
}
