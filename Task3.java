import java.math.BigDecimal;
import java.util.Scanner;

public class Task3 {
	
	public static void main (String [] args){
		Scanner s=new Scanner(System.in);
		System.out.print("Vvedite temperatury po kelviny ");
		double vvod=s.nextDouble();
		
		System.out.println(perevod(vvod)+"°C");
		s.close();
	}
	public static double fl (double c){
		
		return c;
	}
	public static double perevod(double c){
    
		if(c<0)
			throw new IllegalArgumentException(Double.toString(c));
	     c=c-273.15;
	     return BigDecimal.valueOf(c).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
	}


