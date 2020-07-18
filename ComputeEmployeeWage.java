import java.util.*;
class ComputeEmployeeWage
{
	public static void main(String args[])
	{
		System.out.println("Welcome to Employee Wage Computation Program!");
		// Constants Definitions	
		int IS_FULL_TIME = 1;
		int EMP_RATE_PER_HOUR = 20;
		// Variable Definitions
		int empHrs = 0;
		int empWage = 0;
			// Operation
		double empCheck = Math.floor(Math.random() * 10) % 2;
		if(empCheck == IS_FULL_TIME)
			empHrs = 8;
		else
			empHrs = 0;
		empWage = empHrs * EMP_RATE_PER_HOUR;
		System.out.println("Emp Wage: " + empWage);
	}
}
