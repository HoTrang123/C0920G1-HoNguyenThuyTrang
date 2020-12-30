package test_module_2.document;

public class Document {
    private String idDocument;
    private String namePublishers;
    private int amountRelease;

    public Document() {
    }

    public Document(String idDocument, String namePublishers, int amountRelease) {
        this.idDocument = idDocument;
        this.namePublishers = namePublishers;
        this.amountRelease = amountRelease;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getNamePublishers() {
        return namePublishers;
    }

    public void setNamePublishers(String namePublishers) {
        this.namePublishers = namePublishers;
    }

    public int getAmountRelease() {
        return amountRelease;
    }

    public void setAmountRelease(int amountRelease) {
        this.amountRelease = amountRelease;
    }

    @Override
    public String toString() {
        return "Document{" +
                "idDocument='" + idDocument + '\'' +
                ", namePublishers='" + namePublishers + '\'' +
                ", amountRelease=" + amountRelease +
                '}';
    }
}
