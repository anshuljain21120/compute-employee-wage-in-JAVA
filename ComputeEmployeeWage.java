import java.util.*;

interface ComputeWage {

	public void addCompanyDetails(String companyName, int empWagePerHr, int totalWorkingHours, int totalWorkingDays);
	public void computeWage();
	public void getTotalWage(String company);
}

class CompanyEmpWage{

	// Class variable declarations
	private String COMPANY_NAME;
	private int empWagePerHr;
	private int totalWorkingHours;
	private int totalWorkingDays;
	private int totalWage;
	private ArrayList<Integer> dailyWage;

	CompanyEmpWage(String companyName, int empWagePerHr, int totalWorkingHours, int totalWorkingDays){
		this.COMPANY_NAME=companyName;
		this.empWagePerHr=empWagePerHr;
		this.totalWorkingHours=totalWorkingHours;
		this.totalWorkingDays=totalWorkingDays;
		dailyWage=new ArrayList<Integer>();
	}

	// Methods to read class variables
	public String getCompanyName(){
		return this.COMPANY_NAME;
	}
	public int getTotalWage(){
		return this.totalWage;
	}
	public int getEmpWagePerHr(){
		return this.empWagePerHr;
	}
	public int getMaxHrsPerMonth(){
		return this.totalWorkingHours;
	}
	public int getNumWorkingDays(){
		return this.totalWorkingDays;
	}
	public ArrayList<Integer> getDailyWage(){
		return this.dailyWage;
	}
	public String toString(){
		return this.getCompanyName()+" has "+this.getTotalWage()+" as total wage.";
	}
	
	// Modifiers
	public void setTotalWage(int totalWage){
		this.totalWage=totalWage;
	}
	public void setDailyWage(int wage){
		this.dailyWage.add(wage);
	}
	
}
class ComputeEmployeeWage implements ComputeWage {

	public static final int IS_FULL_TIME=0; 
	public static final int IS_PART_TIME=1;
  
	ArrayList<CompanyEmpWage> companyWageArray ;
	HashMap<String,CompanyEmpWage> totalWageOf;

	public ComputeEmployeeWage(){
		companyWageArray=new ArrayList<CompanyEmpWage>();
		totalWageOf=new HashMap<String,CompanyEmpWage>(); 
	}
	
	public void addCompanyDetails(String companyName, int empWagePerHr, int totalWorkingHours, int totalWorkingDays){
		
		CompanyEmpWage companyDetails=new CompanyEmpWage(companyName,empWagePerHr,totalWorkingHours,totalWorkingDays);
		companyWageArray.add(companyDetails);
		totalWageOf.put(companyName, companyDetails);
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

	public void getTotalWage(String companyName){

		System.out.println("[+Output]: Total Wage for "+companyName+" is:- "+totalWageOf.get(companyName).getTotalWage());
	}
	
	public void computeWage(){
		for(int emp=0 ; emp<companyWageArray.size();emp++)
		{
			companyWageArray.get(emp).setTotalWage(this.computeWage(companyWageArray.get(emp)));
			for(int day=0;day<companyWageArray.get(emp).getDailyWage().size();day++)
			{
				System.out.println("\tDay "+(day+1)+"\t"+companyWageArray.get(emp).getDailyWage().get(day));
			}
			System.out.println(companyWageArray.get(emp));
		}
	}

	/* @Overloading */
	private int computeWage(CompanyEmpWage companyWage){

		int totalEmpHrs=0;
		int empHrs;
		int totalWorkingDays=0;

    	System.out.printf("\n%10s\t%20s\t%20s", "Day #", "Daily Wage", "Total Wage");
    	System.out.printf("\n%30s", "*\t"+companyWage.getCompanyName()+"\t*");
    	System.out.print('\n');
		while(totalEmpHrs<companyWage.getMaxHrsPerMonth() && totalWorkingDays<companyWage.getNumWorkingDays())
		{
			totalWorkingDays++;
			empHrs = this.getWorkingHrs(this.employeeStatus());
			totalEmpHrs+=empHrs;
			System.out.format("%10d\t%20d\t%20d\n", totalWorkingDays, empHrs*companyWage.getEmpWagePerHr(), totalEmpHrs*companyWage.getEmpWagePerHr());
			companyWage.setDailyWage(empHrs*companyWage.getEmpWagePerHr());
		}
		return totalEmpHrs*companyWage.getEmpWagePerHr(); 
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Program");
		ComputeWage employeeWage=new ComputeEmployeeWage();
		employeeWage.addCompanyDetails("D-Mart",15,50,30);
		employeeWage.addCompanyDetails("Wall Mart",50,150,15);
		employeeWage.addCompanyDetails("Future Retail",20,100,20);
		
		employeeWage.computeWage();

		employeeWage.getTotalWage("D-Mart");
		employeeWage.getTotalWage("Wall Mart");
		employeeWage.getTotalWage("Future Retail");
	}
}