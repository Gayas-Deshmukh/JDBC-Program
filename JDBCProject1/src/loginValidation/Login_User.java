package loginValidation;

import java.util.Scanner;

public class Login_User 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER  THE USERNAME");
		String user=sc1.next();
		System.out.println("ENTER THE PASSWORD");
		String password=sc1.next();

		if(user.equals("admin") && password.equals("123"))
		{
			System.out.println("LOGIN SUCCESSFULL");
		}
		else
		{
			System.err.println("INVALID LOGIN DETAILS");
		}

	}

}
