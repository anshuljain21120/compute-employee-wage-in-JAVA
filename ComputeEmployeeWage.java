import java.util.*;
class ComputeEmployeeWage
{
	// Constants Definitions
	private static final int IS_PART_TIME=1, IS_FULL_TIME=2;
	private static String COMPANY_NAME;

	public ComputeEmployeeWage(String companyName)
	{
		this.COMPANY_NAME=companyName;
	}

	private int calculateWage(	int employeeID,
								int partTimeHrs, 
								int fullTimeHrs, 
								int wagePerHour, 
								int daysWorked, 
								int hoursWorked	)
	{
		// Function description & welcome message
		System.out.println("**********\tWelcome to Employee Wage Computation Program!\t**********");
		System.out.println("**********\tComputing for company: "+this.COMPANY_NAME+"\t**********");
		// Variable Definitions
		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalEmpWage = 0;
		int totalWorkingDays = 0;

		// Operation
		while(totalEmpHrs <= hoursWorked && totalWorkingDays < daysWorked) 
		{
			totalWorkingDays++;
			double empCheck = Math.floor(Math.random() * 10) % 3;
			switch ((int)empCheck)
			{
				case IS_PART_TIME:
					empHrs = partTimeHrs;
					break;
				case IS_FULL_TIME:
					empHrs = fullTimeHrs;
					break;
				default:
					empHrs = 0;
					break;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#: "+totalWorkingDays+"\t\tHours woked today: "+empHrs+"\tToday's Wage: "+empHrs*wagePerHour);
		}
		totalEmpWage = totalEmpHrs * wagePerHour;
		System.out.println("Employee with eID#"+employeeID+" got total monthly wage of "+totalEmpWage+" Rs by working "+totalWorkingDays+" day(s) totalling "+totalEmpHrs+" hour(s).");
		
		return totalEmpWage;
	}

	public void readEmpToGetWage()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter employee ID: ");
		int employeeID=sc.nextInt();	

		System.out.print("Enter part time hours: ");
		int partTimeHrs=sc.nextInt();
		
		System.out.print("Enter full time hours: ");
		int fullTimeHrs=sc.nextInt();
		
		System.out.print("Enter wage in Rs given per Hour : ");
		int wagePerHour=sc.nextInt();
		
		System.out.print("Enter number of days employee worked: ");
		int daysWorked=sc.nextInt();
		
		System.out.print("Enter number of hours employee worked: ");
		int hoursWorked=sc.nextInt();
		
		sc.close();
		
		int employeeWage = calculateWage(employeeID, partTimeHrs, fullTimeHrs, wagePerHour, daysWorked, hoursWorked);
	}

	public static void main(String[] args) 
	{
		ComputeEmployeeWage DMart = new ComputeEmployeeWage("DMart");
		DMart.readEmpToGetWage();

		// ComputeEmployeeWage Walmart = new ComputeEmployeeWage("Walmart");
		// Walmart.readEmpToGetWage();
	}
}
