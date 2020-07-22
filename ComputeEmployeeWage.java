import java.util.*;

interface ComputeWage {

	public void addCompanyDetails(String companyName, int empWagePerHr, int totalWorkingHours, int totalWorkingDays);
	public void computeWage();
}

class CompanyEmpWage{

	// Class variable declarations
	private String COMPANY_NAME;
	private int empWagePerHr;
	private int totalWorkingHours;
	private int totalWorkingDays;
	private int totalWage;

	CompanyEmpWage(String companyName, int empWagePerHr, int totalWorkingHours, int totalWorkingDays){
		this.COMPANY_NAME=companyName;
		this.empWagePerHr=empWagePerHr;
		this.totalWorkingHours=totalWorkingHours;
		this.totalWorkingDays=totalWorkingDays;
	}

	// Methods to read class variables
	public int getEmpWagePerHr(){
		return this.empWagePerHr;
	}
	public int getMaxHrsPerMonth(){
		return this.totalWorkingHours;
	}
	public int getNumWorkingDays(){
		return this.totalWorkingDays;
	}
	public String toString(){
		return this.COMPANY_NAME+" has "+this.totalWage+" as total wage.";
	}
	
	// Modifiers
	public void setTotalWage(int totalWage){
		this.totalWage=totalWage;
	}
	
}
class ComputeEmployeeWage implements ComputeWage {

	public static final int IS_FULL_TIME=0; 
	public static final int IS_PART_TIME=1;
	ArrayList<CompanyEmpWage> companyWageArray ;

	public ComputeEmployeeWage(){
		companyWageArray = new ArrayList<CompanyEmpWage>();
	}
	
	public void addCompanyDetails(String companyName, int empWagePerHr, int totalWorkingHours, int totalWorkingDays){
		companyWageArray.add(new CompanyEmpWage(companyName,empWagePerHr,totalWorkingHours,totalWorkingDays));
	}

	private int employeeStatus() {

		return (int)Math.floor(Math.random() * 10) % 3;
	}
	
	private int getWorkingHrs(int empStatus){
		switch (empStatus)
		{
			case IS_PART_TIME: return 4;
			
			case IS_FULL_TIME: return 8;
		
			default: return 0;
		}
	}
	
	public void computeWage(){
		for(int emp=0 ; emp<companyWageArray.size();emp++)
		{
			companyWageArray.get(emp).setTotalWage(this.computeWage(companyWageArray.get(emp)));
			System.out.println(companyWageArray.get(emp));
		}
	}

	/* @Overloading */
	private int computeWage(CompanyEmpWage companyWage){

		int totalEmpHrs=0;
		int empHrs;
		int totalWorkingDays=0;

    	System.out.printf("%10s\t%20s\t%20s", "Day #", "Daily Wage", "Total Wage");
    	System.out.print('\n');
		while(totalEmpHrs<companyWage.getMaxHrsPerMonth() && totalWorkingDays<companyWage.getNumWorkingDays())
		{
			totalWorkingDays++;
			empHrs = this.getWorkingHrs(this.employeeStatus());
			totalEmpHrs+=empHrs;
			System.out.format("%10d\t%20d\t%20d\n", totalWorkingDays, empHrs*companyWage.getEmpWagePerHr(), totalEmpHrs*companyWage.getEmpWagePerHr());

		}
		return totalEmpHrs*companyWage.getEmpWagePerHr(); 
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Program");
		ComputeWage employeeWage = new ComputeEmployeeWage();
		employeeWage.addCompanyDetails("Future Retail",20,100,20);
		employeeWage.addCompanyDetails("Jio Mart",50,150,15);
		employeeWage.addCompanyDetails("D-Mart",15,50,30);
		
		employeeWage.computeWage();
	}
}