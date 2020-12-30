package test_module_2.document;

public class Magazine extends Document {
    private String numberRelease;
    private String monthRelease;

    public Magazine() {
    }

    public Magazine(String idDocument, String namePublishers, int amountRelease, String numberRelease, String monthRelease) {
        super(idDocument, namePublishers, amountRelease);
        this.numberRelease = numberRelease;
        this.monthRelease = monthRelease;
    }

    public String getNumberRelease() {
        return numberRelease;
    }

    public void setNumberRelease(String numberRelease) {
        this.numberRelease = numberRelease;
    }

    public String getMonthRelease() {
        return monthRelease;
    }

    public void setMonthRelease(String monthRelease) {
        this.monthRelease = monthRelease;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "numberRelease='" + numberRelease + '\'' +
                ", monthRelease='" + monthRelease + '\'' +
                "} " + super.toString();
    }
}
