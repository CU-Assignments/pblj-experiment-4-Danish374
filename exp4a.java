import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(int id, String name, double salary) {
        Employee emp = new Employee(id, name, salary);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = name;
                emp.salary = salary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void removeEmployee(int id) {
        Employee toRemove = null;
        for (Employee emp : employees) {
            if (emp.id == id) {
                toRemove = emp;
                break;
            }
        }
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.display();
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee emp : employees) {
                emp.display();
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    em.addEmployee(id, name, salary);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Salary: ");
                    double updateSalary = scanner.nextDouble();
                    em.updateEmployee(updateId, updateName, updateSalary);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    em.removeEmployee(removeId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    em.searchEmployee(searchId);
                    break;

                case 5:
                    em.displayAllEmployees();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
