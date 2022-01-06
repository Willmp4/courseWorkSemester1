package Seminar8;

public class Pass {
	public static void nPrintLn(String message , int n)
	{
		for( int i = 0; i < n; i++)
		{
			System.out.println(message);
		}
	}

	public static void main(String[] args)
	{
		nPrintLn("Computer Science" ,15);
		
	}

}
