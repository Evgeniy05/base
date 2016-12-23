

	public class Director extends Employee {
	    public Director(String n,double s,int year,int month,int day){
	        super(n,s,year,month,day);
	        time=5;
	    }
	    public double getSalary(){
	        double baseSalary=super.getSalary();
	        return baseSalary*time;
	    }
	    private double time;
	}


