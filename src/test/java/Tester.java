public class Tester {

    private String name;
    private String position;
    private String city;
    private int age;

    public Tester(String name, String position, String city, int age) {
        this.name = name;
        this.position = position;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s is %s, works in %s, age %s", this.name, this.position, this.city, this.age);
    }
}