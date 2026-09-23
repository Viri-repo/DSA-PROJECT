import java.util.Scanner;

class Student {
    int studentNo;
    String name;
    String serviceType;
    int serviceTime;

    Student(int studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    public String toString() {
        return studentNo + " , " + name + " , "
             + serviceType + " , " + serviceTime + " min";
    }
}

public class Studentservice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student number: ");
        int studentNo = input.nextInt();
        input.nextLine();

        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter service type: ");
        String serviceType = input.nextLine();

        System.out.print("Enter service time: ");
        int serviceTime = input.nextInt();

        Student student = new Student(studentNo, name, serviceType, serviceTime);

        System.out.println("\nStudent Details:");
        System.out.println(student);
    }
}
