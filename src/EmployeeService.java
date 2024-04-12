import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {
    HashSet<Employee> empset= new HashSet<Employee>();

    Employee emp1= new Employee(101,"Abby",21,"Developer","IT",75000);
    Employee emp2= new Employee(102,"Alan",28,"QA engineer","IT",76000);
    Employee emp3= new Employee(103,"Matt",54,"Accountant","Accounting",100000);
    Employee emp4= new Employee(104,"Seth",32,"Manager","Accounting",125000);
    Employee emp5= new Employee(105,"Payton",25,"Senior developer","IT",95000);

    Scanner scanner = new Scanner(System.in);
    boolean found=false;
    int id;
    String name;
    int age;
    String designation;
    String department;
    double salary;

    public EmployeeService(){
        empset.add(emp1);
        empset.add(emp2);
        empset.add(emp3);
        empset.add(emp4);
        empset.add(emp5);

    }
    //view all employees
    public void viewAllEmps(){
        for(Employee emp:empset){
            System.out.println(emp);
        }
    }
    //view emp based on id
    public void viewEmp(){
        System.out.println("Enter id: ");
        id= scanner.nextInt();
        for(Employee emp:empset){
            if(emp.getId()==id){
                System.out.println(emp);
                found = true;
            }
        }
        if(!found){
            System.out.println("Employee with this id cannot be found");
        }
    }
    //update the emplyees
    public void updateEmployee(){
        System.out.println("Please enter the id: ");
        id= scanner.nextInt();
        boolean found= false;

        for(Employee emp:empset){
            if(emp.getId()==id){
                System.out.println("Please enter the name: ");
                name= scanner.next();
                System.out.println("Please enter the  Salary: ");
                salary= scanner.nextDouble();
                System.out.println("Please enter the age: ");
                age=scanner.nextInt();
                System.out.println("Please enter your designation: ");
                designation= scanner.next();
                System.out.println("Please enter your department: ");
                department= scanner.next();


                emp.setName(name);
                emp.setSalary(salary);
                emp.setAge(age);
                emp.setDesignation(designation);
                emp.setDepartment(department);

                System.out.println("Updated details of emplyee are: ");
                System.out.println(emp);
                found=true;
            }
        }
        if (!found){
            System.out.println("Employee is not found");
        }else {
            System.out.println("Employee details updated successfully.");
        }

    }
    public void deleteEmp(){
        System.out.println("Please enter the id: ");
        id=scanner.nextInt();
        boolean found=false;
        Employee empdelete =null;

        for(Employee emp:empset){
            if(emp.getId()==id){
                empdelete=emp;
                found=true;
            }
        }
        if(!found){
            System.out.println("Employee is not found");
        }
        else{
            empset.remove(empdelete);
            System.out.println("Employee deleted successfully!");
        }
    }
    public void addEmp(){
        System.out.println("Please enter Id: ");
        id= scanner.nextInt();
        System.out.println("Please enter a Name: ");
        name=scanner.next();
        System.out.println("Please enter the Age: ");
        age=scanner.nextInt();
        System.out.println("Plase enter Designation: ");
        designation= scanner.next();
        System.out.println("Please enter Department: ");
        department= scanner.next();
        System.out.println("Please enter the salary: ");
        salary= scanner.nextDouble();

        Employee emp = new Employee(id,name,age,designation,department,salary);

        empset.add(emp);
        System.out.println(emp);
        System.out.println("Emplyee added successfully!.");
        System.out.println(emp);

    }
    public void saveEmployeesToFile(){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Employees.dat"))){
            oos.writeObject(empset);
            System.out.println("Employees data saved successfully to file; ");
        }catch (IOException e){
            System.out.println("Error saving emplyees to file: " + e.getMessage());
        }
    }
    public void loadEmployeeFromFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employees.dat"))){
            empset=(HashSet<Employee>)ois.readObject();
            System.out.println("Emplyees data loaded successfully from the file");
        }catch(IOException| ClassNotFoundException e){
            System.out.println("Error loading employees from file: " + e.getMessage());

        }
    }

}
