
public class Books {
String author;
String nameBook;
int number;
static int numbers=0;
Books(){
	number=++numbers;
}
Books(String author,String nameBook){
 this();
 this.author=author;
 this.nameBook=nameBook;}

public static void main (String args[] ){
	Books my = new Books ();
	Books read = new Books("Fall","Down");
	System.out.println(my.number);
	System.out.println(read.author+read.nameBook+read.number);
}
}