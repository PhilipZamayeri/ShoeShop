/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:27
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Sizing {

    private int id;
    private String sizingSys;
    private int size;

    public Sizing(int id, String sizingSys, int size){
        this.id = id;
        this.sizingSys = sizingSys;
        this.size = size;
    }


    public int getId(){return id;}
    public String getSizingSys(){return sizingSys;}
    public int getSize(){return size;}

    @Override
    public String toString() {
        return "Sizing{" +
                "id=" + id +
                ", sizingSys='" + sizingSys + '\'' +
                ", size=" + size +
                '}';
    }
}
