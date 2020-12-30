package _case_study.commons;

import _case_study.models.Customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class AgeComparator implements Comparator<Customers> {
    @Override
    public int compare(Customers c1, Customers c2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
             date1 = simpleDateFormat.parse(c1.getBirthDay());
             date2 = simpleDateFormat.parse(c2.getBirthDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date2 != null;
        return date1.compareTo(date2);
    }
}
