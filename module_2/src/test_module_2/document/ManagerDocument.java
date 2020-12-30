package test_module_2.document;

import utilites_regex_exception_read_write_file.check_input_output.CheckInPrimeData;
import utilites_regex_exception_read_write_file.check_input_output.CheckInStringData;

import java.util.ArrayList;
import java.util.List;

public class ManagerDocument {
    private static List<Document> arrDocument = new ArrayList<>();

    public static void menu() {
        System.out.println("Select your choice: ");
        System.out.println("1.Add new document.");
        System.out.println("2.Delete document by Id document.");
        System.out.println("3.Show document.");
        System.out.println("4.Search document by Id document.");
        System.out.println("5.Exit.");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                addDocument();
                break;
            case 2:
                deleteDocument();
                break;
            case 3:
                showDocument();
                break;
            case 4:
                searchDocument();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Enter your select again!");
        }
    }

    public static void addDocument() {
        System.out.println("Select type of document want to add: ");
        System.out.println("1.Book.");
        System.out.println("2.Newspaper.");
        System.out.println("3.Magazine.");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                System.out.println("Enter Id document: ");
                String idDocumentB = CheckInStringData.checkString();
                System.out.println("Enter name publishers: ");
                String namePublishersB = CheckInStringData.checkString();
                System.out.println("Enter amount release: ");
                int amountReleaseB = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter name author: ");
                String nameAuthor = CheckInStringData.checkString();
                System.out.println("Enter number of pages: ");
                int numberPages = CheckInPrimeData.checkIntPositive();
                Document book = new Book(idDocumentB, namePublishersB, amountReleaseB, nameAuthor, numberPages);
                arrDocument.add(book);
                break;
            case 2:
                System.out.println("Enter Id document: ");
                String idDocumentN = CheckInStringData.checkString();
                System.out.println("Enter name publishers: ");
                String namePublishersN = CheckInStringData.checkString();
                System.out.println("Enter amount release: ");
                int amountReleaseN = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter date release: ");
                String dateRelease = CheckInStringData.checkString();
                Document newspaper = new Newspaper(idDocumentN, namePublishersN, amountReleaseN, dateRelease);
                arrDocument.add(newspaper);
                break;
            case 3:
                System.out.println("Enter Id document: ");
                String idDocumentM = CheckInStringData.checkString();
                System.out.println("Enter name publishers: ");
                String namePublishersM = CheckInStringData.checkString();
                System.out.println("Enter amount release: ");
                int amountReleaseM = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter number release: ");
                String numberRelease = CheckInStringData.checkString();
                System.out.println("Enter month release: ");
                String monthRelease = CheckInStringData.checkString();
                Document magazine = new Magazine(idDocumentM, namePublishersM, amountReleaseM, numberRelease, monthRelease);
                arrDocument.add(magazine);
                break;
            default:
                System.out.println("Enter your select again!");
                addDocument();
        }
    }

    public static void deleteDocument() {
        System.out.println("Enter Id document want to delete: ");
        String idDocument = CheckInStringData.checkString();
        boolean checkFind = false;
        int d = -1;
        for (int i = 0; i < arrDocument.size(); i++) {
            if (idDocument.equals(arrDocument.get(i).getIdDocument())) {
                d = i;
                checkFind = true;
                break;
            }
        }
        if (checkFind) {
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("Enter your choice: ");
            int choice = CheckInPrimeData.checkIntPositive();
            if (choice == 1) {
                arrDocument.remove(d);
                showDocument();
            } else if (choice == 2) {
                showDocument();
            } else {
                System.out.println("Do not choice");
                deleteDocument();
            }
        } else {
            System.out.println("DO NOT find product!");
        }
    }

    public static void showDocument() {
        for (Document document : arrDocument) {
            System.out.println(document.toString());
        }
    }

    public static void searchDocument() {
        System.out.println("Enter id document want to search: ");
        String idDocument = CheckInStringData.checkString();
        boolean checkFind = false;
        for (Document document : arrDocument) {
            if (idDocument.equals(document.getIdDocument())) {
                System.out.println(document.toString());
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find document!");
        }
    }

    public static void exit() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
