package _case_study.models;

public abstract class Services {
    private String id;
    private String nameService;
    private String areaService;
    private String priceService;
    private String numMaxPerson;
    private String kindService;

    public Services() {
    }

    public Services(String id, String nameService, String areaService, String priceService, String numMaxPerson, String kindService) {
        this.id = id;
        this.nameService = nameService;
        this.areaService = areaService;
        this.priceService = priceService;
        this.numMaxPerson = numMaxPerson;
        this.kindService = kindService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaService() {
        return areaService;
    }

    public void setAreaService(String areaService) {
        this.areaService = areaService;
    }

    public String getPriceService() {
        return priceService;
    }

    public void setPriceService(String priceService) {
        this.priceService = priceService;
    }

    public String getNumMaxPerson() {
        return numMaxPerson;
    }

    public void setNumMaxPerson(String numMaxPerson) {
        this.numMaxPerson = numMaxPerson;
    }

    public String getKindService() {
        return kindService;
    }

    public void setKindService(String kindService) {
        this.kindService = kindService;
    }

    public abstract void showInfor();

    @Override
    public String toString() {
        return "id " + id + ", nameService " + nameService + ", areaService " + areaService +
                ", priceService " + priceService  + ", numMaxPerson " + numMaxPerson +
                ", kindService " + kindService ;
    }
}
