package _06_ke_thua.thuc_hanh.bai_doc;

public class Geometric {
    private String color = "white";
    private String filled = null;

    /* các khởi tạo tử */
    public Geometric() {
        System.out.println("ham khoi tao rong");
    }

    public Geometric(String color, String filled) {
        this.color = color;
        this.filled = filled;
    }

    /* các thuộc tính */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFilled() {
        return filled;
    }

    public void setFilled(String filled) {
        this.filled = filled;
    }

    public String toString() {
        return "created with \"" + color + "\" color and " +
                (filled == null ? "no fill" : "filled with \"" + filled + "\" color");
    }
}
