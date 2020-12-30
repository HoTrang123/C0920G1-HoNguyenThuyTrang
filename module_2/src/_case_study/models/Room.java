package _case_study.models;

public class Room extends Services implements Comparable<Room>{
    private String freeServiceRoom;

    public Room() {
    }

    public Room(String freeServiceRoom) {
        this.freeServiceRoom = freeServiceRoom;
    }

    public Room(String id, String nameService, String areaService, String priceService, String numMaxPerson, String kindService, String freeServiceRoom) {
        super(id, nameService, areaService, priceService, numMaxPerson, kindService);
        this.freeServiceRoom = freeServiceRoom;
    }

    public String getFreeServiceRoom() {
        return freeServiceRoom;
    }

    public void setFreeServiceRoom(String freeServiceRoom) {
        this.freeServiceRoom = freeServiceRoom;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
//        System.out.println(super.toString());
    }

    @Override
    public String toString() {
        return "Room: " + super.toString() +
                ", freeServiceRoom " + freeServiceRoom;
    }

    @Override
    public int compareTo(Room room) {
        return this.getNameService().compareTo(room.getNameService());

    }
}
