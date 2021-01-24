import java.util.ArrayList;
import java.util.List;


public class DryCompanyProgram {

    private static final String CITY_WROCLAW = "Wrocław";

    public static void main(String[] args) {
        System.out.println("Tester in the company are: ");
        List<Tester> listOfTestersInCompany = new ArrayList<>();

        Tester testerKazimierz = new Tester("Kazimierz", Position.JUNIOR_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 31);
        Tester testerZygmunt = new Tester("Zygmunt", Position.JUNIOR_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 21);
        Tester testerAnna = new Tester("Anna", Position.LEAD_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 44);
        Tester testerStefan = new Tester("Stefan", Position.SENIOR_MANUAL_TESTER.getPositionName(), CITY_WROCLAW, 28);

        listOfTestersInCompany.add(testerKazimierz);
        listOfTestersInCompany.add(testerZygmunt);
        listOfTestersInCompany.add(testerAnna);
        listOfTestersInCompany.add(testerStefan);

        for (Tester tester : listOfTestersInCompany) {
            System.out.println(tester.toString());
        }

    }

}