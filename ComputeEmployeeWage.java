import java.util.*;

public class ComputeEmployeeWage {
	// Constants Declarations
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	public final String COMPANY_NAME;
	public final String empName;
	public final int wagePerHours;
	public final int dailyHours;
	public final int dayPerMonth;
	public final int totalHours;

	public ComputeEmployeeWage(	String companyName, 
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

	private int employMonthlyWage() {
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
		System.out.println("Employee Name "+empName+" Got Total monthly wage of Rs: "+totalWage+"  and Total Hours: "+hours+"  Total Day is: "+day);
		System.out.println();
		
		return totalWage;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of companies(<=5): ");
		int counter = sc.nextInt();
		Map<String, Integer> companyWage = new HashMap<>();
		
		for(int i=1; i<=counter; i++) 
		{
			System.out.print("Enter the name of the company: ");
			String companyName = sc.next();

			System.out.print("Enter the name of the employee: ");
			String empName = sc.next();

			System.out.print("Enter the total daily hour: ");
			int dailyHours = sc.nextInt();

			System.out.print("Enter the wage per hour: ");
			int wagePerHours = sc.nextInt();

			System.out.print("Enter the days in a month: ");
			int dayPerMonth = sc.nextInt();

			System.out.print("Enter number of hours employee worked: ");
			int totalHours = sc.nextInt();

			switch(i)
			{
				case 1:
				ComputeEmployeeWage companyOne=new ComputeEmployeeWage(companyName, empName, wagePerHours, dailyHours, dayPerMonth, totalHours);
				companyWage.put(companyName, companyOne.employMonthlyWage());
				System.out.print('\n');
				break;
				
				case 2:
				ComputeEmployeeWage companyTwo=new ComputeEmployeeWage(companyName, empName, wagePerHours, dailyHours, dayPerMonth, totalHours);
				companyWage.put(companyName, companyTwo.employMonthlyWage());
				System.out.print('\n');
				break;

				case 3:
				ComputeEmployeeWage companyThree=new ComputeEmployeeWage(companyName, empName, wagePerHours, dailyHours, dayPerMonth, totalHours);
				companyWage.put(companyName, companyThree.employMonthlyWage());
				System.out.print('\n');
				break;

				case 4:
				ComputeEmployeeWage companyFour=new ComputeEmployeeWage(companyName, empName, wagePerHours, dailyHours, dayPerMonth, totalHours);
				companyWage.put(companyName, companyFour.employMonthlyWage());
				System.out.print('\n');
				break;

				case 5:
				ComputeEmployeeWage companyFive=new ComputeEmployeeWage(companyName, empName, wagePerHours, dailyHours, dayPerMonth, totalHours);
				companyWage.put(companyName, companyFive.employMonthlyWage());
				System.out.print('\n');
				break;

				default:
				System.out.println("More than this is not supported yet!");
			}
		}

		System.out.println("Company wage stored: " +companyWage);
		System.out.println("Enter the company name to get the total wage");
		String companyName = sc.next();
		System.out.println("Total wage for the company name: " +companyName+ " "+companyWage.get(companyName));
		sc.close();
	}

}