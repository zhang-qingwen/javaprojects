import java.util.Objects;

public class Employee {
    String name;
    String country;
    int age;
    double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(country, employee.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, age, salary);
    }

    public Employee() {

    }

    public Employee(String name, String country, int age, double salary) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
