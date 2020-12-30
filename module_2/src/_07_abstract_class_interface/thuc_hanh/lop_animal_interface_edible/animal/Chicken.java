package _07_abstract_class_interface.thuc_hanh.lop_animal_interface_edible.animal;
import _07_abstract_class_interface.thuc_hanh.lop_animal_interface_edible.edible.*;


public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}