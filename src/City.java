/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 15:47
 * Project: ShoeShop
 * Copyright: MIT
 */
public class City {

    private int id;
    private String name;
    private String address;
    private String zip_code;
    private Country countryId;

    public City(int id, String name, String address, String zip_code, Country countryId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip_code = zip_code;
        this.countryId = countryId;
    }

    public int getId(){return id;}

    public String getName(){return name;}

    public String getAddress(){return address;}

    public String getZip_code(){return zip_code;}

    public Country getCountryId(){return countryId;}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}