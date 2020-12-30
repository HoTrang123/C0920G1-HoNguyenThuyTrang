package _case_study.models;

public class Villa extends Services implements Comparable<Villa> {
    private String kindVilla;
    private String differentServiceVilla;
    private String areaPoolVilla;
    private String numFloorVilla;


    public Villa() {
    }

    public Villa(String kindVilla, String diffirentServiceVilla, String areaPoolVilla, String numFoatVilla) {
        this.kindVilla = kindVilla;
        this.differentServiceVilla = diffirentServiceVilla;
        this.areaPoolVilla = areaPoolVilla;
        this.numFloorVilla = numFoatVilla;
    }

    public Villa(String id, String nameService, String areaService, String priceService, String numMaxPerson, String kindService, String kindVilla, String diffirentServiceVilla, String areaPoolVilla, String numFoatVilla) {
        super(id, nameService, areaService, priceService, numMaxPerson, kindService);
        this.kindVilla = kindVilla;
        this.differentServiceVilla = diffirentServiceVilla;
        this.areaPoolVilla = areaPoolVilla;
        this.numFloorVilla = numFoatVilla;
    }

    public String getKindVilla() {
        return kindVilla;
    }

    public void setKindVilla(String kindVilla) {
        this.kindVilla = kindVilla;
    }

    public String getDifferentServiceVilla() {
        return differentServiceVilla;
    }

    public void setDifferentServiceVilla(String differentServiceVilla) {
        this.differentServiceVilla = differentServiceVilla;
    }

    public String getAreaPoolVilla() {
        return areaPoolVilla;
    }

    public void setAreaPoolVilla(String areaPoolVilla) {
        this.areaPoolVilla = areaPoolVilla;
    }

    public String getNumFloorVilla() {
        return numFloorVilla;
    }

    public void setNumFloorVilla(String numFloorVilla) {
        this.numFloorVilla = numFloorVilla;
    }

    @Override
    public void showInfor() {
//        System.out.println(super.toString());
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Villa: " + super.toString() + ", kindVilla " + kindVilla +
                ", differentServiceVilla " + differentServiceVilla +
                ", areaPoolVilla " + areaPoolVilla +
                ", numFloorVilla " + numFloorVilla;
    }

    @Override
    public int compareTo(Villa villa) {
        return this.getNameService().compareTo(villa.getNameService());
    }
}
