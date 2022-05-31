package JavaCore1_Lesson5;

public class Employee {

    private String fullName;
    private String jobTitle;
    private String email;
    private String phone;
    private String salary;
    private int age;


    public Employee(String fullName, String jobTitle, String email, String phone, String salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee("Employee" + i, "title" + i, "mail" + i + "@mail.com",
                                        "+799341263" + i, "10000," + i, 38 + i);
        }

        for (Employee employee : employees) {
            if (employee.age > 40) {
                System.out.println(employee);
            }
        }
    }
}
