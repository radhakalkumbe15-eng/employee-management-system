import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    //add employee

    public void addEmployee(Employee employee){
        String sql="INSERT INTO employee "+"(name,email,phone,department,designation,salary)"+"VALUES(?,?,?,?,?,?)";
        try(Connection connection=DBConnection.getConnection();
    PreparedStatement statement=connection.prepareStatement(sql)){
        statement.setString(1, employee.getName());
        statement.setString(2,employee.getEmail());
        statement.setString(3, employee.getPhone());
        statement.setString(4, employee.getDepartment());
        statement.setString(5,employee.getDesignation());
        statement.setDouble(6, employee.getSalary());

        int rows=statement.executeUpdate();
        if(rows>0){
            System.out.println("employee added successfully!");
        }
    }catch(SQLException e){
        System.out.println("Error adding employee!");
        e.printStackTrace();
    }
    }

    //view all employees

    public void viewAllEmployees(){
        String sql="SELECT*FROM employee";
        try(Connection connection=DBConnection.getConnection();
    PreparedStatement statement=connection.prepareStatement(sql);
ResultSet resultSet=statement.executeQuery()){
    while(resultSet.next()){
        System.out.println("---------------------------");
        System.out.println("Employee ID: "+resultSet.getInt("employee_id"));
        System.out.println("Name: "+resultSet.getString("name"));
        System.out.println("Email:"+resultSet.getString("email"));
        System.out.println("Phone: "+resultSet.getString("phone"));
        System.out.println("Department: "+resultSet.getString("department"));
        System.out.println("Designation: "+resultSet.getString("designation"));
        System.out.println("Salary: "+resultSet.getDouble("salary"));
    }
}catch(SQLException e){
    System.out.println("Error viewing employees!");
    e.printStackTrace();
}
    }

    //search employee id

    public Employee getEmployeeById(int employeeId){
        String sql="SELECT*FROM employee WHERE employee_id=?";
        try(Connection connection=DBConnection.getConnection();
    PreparedStatement statement=connection.prepareStatement(sql)){
        statement.setInt(1, employeeId);
        try(ResultSet resultSet=statement.executeQuery()){
            if(resultSet.next()){
                return new Employee(resultSet.getInt("employee_id"),resultSet.getString("name"), resultSet.getString("email"), 
            resultSet.getString("phone"),resultSet.getString("department"),resultSet.getString("designation"),
        resultSet.getDouble("salary"));
            }
        }
    }catch(SQLException e){
        System.out.println("Error searching employee!");
        e.printStackTrace();
    }
    return null;
    }

    //delete employee

    public void deleteEmployee(int employeeId){
        String sql="DELETE FROM employee WHERE employee_id = ?";
        try(Connection connection=DBConnection.getConnection();
    PreparedStatement statement=connection.prepareStatement(sql)){
        statement.setInt(1, employeeId);
        int rows=statement.executeUpdate();
        if(rows>0){
            System.out.println("Employee deleted successfully!");
        }else{
            System.out.println("Employee ID not found!");
        } 
    }catch(SQLException e){
        System.out.println("Error deleting employee!");
        e.printStackTrace();
    }
    }

    //update employee

    public void updateEmployee(Employee employee){
        String sql="UPDATE employee SET name=?,email=?,phone=?,"+"department=?,designation=?,salary=?"+"WHERE employee_id=?";
        try(Connection connection=DBConnection.getConnection();
    PreparedStatement statement=connection.prepareStatement(sql)){
        statement.setString(1,employee.getName());
        statement.setString(2,employee.getEmail());
        statement.setString(3,employee.getPhone());
        statement.setString(4,employee.getDepartment());
        statement.setString(5,employee.getDesignation());
        statement.setDouble(6,employee.getSalary());
        statement.setInt(7,employee.getEmployeeId());

        int rows=statement.executeUpdate();
        if(rows>0){
            System.out.println("Employee updated successfully!");
        }else{
            System.out.println("Employee ID not found!");
        }
    }catch(SQLException e){
        System.out.println("Error updating employee!");
        e.printStackTrace();
    }
    } 

    //search employees by department
    
    public void getEmployeesByDepartment(String department){
        String sql="SELECT*FROM employee WHERE department=?";
        try(Connection connection=DBConnection.getConnection();
    PreparedStatement statement=connection.prepareStatement(sql)){
        statement.setString(1,department);
        try(ResultSet resultSet=statement.executeQuery()){
            boolean found=false;
            while(resultSet.next()){
                found=true;
                System.out.println("-----------------------");
                System.out.println("Employee ID: "+resultSet.getInt("employee_id"));
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("Email: "+resultSet.getString("email"));
                System.out.println("Phone: "+resultSet.getString("phone"));
                System.out.println("Department: "+resultSet.getString("department"));
                System.out.println("Designation: "+resultSet.getString("designation"));
                System.out.println("Salary: "+resultSet.getDouble("salary"));
            }
            if(!found){
                System.out.println("No employees found in this department!");
            }
        }
    }catch(SQLException e){
        System.out.println("Error searching by department!");
        e.printStackTrace();
    }
    } 
}
