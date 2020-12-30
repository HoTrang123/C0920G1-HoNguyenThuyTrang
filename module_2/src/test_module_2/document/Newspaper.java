package test_module_2.document;

public class Newspaper extends Document {
    private String dateRelease;

    public Newspaper() {
    }

    public Newspaper(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Newspaper(String idDocument, String namePublishers, int amountRelease, String dateRelease) {
        super(idDocument, namePublishers, amountRelease);
        this.dateRelease = dateRelease;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "dateRelease='" + dateRelease + '\'' +
                "} " + super.toString();
    }
}
