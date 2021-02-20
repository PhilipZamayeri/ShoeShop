/**
 * Created by Philip Zamayeri
 * Date: 2021-02-18
 * Time: 16:20
 * Project: ShoeShop
 * Copyright: MIT
 */
public class Rating {

    private int id;
    private int points;
    private String grade;

    public Rating(int id, int points, String grade){
        this.id = id;
        this.points = points;
        this.grade = grade;

    }


    public int getId(){return id;}
    public int getPoints(){return points;}
    public String getGrade(){return grade;}

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", points=" + points +
                ", grade='" + grade + '\'' +
                '}';
    }
}
