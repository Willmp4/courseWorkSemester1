package Seminar4;

import java.util.Scanner;

public class IntrestRate {
	public static void main(String args[]) 
    {
        float p, r, t, sinterest;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Principal : ");
        p = scan.nextFloat();
        System.out.print("Enter the Rate of interest : ");
        r = scan.nextFloat();
        System.out.print("Enter the Time period : ");
        t = scan.nextFloat();
        
        for(int i = 1; i<=t; i++) {
        	sinterest = (p * r * i) / 100;
        	System.out.println("Year" + i+ " "+  (sinterest + p));
        }
        
    }
	}


