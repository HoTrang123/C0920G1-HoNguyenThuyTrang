package test_module_2.document;

public class Book extends Document {
    private String nameAuthor;
    private int numberPages;

    public Book() {
    }

    public Book(String idDocument, String namePublishers, int amountRelease, String nameAuthor, int numberPages) {
        super(idDocument, namePublishers, amountRelease);
        this.nameAuthor = nameAuthor;
        this.numberPages = numberPages;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameAuthor='" + nameAuthor + '\'' +
                ", numberPages=" + numberPages +
                "} " + super.toString();
    }
}
