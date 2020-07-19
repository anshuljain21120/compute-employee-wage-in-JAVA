import java.util.*;
class ComputeEmployeeWage
{
	// Constants Definitions
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 20;
	public static final int MAX_HOURS_IN_A_MONTH = 10;

	public static void main(String args[])
	{
		System.out.println("Welcome to Employee Wage Computation Program!");
		// Variable Definitions
		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalEmpWage = 0;
		int totalWorkingDays = 0;
			// Operation
		while(totalEmpHrs <= MAX_HOURS_IN_A_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) 
		{
			totalWorkingDays++;
			double empCheck = Math.floor(Math.random() * 10) % 3;
			switch ((int)empCheck)
			{
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
					break;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
		}
		totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
		System.out.println("Total Emp Wage: " + totalEmpWage);
	}
}
