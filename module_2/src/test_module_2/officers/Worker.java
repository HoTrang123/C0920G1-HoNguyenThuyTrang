package test_module_2.officers;

import test_module_2.phone_book.ManagerPhoneBook;

public class Worker extends Officers {
    private int level;

    public Worker(int level) {
        this.level = level;
    }

    public Worker(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static void addOfficer(){
        ManagerOfficers.addOfficer();

    }

    @Override
    public String toString() {
        return "Worker{" +
                "level=" + level +
                "} " + super.toString();
    }
}
