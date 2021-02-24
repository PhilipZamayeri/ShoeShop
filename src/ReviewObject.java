import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2021-02-24
 * Time: 14:32
 * Project: ShoeShop
 * Copyright: MIT
 */
public class ReviewObject {
    private List<String> comments = new ArrayList<>();
    private int averageGrade;
    private int shoeID;

    public ReviewObject(List<String> comments, int averageGrade, int shoeID) {
        this.comments = comments;
        this.averageGrade = averageGrade;
        this.shoeID = shoeID;
    }

    public List<String> getComments() {
        return comments;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public int getShoeID() {
        return shoeID;
    }

    @Override
    public String toString() {
        return
        "Sko nr: " + shoeID + "\nGenomsnittliga betyget: " + averageGrade + "\nKommentarer: \n" + comments;
    }
}
