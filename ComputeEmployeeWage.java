import java.util.*;
class ComputeEmployeeWage
{
	public static void main(String args[])
	{
		System.out.println("Welcome to Employee Wage Computation Program!");
		// Variable declaration	
		int IS_FULL_TIME = 1;
			// Operation
		double empCheck = Math.floor(Math.random() * 10) % 2;
		if(empCheck == IS_FULL_TIME)
			System.out.println("Employee is Present");
		else
			System.out.println("Employee is Abscent");
	}
}
