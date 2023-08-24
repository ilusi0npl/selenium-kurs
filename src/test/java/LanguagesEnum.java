public enum LanguagesEnum {
    JAVA("Java"), C_SHARP("C#"), C_PLUS_PLUS("C++"), C("c"), KOTLIN("Kotlin"), JAVASCRIPT("JavaScript");

    private String language;

    LanguagesEnum(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}