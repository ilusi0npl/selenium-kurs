import java.util.List;

public class TesterUser {

    private String firstName;
    private String lastName;
    private Double yearsOfExperience;
    private List<LanguagesEnum> knownProgrammingLanguages;
    private boolean experiencedInSelenium;
    private boolean experiencedInAppium;
    private boolean experiencedInRestAssured;
    private boolean experiencedInWritingTestScenarios;

    public TesterUser(String firstName, String lastName, Double yearsOfExperience,
                      List<LanguagesEnum> knownProgrammingLanguages, boolean experiencedInSelenium, boolean experiencedInAppium,
                      boolean experiencedInRestAssured, boolean experiencedInWritingTestScenarios) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.knownProgrammingLanguages = knownProgrammingLanguages;
        this.experiencedInSelenium = experiencedInSelenium;
        this.experiencedInAppium = experiencedInAppium;
        this.experiencedInRestAssured = experiencedInRestAssured;
        this.experiencedInWritingTestScenarios = experiencedInWritingTestScenarios;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<LanguagesEnum> getKnownProgrammingLanguages() {
        return knownProgrammingLanguages;
    }

    public boolean isExperiencedInSelenium() {
        return experiencedInSelenium;
    }

    public boolean isExperiencedInAppium() {
        return experiencedInAppium;
    }

    public boolean isExperiencedInRestAssured() {
        return experiencedInRestAssured;
    }

    public boolean isExperiencedInWritingTestScenarios() {
        return experiencedInWritingTestScenarios;
    }
}