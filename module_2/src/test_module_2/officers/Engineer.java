package test_module_2.officers;

public class Engineer extends Officers {
    private String majorEducate;

    public Engineer() {
    }

    public Engineer(String majorEducate) {
        this.majorEducate = majorEducate;
    }

    public Engineer(String name, int age, String gender, String address, String majorEducate) {
        super(name, age, gender, address);
        this.majorEducate = majorEducate;
    }

    public String getMajorEducate() {
        return majorEducate;
    }

    public void setMajorEducate(String majorEducate) {
        this.majorEducate = majorEducate;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "majorEducate='" + majorEducate + '\'' +
                "} " + super.toString();
    }
}
