package _11_java_collection_frameword.bai_tap.product;

import java.util.*;

public class ProductManager {
    List<Product> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(){
        Product product = new Product();
        System.out.println("Enter id:");
        product.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter name:");
        product.setName(scanner.nextLine());
        System.out.println("Enter price:");
        product.setPrice(scanner.nextInt());
        list.add(product);
    }

    public void edit(){
        System.out.println("Enter product id to edit:");
        int idEdit = scanner.nextInt();
        for (Product p : list){
            if (idEdit == p.getId()){
                System.out.println("ID:" + p.getId()+", Name:" + p.getName() +", Price:" +p.getPrice());
                System.out.println("Enter new name:");
                scanner.nextLine();
                p.setName(scanner.nextLine());

                System.out.println("Enter new price:");
                p.setPrice(scanner.nextInt());
            } else {
                System.out.println("Dont find product");
            }
        }
    }

    public void delete(){
        System.out.println("Enter product id to delete:");
        int idDelete = scanner.nextInt();
        for (Product p : list){
            if (idDelete == p.getId()){
                System.out.println("Delete" + p.getName() + "1.Yes 2.No" );
                int chose = scanner.nextInt();
                if (chose == 1) {
                    list.remove(p);
                }
            } else {
                System.out.println("Dont delete");
            }
        }
    }

    public void display(){
        for (Product p : list){
            System.out.println("ID:" + p.getId()+", Name:" + p.getName() +", Price:" +p.getPrice());
        }
    }

    public void find(){
        boolean check = false;
        scanner.nextLine();
        System.out.println("Enter product name to find");
        String nameDelete = scanner.nextLine();
        for (Product p : list){
            if (nameDelete.equals(p.getName())){
                System.out.println("ID:" + p.getId()+",Name:" + p.getName() +", Price:" +p.getPrice());
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (!check){
            System.out.println("Dont find product");
        }
    }

    public void sort(){
        Comparator comparator = new Comparator();
        Collections.sort(list,comparator);
        Stack<Product> stack = new Stack();
        System.out.println("Do you want to show sorting up or down? \n1. Up, 2. Down");
        int check = scanner.nextInt();
        if (check == 1){
            for (Product p : list){
                System.out.println("ID:" + p.getId()+",Name:" + p.getName() +", Price:" +p.getPrice());
            }
        } else if (check == 2){
            for (Product p : list){
                stack.push(p);
            }
            for (int i = 0; i<list.size(); i++){
                Product p = stack.pop();
                System.out.println("ID:" + p.getId()+",Name:" + p.getName() +", Price:" +p.getPrice());
            }
        }
    }

}
