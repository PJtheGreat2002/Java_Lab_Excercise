Employee Payroll System Overview
This code implements an employee payroll system using Object-Oriented Programming (OOP) concepts, including inheritance, method overriding, and polymorphism. It defines a base class Employee and three subclasses: HourlyEmployee, SalariedEmployee, and ExecutiveEmployee, each representing different types of employees with specific salary structures and bonuses.

Class Structure:
1. Employee:
  - The base class that contains common attributes (employeeId, employeeName, designation).
  - Provides a default method calculateBonus() that can be overridden in derived classes.

2. HourlyEmployee:
  - Inherits from Employee and represents employees paid hourly.
  - Contains methods to calculate weekly earnings (weekEarning()), a 10% weekly bonus (calculateBonus()), and annual earnings.

3. SalariedEmployee:
  - Inherits from Employee and represents employees with a fixed monthly salary.
  - Provides methods to calculate weekly earnings, a 5% monthly bonus, and annual earnings.

4. ExecutiveEmployee:
  -  Extends SalariedEmployee and adds an extra annual bonus based on a specified percentage.
  - Overrides calculateBonus() to include both the base bonus and an additional executive bonus.

Features:
  - Method Overriding: Each subclass overrides the calculateBonus() method to implement its own bonus structure.
  -  Inheritance: The super keyword is used to access methods and constructors from the base class.
  -  Payroll Calculation: The system calculates weekly earnings, bonuses, and total annual earnings for each employee type.
  -  Total Payroll: The program calculates the total payroll for all instantiated employees.

Test Program:
The MainEmp class demonstrates the system by:

  -  Creating instances of HourlyEmployee, SalariedEmployee, and ExecutiveEmployee.
  -  Displaying each employee's details, including weekly earnings, bonuses, and annual earnings.
  -  Calculating and displaying the total payroll for all employees.
This design showcases efficient use of inheritance and polymorphism to manage different types of employees with varying compensation structures.
