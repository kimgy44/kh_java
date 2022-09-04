package homework0518;

import java.util.Scanner;

//아래는 변수 num의 값 중에서 일의 자리를 1로 바꾸는 코드이다. 
//만일 변수 num의 값이 333이라면 331이 되고, 777이라면 771이 된다. (1)에 알맞은 코드를 넣으시오.
public class A {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 char ch = ' ';
		 
		 String input = scanner.nextLine();
		 ch = input.charAt(0);
		 if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
		 
	     System.out.println( "입력하신 문자는 영문자입니다%n" );
		 }
	}
		 

}
