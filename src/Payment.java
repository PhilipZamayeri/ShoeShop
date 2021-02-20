/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:17
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Payment {

    private int id;
    private String method;

    public Payment(int id, String method){
        this.id = id;
        this.method = method;
    }

    public int getId(){return id;}
    public String getMethod(){return method;}

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", method='" + method + '\'' +
                '}';
    }
}
