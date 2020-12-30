package _case_study.commons;

import _case_study.controllers.Customer;
import _case_study.models.Customers;

import java.util.Comparator;

public class NameComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers c1, Customers c2) {
        AgeComparator ageComparator = new AgeComparator();
        if (c1.getName().compareTo(c2.getName()) == 0) {
            return ageComparator.compare(c1, c2);
        } else {
            return c1.getName().compareTo(c2.getName());
        }
    }
}
