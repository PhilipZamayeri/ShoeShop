/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:04
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Has {

    private int id;
    private Sizing sizingId;
    private Color colorId;
    private Shoe shoeId;

    public Has(int id, Sizing sizingId, Color colorId, Shoe shoeId){
        this.id = id;
        this.sizingId = sizingId;
        this.colorId = colorId;
        this.shoeId = shoeId;
    }

    public int getId(){return id;}
    public Sizing getSizingId(){return sizingId;}
    public Color getColorId(){return colorId;}
    public Shoe getShoeId(){return shoeId;}

    @Override
    public String toString() {
        return "Has{" +
                "id=" + id +
                ", sizingId=" + sizingId +
                ", colorId=" + colorId +
                ", shoeId=" + shoeId +
                '}';
    }
}
