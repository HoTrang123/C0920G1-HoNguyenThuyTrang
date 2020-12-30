package test_module_2.saving_book;

public class ProgrammingSavingBook {
    public static void main(String[] args) {
        ManagerSavingBook.readFile();
        while (true){
            ManagerSavingBook.menu();
        }
    }
}
