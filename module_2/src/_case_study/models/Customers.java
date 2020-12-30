package _case_study.models;

public class Customers {
    private String name;
    private String birthDay;
    private String gen;
    private String CMND;
    private String phone;
    private String email;
    private String kindCustomer;
    private String address;
    private Services serviceObj;

    public Customers() {
    }

    public Customers(String name, String birthDay, String gen, String CMND, String phone, String email, String kindCustomer, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.gen = gen;
        this.CMND = CMND;
        this.phone = phone;
        this.email = email;
        this.kindCustomer = kindCustomer;
        this.address = address;
    }

    public Customers(String name, String birthDay, String gen, String CMND, String phone, String email, String kindCustomer, String address, Services serviceObj) {
        this.name = name;
        this.birthDay = birthDay;
        this.gen = gen;
        this.CMND = CMND;
        this.phone = phone;
        this.email = email;
        this.kindCustomer = kindCustomer;
        this.address = address;
        this.serviceObj = serviceObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKindCustomer() {
        return kindCustomer;
    }

    public void setKindCustomer(String kindCustomer) {
        this.kindCustomer = kindCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServiceObj() {
        return serviceObj;
    }

    public void setServiceObj(Services serviceObj) {
        this.serviceObj = serviceObj;
    }

    public void showInfor(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", birthDay: " + birthDay +
                ", gen: " + gen +
                ", CMND: " + CMND +
                ", phone: " + phone +
                ", email: " + email +
                ", kindCustomer: " + kindCustomer +
                ", address: " + address;
//                ", serviceObj: " + serviceObj;
    }
}
