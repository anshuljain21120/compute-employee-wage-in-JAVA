import java.util.*;

class CompanyEmpWage {
	// Constants Declarations
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	public final String COMPANY_NAME;
	public final String empName;
	public final int wagePerHours;
	public final int dailyHours;
	public final int dayPerMonth;
	public final int totalHours;

	public CompanyEmpWage(	String companyName, 
								String empName, 
								int wagePerHours, 
								int dailyHours, 
								int dayPerMonth, 
								int totalHours) 
	{
		// Constants Definitions
		this.COMPANY_NAME = companyName;
		this.empName = empName;
		this.wagePerHours = wagePerHours;
		this.dailyHours = dailyHours;
		this.dayPerMonth = dayPerMonth;
		this.totalHours = totalHours;
	}

	public int employMonthlyWage() {
		// Method variable definitions
		int dailyWage, totalWage = 0, dailyEmpHours = 0, hours = 0, day = 0;

		// computation
		while (hours < totalHours && day < dayPerMonth) {
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			switch (empCheck) {
				case IS_FULL_TIME:
				dailyEmpHours = dailyHours;
				break;

				case IS_PART_TIME:
				dailyEmpHours = dailyHours / 2;
				break;

				default:
				dailyEmpHours = 0;
			}
			hours += dailyEmpHours;
			day++;
			dailyWage = dailyEmpHours * wagePerHours;
			totalWage += dailyWage;
			System.out.println("Day: " + day + "  Hours: " + hours + "  DailyWage: " + dailyWage + "  TotalWage: "
				+ totalWage);
		}		
		return totalWage;
	}
}

public class ComputeEmployeeWage{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of companies(<=5): ");
		int totalCompanies = sc.nextInt();
		CompanyEmpWage array[] = new CompanyEmpWage[totalCompanies];
     
	    for(int i=0; i<totalCompanies; i++) 
	    {
		    System.out.print("Enter the name of the company: ");
		    String company = sc.next();

		    System.out.print("Enter the name of the  employ: ");
		    String empName = sc.next();

		    System.out.print("Enter the total daily hour: ");
		    int dailyHours = sc.nextInt();

		    System.out.print("Enter the wage per hour: ");
		    int wagePerHours = sc.nextInt();

		    System.out.print("Enter the days in a month: ");
		    int dayPerMonth = sc.nextInt();

		    System.out.print("Enter the total hours of that month you are gonna work: ");
		    int totalHours = sc.nextInt();
		   
		    array[i] = new CompanyEmpWage(company, empName, wagePerHours, dailyHours, dayPerMonth, totalHours);
		    System.out.println("Employ Name: " +array[i].empName+ " | Company name: "+array[i].COMPANY_NAME+" | Total Wage: "+array[i].employMonthlyWage());
	        System.out.println();			
	    }
		sc.close();
	}
}