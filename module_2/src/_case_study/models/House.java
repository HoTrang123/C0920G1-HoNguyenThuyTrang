package _case_study.models;

public class House extends Services implements Comparable<House>{
    private String kindHouse;
    private String differentServiceHouse;
    private String numFloorHouse;

    public House() {
    }

    public House(String kindHouse, String differentServiceHouse, String numFloorHouse) {
        this.kindHouse = kindHouse;
        this.differentServiceHouse = differentServiceHouse;
        this.numFloorHouse = numFloorHouse;
    }

    public House(String id, String nameService, String areaService, String priceService, String numMaxPerson, String kindService, String kindHouse, String differentServiceHouse, String numFloorHouse) {
        super(id, nameService, areaService, priceService, numMaxPerson, kindService);
        this.kindHouse = kindHouse;
        this.differentServiceHouse = differentServiceHouse;
        this.numFloorHouse = numFloorHouse;
    }

    public String getKindHouse() {
        return kindHouse;
    }

    public void setKindHouse(String kindHouse) {
        this.kindHouse = kindHouse;
    }

    public String getDifferentServiceHouse() {
        return differentServiceHouse;
    }

    public void setDifferentServiceHouse(String differentServiceHouse) {
        this.differentServiceHouse = differentServiceHouse;
    }

    public String getNumFloorHouse() {
        return numFloorHouse;
    }

    public void setNumFloorHouse(String numFloorHouse) {
        this.numFloorHouse = numFloorHouse;
    }

    @Override
    public void showInfor() {
//        System.out.println(super.toString());
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "House: " + super.toString() +
                ",kindHouse " + kindHouse  +
                ", differentServiceHouse " + differentServiceHouse +
                ", numFloorHouse " + numFloorHouse;
    }

    @Override
    public int compareTo(House house) {
        return this.getNameService().compareTo(house.getNameService());
    }
}
