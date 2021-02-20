/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:00
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Customer {

    private int id;
    private String name;
    private String ssn;
    private String number;
    private Payment paymentId;

    public Customer(int id, String name, String ssn, String number, Payment paymentId){
        this.id = id;
        this.name = name;
        this.ssn = ssn;
        this.number = number;
        this.paymentId = paymentId;
    }


    public int getId(){return id;}
    public String getName(){return name;}
    public String getSsn(){return ssn;}
    public String getNumber(){return number;}
    public Payment getPaymentId(){return paymentId;}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", number='" + number + '\'' +
                ", paymentId=" + paymentId +
                '}';
    }
}
