import java.util.Scanner;

public class Main {
        static boolean ordering = true;
        public static void menu(){
            System.out.println("****************Welcome to Employee Management System***************"
                    + "\n1.Add Employee"
                    + "\n2.View Employee"
                    + "\n3.Update Empl0yee"
                    + "\n4.Delete Employee"
                    + "\n5.View All Employee"
                    + "\n6.Exit");

        }
     public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            EmployeeService service = new EmployeeService();

            do{
                menu();
                System.out.println("Please Enter your Choice: ");
                int choice=sc.nextInt();

                switch (choice){
                    case 1:
                        System.out.println("Add employee");
                        service.addEmp();
                        service.saveEmployeesToFile();
                        break;
                    case 2:
                        System.out.println("View employee");
                        service.viewEmp();
                        service.loadEmployeeFromFile();
                        break;
                    case 3:
                        System.out.println("Update employee");
                        service.updateEmployee();
                        service.saveEmployeesToFile();
                        break;
                    case 4:
                        System.out.println("Delete employee");
                        service.deleteEmp();
                        service.saveEmployeesToFile();
                        break;
                    case 5:
                        System.out.println("View all employee");
                        service.viewAllEmps();
                        service.loadEmployeeFromFile();
                        break;
                    case 6:
                        System.out.println("Thank you for using application!");
                        System.exit(0);
                    default:
                        System.out.println("Please enter Valid choice");
                        break;


                }

            }while(ordering);
    }
}