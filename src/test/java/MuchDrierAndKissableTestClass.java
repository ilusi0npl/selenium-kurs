import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MuchDrierAndKissableTestClass {

    private static final String MESSAGE_PATTERN = "Tester %s %s %s apply for job";
    private static List<TesterUser> testers = new ArrayList<>();

    public static void main(String[] args) {
        createDefaultTesters();

        for (TesterUser tester : testers) {
            String resultMessage = canTesterApplyForJob(tester) ? "can" : "cannot";
            System.out.println(String.format(MESSAGE_PATTERN, tester.getFirstName(), tester.getLastName(), resultMessage));
        }
    }

    private static void createDefaultTesters() {
        testers.add(new TesterUser("John", "Smith", 2.0, Arrays.asList(LanguagesEnum.JAVA, LanguagesEnum.C_SHARP, LanguagesEnum.C_PLUS_PLUS),
                true, true, false, false));
        testers.add(new TesterUser("Mark", "Kowalsky", 5.0, Arrays.asList(LanguagesEnum.JAVA, LanguagesEnum.C_SHARP, LanguagesEnum.C_PLUS_PLUS,
                LanguagesEnum.C, LanguagesEnum.KOTLIN, LanguagesEnum.JAVASCRIPT),
                true, true, true, true));
        testers.add(new TesterUser("Kate", "Mock", 3.3, Arrays.asList(LanguagesEnum.JAVA, LanguagesEnum.C_SHARP),
                true, false, false, true));
        testers.add(new TesterUser("Adam", "Brog", 2.6, Arrays.asList(LanguagesEnum.C_SHARP, LanguagesEnum.C_PLUS_PLUS),
                true, true, true, false));
        testers.add(new TesterUser("Jessica", "Gray", 2.4, Arrays.asList(LanguagesEnum.C_SHARP, LanguagesEnum.C_PLUS_PLUS),
                true, true, true, true));
        testers.add(new TesterUser("Susan", "Ryans", 2.5, Arrays.asList(LanguagesEnum.JAVA),
                false, true, true, true));
    }

    public static boolean canTesterApplyForJob(TesterUser tester) {
        return isTesterExperiencedEnough(tester) && isTestersProgrammingLanguagesKnowladgeSuitable(tester)
                && isTesterExperiencedEnoughInTesting(tester);
    }

    private static boolean isTesterExperiencedEnough(TesterUser tester) {
        return tester.getYearsOfExperience() >= 2.5;
    }

    private static boolean isTestersProgrammingLanguagesKnowladgeSuitable(TesterUser tester) {
        return testerKnowsAtLeastTwoProgrammingLanguages(tester)
                && (testerKnowsGivenProgrammingLanguage(tester, LanguagesEnum.JAVA)
                || testerKnowsGivenProgrammingLanguage(tester, LanguagesEnum.C_SHARP));
    }

    private static boolean isTesterExperiencedEnoughInTesting(TesterUser tester) {
        return tester.isExperiencedInSelenium() && tester.isExperiencedInWritingTestScenarios();
    }

    private static boolean testerKnowsAtLeastTwoProgrammingLanguages(TesterUser tester) {
        return tester.getKnownProgrammingLanguages().size() >= 2;
    }

    private static boolean testerKnowsGivenProgrammingLanguage(TesterUser tester, LanguagesEnum language) {
        return tester.getKnownProgrammingLanguages().contains(language);
    }

}