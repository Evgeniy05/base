class example extends Exception {
	public void myException() {
		System.out.println("Возникло исключение");
	}

	static class Toys {
		public static short numbers = 0;

		public static short NewNumber() {
			return ++numbers;
		}

		public short number;

		public String name, size;

		public void setParam (String name,String size){
			try
			{
				this.name=name;
				this.size=size;
				if (this.number!=0)
					throw new example();
				this.number=Toys.NewNumber();
				
			}
	   catch (example e){
		   
		   System.err.println("Error");
			new example().myException(); 
                  	   }
			finally {
				System.out.println("Итого:"+this.name+this.size+this.number);
			}
		}
	}

public static void main(String[] args){
	 
		Toys car=new Toys();
		try
		{ car.setParam("Car", "Large");
		car.setParam("Car", "Small");}
		catch (Exception e)
		{
		}
		}
	    	
}