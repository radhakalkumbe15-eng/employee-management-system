public class Employee {
    private int employeeId;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double salary;

    public Employee(String name,String email,String phone,String department,String designation,double salary){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.department=department;
        this.designation=designation;
        this.salary=salary;
    }
    public Employee(int employeeId,String name,String email,String phone,String department,String designation,double salary){
        this.employeeId=employeeId;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.department=department;
        this.designation=designation;
        this.salary=salary;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getDepartment(){
        return department;
    }
    public String getDesignation(){
        return designation;
    }
    public double getSalary(){
        return salary;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public void setDesignation(String designation){
        this.designation=designation;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    @Override 
    public String toString(){
        return "Employee ID:"+employeeId+",Name: "+name+",Email: "+email+",Phone: "+phone+",Department: "+department+
        ",Designation: "+designation+",Salary: "+salary;
    }
}
