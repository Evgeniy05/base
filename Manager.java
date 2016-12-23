

	public class Manager extends Employee {
	    public Manager(String n,double s,int year,int month, int day){
	        super(n,s,year,month,day);
	        
	    }
	    public double getSalary(){
	        double baseSalary=super.getSalary();
	        return baseSalary+bonus;
	    }
	    public void setBonus(double b){
	    	bonus=b;
	    }
	    public double getBonus(){
	    	return bonus;
	    }
	    private double bonus;
	}



