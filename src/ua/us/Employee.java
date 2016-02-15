package ua.us;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by us on 13.02.2016.
 */
public class Employee {

    private String name;
    private int exp;
    private int paym;
    private Manager manager;

    public Employee(String name, int exp, int paym) {
        this.name = name;
        this.exp = exp;
        this.paym = paym;
        this.manager = new Manager();
    }

    @Override
    public String toString() {
        return this.getName() + "(" + this.getExp() + " " + this.getPaym() + ")";
    }

    static Employee getMaxExp(ArrayList<Employee> emplList) {

        int maxExp = 0;
        Employee emplMaxExp = new Employee(null, 0 ,0);

        for (Employee empl : emplList) {
            int curExp = empl.getExp();
            if (curExp > maxExp) {
                maxExp = curExp;
                emplMaxExp = empl;
            }
        }

        return emplMaxExp;
    }

    static Employee getMaxPaym(ArrayList<Employee> emplList) {

        int maxPaym = 0;
        Employee emplMaxPaym = null;

        for (Employee empl : emplList) {
            int curPaym = empl.getPaym();
            if (curPaym > maxPaym) {
//                maxPaym = curPaym;
                emplMaxPaym = empl;
            }
        }

        return emplMaxPaym;
    }

    static ArrayList<Employee> readEmpl(String path) {
        ArrayList<Employee> emplList = new ArrayList<>();

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(path));

            while ((sCurrentLine = br.readLine()) != null) {
                //
                String[] curLineArr =  sCurrentLine.trim().split("\\s+");
                ///System.out.println(test);
                //ArrayList list = new ArrayList(Arrays.asList(test));
                if (curLineArr.length != 3) {
                    continue;
                }

                Employee empl = new Employee(curLineArr[0], Integer.parseInt(curLineArr[1]), Integer.parseInt(curLineArr[2]));

                emplList.add(empl);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return emplList;
    }

    static boolean writeEmpl(String path, ArrayList<Employee> emplList) {
        boolean result = false;
        String content = "";
        for(Employee empl : emplList) {
            content += empl.getName() + " " + empl.getExp() + " " + empl.getPaym() + System.getProperty("line.separator");

        }
            try {
                File file = new File(path);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getPaym() {
        return paym;
    }

    public void setPaym(int paym) {
        this.paym = paym;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
