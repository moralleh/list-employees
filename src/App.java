import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? \n");
        int qtdEmployees = sc.nextInt();
        System.out.println();

        for(int i = 1; i <= qtdEmployees; i++ ){
            System.out.println("Employee #" + i);
            System.out.print("Id: ");
            int id = sc.nextInt();
            

            while((findById(list, id)) != null) {
                System.out.println("Id already registered.");
                System.out.print("Enter another id: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            Employee emp = new Employee(id, name, salary);
            list.add(emp);
            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        while(findById(list, id) == null) {
            System.out.println("Id doesn't exist.");
            System.out.print("Enter another id: ");
            id = sc.nextInt();
        }
        Employee emp = findById(list, id);
 
        System.out.print("Enter the percentage: ");
        double rate = sc.nextDouble();
        emp.salaryIncrease(rate);

        System.out.print("\nList of employess:\n");
        for(Employee employee : list){
            System.out.println(employee);
        }

        sc.close();
       
    }

    public static Employee findById(List<Employee> list, int id){
        for(Employee emp : list){
            if(emp.getId() == id){
                return emp;
            }
        }
        return null;
    }
}
