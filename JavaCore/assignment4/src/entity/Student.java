package entity;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private float score;

    private static int counter = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void addScore(float score) {
        this.score += score;
    }

    public Student(String name, String homeTown) {
        this.id = counter++;
        this.name = name;
        this.homeTown = homeTown;
        this.score = 0;
    }

    public void printInfo() {

        String rank;

        if (score < 4.0f) {
            rank = "Yeu";
        } else if (score < 6.0f) {
            rank = "Trung Binh";
        } else if (score < 8.0f) {
            rank = "Kha";
        } else {
            rank = "Gioi";
        }

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Hometown: " + homeTown);
        System.out.println("Score: " + score);
        System.out.println("Hoc luc: " + rank);
    }
}
