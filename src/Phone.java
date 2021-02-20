/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:18
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Phone {

    private int id;
    private String number;
    private Contact contactId;

    public Phone(int id, String number, Contact contactId){
        this.id = id;
        this.number = number;
        this.contactId = contactId;
    }

    public int getId(){return id;}
    public String getNumber(){return number;}
    public Contact getContactId(){return contactId;}

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", contactId=" + contactId +
                '}';
    }
}
