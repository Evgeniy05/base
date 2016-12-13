import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	 public Employee(String n,double s,int year,int month,int day) {
	        name = n;
	        salary=s;
	        GregorianCalendar calendar =new GregorianCalendar (year,month-1,day);
	        hireDay=calendar.getTime();
	        id=0;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getSalary() {
	        return salary;
	    }
        
	    public Date getHireDay(){
	    	return hireDay;}
        public void raiseSalary(double byPerecent){
        	double raise=salary*byPerecent/100;
        	salary+=raise;
        }
        
	    public void SetId(){
        	id=nextId;
        	nextId++;
        }
        public int getId(){
        	return id;
        }
        public  static int getNextId(){
        	return nextId;
        }
	    private String name;
	    private double salary;
	    private Date hireDay;
        private int id;
        private static int nextId=1;
        


	}


