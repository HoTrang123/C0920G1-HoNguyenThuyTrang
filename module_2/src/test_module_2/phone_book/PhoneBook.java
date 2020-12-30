package test_module_2.phone_book;


public class PhoneBook {
    private String name;
    private String group;
    private String phoneNumber;
    private String gender;
    private String address;
    private String birthday;
    private String email;

    public PhoneBook() {
    }

    public PhoneBook(String name, String group, String phoneNumber, String gender, String address, String birthday, String email) {
        this.name = name;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "" + name + ',' + group + ',' + phoneNumber + ',' + gender + ',' + address + ',' + birthday + ',' + email;

    }
}
