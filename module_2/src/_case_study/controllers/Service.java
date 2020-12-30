package _case_study.controllers;

import _15_IO_text_file.bai_tap.quan_ly_hoc_sinh.FileUntill;
import _case_study.commons.FileUntil;
import _case_study.commons.ValidateService;
import _case_study.models.House;
import _case_study.models.Room;
import _case_study.models.Villa;

import java.util.*;

public class Service {
    Scanner scanner = new Scanner(System.in);
    List<Villa> listVilla = new ArrayList<>();
    List<House> listHouse = new ArrayList<>();
    List<Room> listRoom = new ArrayList<>();
    public void addNewServices(){
        boolean check = true;
        while (check){
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println("Enter a number:");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    MainController mainController =new MainController();
                    mainController.displayMainMenu();
                    break;
                case 5:
                    check = false;
            }
        }
    }
    public void addNewVilla(){

        Villa villa = new Villa();
        scanner.nextLine();
        System.out.println("Enter id Villa");
        villa.setId(scanner.nextLine());
        System.out.println("Enter name");
        villa.setNameService(ValidateService.isCheckNameService(scanner.nextLine()));
        System.out.println("Enter area use:");
        villa.setAreaService(ValidateService.isCheckAreaService(scanner.nextLine()));
        System.out.println("Enter price");
        villa.setPriceService(ValidateService.isCheckPrice(scanner.nextLine()));
        System.out.println("Enter max person");
        villa.setNumMaxPerson(ValidateService.isCheckMaxPerson(scanner.nextLine()));
        System.out.println("Enter kind service");
        villa.setKindService(ValidateService.isCheckNameService(scanner.nextLine()));
        System.out.println("Enter kind villa");
        villa.setKindVilla(ValidateService.isCheckNameService(scanner.nextLine()));
        System.out.println("Enter different service");
        villa.setDifferentServiceVilla(ValidateService.isCheckDifferentService(scanner.nextLine().toLowerCase()));
        System.out.println("Enter area pool");
        villa.setAreaPoolVilla(ValidateService.isCheckAreaService(scanner.nextLine()));
        System.out.println("Enter number floor");
        villa.setNumFloorVilla(ValidateService.isCheckPrice(scanner.nextLine()));
        listVilla.add(villa);

        FileUntil.writeFile("src/_case_study/data/Villa.csv",villa.getId() + "," + villa.getNameService() + "," + villa.getAreaService() + ","
                    + villa.getAreaService() + "," + villa.getPriceService() + "," + villa.getNumMaxPerson() + ","
                    + villa.getKindService() + "," + villa.getKindVilla() + "," + villa.getAreaPoolVilla() + ","
                    + villa.getNumFloorVilla());
    }

    public void addNewHouse(){
        House house = new House();
        System.out.println("Enter id house");
        house.setId(scanner.nextLine());
        System.out.println("Enter name");
        house.setNameService(scanner.nextLine());
        System.out.println("Enter area:");
        house.setAreaService(scanner.nextLine());
        System.out.println("Enter price");
        house.setPriceService(scanner.nextLine());
        System.out.println("Enter max person");
        house.setNumMaxPerson(scanner.nextLine());
        System.out.println("Enter kind service");
        house.setKindService(scanner.nextLine());
        System.out.println("Enter kind house");
        house.setKindHouse(scanner.nextLine());
        System.out.println("Enter diffirent service");
        house.setDifferentServiceHouse(scanner.nextLine());
        System.out.println("Enter number floor");
        house.setNumFloorHouse(scanner.nextLine());
        listHouse.add(house);

        FileUntil.writeFile("src/_case_study/data/House.csv",house.getId() + "," + house.getNameService() + "," + house.getAreaService() + ","
                + house.getAreaService() + "," + house.getPriceService() + "," + house.getNumMaxPerson() + ","
                + house.getKindService() + "," + house.getKindHouse() + "," + house.getDifferentServiceHouse() + ","
                + house.getNumFloorHouse());
    }
    public void addNewRoom(){
        Room room = new Room();
        System.out.println("Enter id room");
        room.setId(scanner.nextLine());
        System.out.println("Enter name");
        room.setNameService(scanner.nextLine());
        System.out.println("Enter area:");
        room.setAreaService(scanner.nextLine());
        System.out.println("Enter price");
        room.setPriceService(scanner.nextLine());
        System.out.println("Enter max person");
        room.setNumMaxPerson(scanner.nextLine());
        System.out.println("Enter kind service");
        room.setKindService(scanner.nextLine());
        System.out.println("Enter free service room");
        room.setFreeServiceRoom(scanner.nextLine());
        listRoom.add(room);

        FileUntil.writeFile("src/_case_study/data/Room.csv",room.getId() + "," + room.getNameService() + "," + room.getAreaService() + ","
                + room.getAreaService() + "," + room.getPriceService() + "," + room.getNumMaxPerson() + ","
                + room.getKindService() + "," + room.getFreeServiceRoom());
    }
    public void showServices(){
        boolean check = true;
        while (check){
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("Enter a number");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    showAllVilla();
                    break;
                case 2:
                   showAllHouse();
                    break;
                case 3:
                  showAllRoom();
                    break;
                case 4:
                    displayVillaNotDuplicate();
                    break;
                case 5:
                    displayHouseNotDuplicate();
                    break;
                case 6:
                    displayRoomNotDuplicate();
                    break;
                case 7:
                    MainController mainController =new MainController();
                    mainController.displayMainMenu();
                    break;
                case 8:
                    check = false;
            }
        }
    }

    public void showAllVilla(){
                            List<Villa> villas = new ArrayList<>();
                    List<String[]> listStrVilla = FileUntil.readFile("src/_case_study/data/Villa.csv");
                    for (String[] s: listStrVilla){
                        Villa villa = new Villa(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
                        villas.add(villa);
                    }
                    if (villas.isEmpty()){
                        System.out.println("Danh sách trống");
                        showServices();
                    } else {
//                        for (Villa villa : villas) {
//                            villa.showInfor();
                        for (int i = 0; i < villas.size(); i++){
                            System.out.print(i + "-");
                            villas.get(i).showInfor();
                        }
                    }
    }

    public void showAllHouse(){
        List<House> houses = new ArrayList<>();
        List<String[]> listStrHouse = FileUntil.readFile("src/_case_study/data/House.csv");
        for (String[] s: listStrHouse){
            House house = new House(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8]);
            houses.add(house);
        }
        if (houses.isEmpty()){
            System.out.println("Danh sách trống");
            showServices();
        } else {
//            for (House house: houses){
////                house.showInfor();
////            }
            for (int i = 0; i < houses.size(); i++){
                System.out.println(i + "-");
                houses.get(i).showInfor();
            }
        }
    }

    public void showAllRoom(){
        List<Room> rooms = new ArrayList<>();
        List<String[]> listStrRoom = FileUntil.readFile("src/_case_study/data/Room.csv");
        for (String[] s: listStrRoom){
            Room room = new Room(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
            rooms.add(room);
        }
        if (rooms.isEmpty()){
            System.out.println("Danh sách trống");
            showServices();
        } else {
//            for (Room room: rooms){
//                room.showInfor();
//            }
            for (int i = 0; i < rooms.size(); i ++){
                System.out.println(i + "-");
                rooms.get(i).showInfor();
            }
        }
    }

    public void displayVillaNotDuplicate(){
        Set<Villa> treeSetVilla = new TreeSet<>();

        List<String[]> listStrVilla = FileUntil.readFile("src/_case_study/data/Villa.csv");
        for (String[] s: listStrVilla){
            Villa villa = new Villa(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
            treeSetVilla.add(villa);
        }
        if (treeSetVilla.isEmpty()){
            System.out.println("Danh sách trống");
            showServices();
        } else {
                        for (Villa villa : treeSetVilla) {
                            villa.showInfor();
            }

        }
    }

    public void displayHouseNotDuplicate(){
        Set<House> treeSetHouse = new TreeSet<>();

        List<String[]> listStrHouse = FileUntil.readFile("src/_case_study/data/House.csv");
        for (String[] s: listStrHouse){
            House house = new House(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8]);
            treeSetHouse.add(house);
        }
        if (treeSetHouse.isEmpty()){
            System.out.println("Danh sách trống");
            showServices();
        } else {
            for (House house : treeSetHouse) {
                house.showInfor();
            }

        }

    }

    public void displayRoomNotDuplicate(){
        Set<Room> treeSetRoom = new TreeSet<>();

        List<String[]> listStrRoom = FileUntil.readFile("src/_case_study/data/House.csv");
        for (String[] s: listStrRoom){
            Room room = new Room(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
            treeSetRoom.add(room);
        }
        if (treeSetRoom.isEmpty()){
            System.out.println("Danh sách trống");
            showServices();
        } else {
            for (Room room : treeSetRoom) {
                room.showInfor();
            }

        }
    }
}
