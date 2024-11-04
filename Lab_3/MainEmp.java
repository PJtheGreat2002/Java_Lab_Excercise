//package java.util.Scanner;

class Employee {
    int employeeId;
    String employeeName;
    String designation;

    Employee(int employeeId, String employeeName,String designation)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    double calculateBonus() {
        return 0.0; 
    }
}
class HourlyEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;
    double earnings;

    HourlyEmployee(int employeeId, String employeeName,String designation,double hourlyRate, int hoursWorked)
    {
        super(employeeId, employeeName, designation);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    double weekearning()
    {
        earnings = hourlyRate * hoursWorked;
        return earnings;
    }
    double calculateBonus() 
    {
        return earnings * 0.1; // 10% of weekly earnings as bonus
    }
    double annualEarnings() {
        return weekearning() * 52 + calculateBonus();
    }
    void display()
    {
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Designation: " + designation);
        System.out.println("Hourly Rate: " + hourlyRate); 
        System.out.println("Hours Workerd: " + hoursWorked);
        System.out.println("Weekly Earnings: " + earnings);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Annual Earnings: " + annualEarnings());
        System.out.println();
    }

}
class SalariedEmployee extends Employee{
    double monthlySalary,earnings;

    SalariedEmployee(int employeeId, String employeeName,String designation,double monthlySalary)
    {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    double weekearning()
    {
        earnings = monthlySalary / 4;
        return earnings;
    }
    double calculateBonus() 
    {
        return monthlySalary * 0.05; // 5% of monthly salary as bonus
    }
    double annualEarnings() 
    {
        return monthlySalary * 12 + calculateBonus();
    }
    void display()
    {
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Designation: " + designation);
        System.out.println("Monthly Salary: " + monthlySalary); 
        System.out.println("Weekly Earnings: " + earnings);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Annual Earnings: " + annualEarnings());
        System.out.println();
    }
    
}
class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) 
    {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    double calculateBonus() 
    {
        double baseBonus = super.calculateBonus(); // Invoke base class method
        return baseBonus + (monthlySalary * 12 * (bonusPercentage / 100)); // Add annual bonus
    }
    double annualEarnings() 
    {
        return super.annualEarnings(); // Annual earnings with bonus included
    }

    void display() {
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Designation: " + designation);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Bonus Percentage: " + bonusPercentage);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Annual Earnings: " + annualEarnings());
        System.out.println();
    }
}
public class MainEmp
{
    static double totalPayroll = 0.0; 
    public static void main(String[] args)
    {
        HourlyEmployee obj1 = new HourlyEmployee(1,"Pratham Jain","CEO",50,5);
        obj1.weekearning();
        obj1.display();
        totalPayroll += obj1.annualEarnings();

        SalariedEmployee obj2 = new SalariedEmployee(2,"Yug Jain","CTO",50000);
        obj2.weekearning();
        obj2.display();
        totalPayroll += obj2.annualEarnings();

        ExecutiveEmployee obj3 = new ExecutiveEmployee(3, "Rohan Sharma", "CEO", 100000, 20);
        obj3.display();
        totalPayroll += obj3.annualEarnings();

        System.out.println("Total Payroll for All Employees: " + totalPayroll);
    }
}

