package com.sunbeam.test;
import com.sunbeam.Employee.*;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1=new Employee("Yashraj","Shitole",105000);
		
		Employee e2=new Employee("Divyaraj", "Shitole", 110000);
		
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|First name \t|Last name \t\t|Salary \t|Yearly salary \t|10% Raise \t|");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("|"+e1.getEmployeeFirstName()+"\t|"+
							e1.getEmployeeLastName()+"\t\t|"+
							e1.getEmployeeSalary()+"\t|"+
							e1.getYearlyEmployeeSalary()+"\t|"+
							(e1.getYearlyEmployeeSalary()+e1.getYearlyEmployeeSalary()*0.1)+"\t|");
		
		System.out.println("|"+e2.getEmployeeFirstName()+"\t|"+
							e2.getEmployeeLastName()+"\t\t|"+
							e2.getEmployeeSalary()+"\t|"+
							e2.getYearlyEmployeeSalary()+"\t|"+
							(e2.getYearlyEmployeeSalary()+e2.getYearlyEmployeeSalary()*0.1)+"\t|");
		System.out.println("-----------------------------------------------------------------------------------------");

	}

}
