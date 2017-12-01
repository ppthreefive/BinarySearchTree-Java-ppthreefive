package com.phillippham.binary_search_tree;

public class Employee implements Comparable<Employee>
{
	private String name;
	private double salary;
	
	public Employee(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}
	
	// Accessors
	public String getName()
	{
		return name;
	}

	public double getSalary()
	{
		return salary;
	}
	
	// Mutators
	public void setName(String name)
	{
		this.name = name;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public double calculatePay()
	{
		double pay = 0.0;
		
		pay = this.salary / 26;
		
		return pay;
	}

	public String toString()
	{
		return "Employee [Name: " + name + ", Salary: " + salary + ", Biweekly Pay: " + calculatePay() + "]";
	}

	@Override
	public int compareTo(Employee otherEmp)
	{
		/*Double emp1 = this.salary;
		Double emp2 = otherEmp.getSalary();
		
		return emp1.compareTo(emp2);*/
		return this.name.compareTo(otherEmp.getName());
	}
}