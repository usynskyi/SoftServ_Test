package ua.us;

import java.util.ArrayList;

/**
 * Created by us on 13.02.2016.
 */
public class Start {

    public static void main(String[] args) {

        String path = "d://emploee.txt";
        ArrayList emplList = Employee.readEmpl(path);

        System.out.println("Maximum payment is: " + Employee.getMaxPaym(emplList).getName());
        System.out.println("Maximum experience is: " + Employee.getMaxExp(emplList).getName());

        path = "d://emploee2.txt";
        Employee.writeEmpl(path, emplList);
    }
}
