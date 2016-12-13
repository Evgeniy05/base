
public class Stroka {
String s,result;

	public String getS() {
	return s;
}

public void setS(String s) {
	this.s = s;
}

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}

	public String convert(String s, char a){
		String result="";
		for(int i=0; i<s.length();i++){
		  if(s.charAt(i)==a){
			  result+=i;
		  }
		}
		
		return result;
	}
	
}
