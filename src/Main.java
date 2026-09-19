import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        EmployeeDAO employeeDAO=new EmployeeDAO();
        while(true){
            System.out.println("\n====EMPLOYEE MANAGEMENT SYSTEM ====");
            System.out.println("1.add employee");
            System.out.println("2.view all employees");
            System.out.println("3.search Employee by ID");
            System.out.println("4.search employees by department");
            System.out.println("5.update employee");
            System.out.println("6.delete employee");
            System.out.println("7.exit");
            System.out.println("enter your choice: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
            case 1:
            String name;
            while(true){
            System.out.println("enter name: ");
            name=scanner.nextLine();
            if(!name.trim().isEmpty()){
                break;
            }
            System.out.println("name cannot be empty.");
            }
            String email;
            while(true){
            System.out.println("Enter email: ");
             email=scanner.nextLine();
             if(email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
                break;
             }
             System.out.println("invalid email.please enter a valid email.");
            }
            String phone;
            while(true){
            System.out.println("enter phone: ");
             phone=scanner.nextLine();
             if(phone.matches("\\d{10}")){
                break;
             }
             System.out.println("invalid phone number.please enter exactly 10 digits.");
            }
            String department;
            while(true){
            System.out.println("enter department: ");
             department=scanner.nextLine();
             if(!department.trim().isEmpty()){
                break;
             }
             System.out.println("department cannot be empty.");
            }
            System.out.println("enter designation: ");
            String designation=scanner.nextLine();
            double salary;
            while(true){
            System.out.println("enter salary: ");
             salary=scanner.nextDouble();
             if(salary>0){
                break;
             }
             System.out.println("salary must be greater than 0.");
            }
            scanner.nextLine();
            Employee employee=new Employee(name,email,phone,department,designation,salary);
            employeeDAO.addEmployee(employee);
            break;
            case 2:
            employeeDAO.viewAllEmployees();
            break;
            case 3:
            System.out.println("enter employee id: ");
            int searchId=scanner.nextInt();
            scanner.nextLine();
            Employee foundEmployee=employeeDAO.getEmployeeById(searchId);
            if(foundEmployee !=null){
            System.out.println("employee ID:"+foundEmployee.getEmployeeId());
            System.out.println("Name: "+foundEmployee.getName());
            System.out.println("Email: "+foundEmployee.getEmail());
            System.out.println("phone: "+foundEmployee.getPhone());
            System.out.println("department: "+foundEmployee.getDepartment());
            System.out.println("salary: "+foundEmployee.getSalary());
            }else{
             System.out.println("employee id not found!");
            }
            break;
            case 4:
            System.out.println("enter department: ");
            String searchDepartment=scanner.nextLine();
            employeeDAO.getEmployeesByDepartment(searchDepartment);
            break;
            case 5:
            System.out.println("enter employee ID to update: ");
            int updateId=scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter new name: ");
            String newName=scanner.nextLine();
            System.out.println("enter new email: ");
            String newEmail=scanner.nextLine();
            System.out.println("enter new phone: ");
            String newPhone=scanner.nextLine();
            System.out.println("enter new department: ");
            String newDepartment=scanner.nextLine();
            System.out.println("enter new designation: ");
            String newDesignation=scanner.nextLine();
            System.out.println("enter new salary: ");
            double newSalary=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("are ypu sure you want to update this emp,oyee?(yes/no):");
            String confirmation=scanner.nextLine();
            if(confirmation.equalsIgnoreCase("yes")){
            Employee updateEmployee=new Employee(updateId,newName, newEmail, newPhone, newDepartment, newDesignation, newSalary);
            employeeDAO.updateEmployee(updateEmployee);
        }else{
            System.out.println("update operation cancelled.");
        }
            break;
            case 6:
            System.out.println("enter employee ID to delete: ");
            int deleteId=scanner.nextInt();
            scanner.nextLine();
            System.out.println("are you sure you want to delete this employee?(yes/no):");
             confirmation=scanner.nextLine();
            if(confirmation.equalsIgnoreCase("yes")){
                employeeDAO.deleteEmployee(deleteId);
            }else{
                System.out.println("delete operation cancelled.");
            }
            break;
            case 7:
            System.out.println("thank you for using employee management system!");
            scanner.close();
             return;
             default:
             System.out.println("invalid choice!please enter 1-7.");   
             break;
            }
        }
}
}
