package Seminar9;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class avrg100Nums {
	static int count;
	static ArrayList<Integer> big_list = new ArrayList<Integer>();
	static ArrayList<Double> avrgs = new ArrayList<Double>();
	static Scanner input = new Scanner(System.in);

	static double total = 0;

	static void total(ArrayList<Integer> nums) {

		for (double numbers : nums) {
			total += numbers;
		}

	}

	static double avrg(ArrayList<Integer> nums) {
		double avg = 0;
		avg = total / nums.size();

		return avg;
		// returns the avrg of the numbers within the list
	}

	static void run() {

		double max_total = 0;
		double max_avrg = 0;
		double temp_total = 0;
		double temp_avrg = 0;
		double lowest_total = 10000;
		double lowest_avrg = 10000;
		double ltemp_total;
		double ltemp_avrg;
		ArrayList<Integer> prev_list = null;
		ArrayList<Integer> lprev_list = null;

		for (int i = 1; i <= 1000; i++) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			// Adds a 100 random numbers to a list
			Random rand = new Random();
			rand.setSeed(System.nanoTime());
			while ((nums.size() != 10)) {
				Integer r = rand.nextInt(100);
				nums.add(r);
			}

			total(nums);
			temp_total = total;
			temp_avrg = avrg(nums);

			ltemp_total = total;
			ltemp_avrg = avrg(nums);

			if (ltemp_avrg < lowest_avrg) {
				lowest_avrg = ltemp_avrg;
				if (ltemp_total < lowest_total) {
					lprev_list = nums;

				}
			}
			if (ltemp_total < lowest_total) {
				lowest_total = ltemp_total;

			}

			if (temp_avrg > max_avrg) {
				max_avrg = temp_avrg;
				if (temp_total > max_total) {
					prev_list = nums;

				}
			}
			if (temp_total > max_total) {
				max_total = temp_total;

			}

			total = 0;

		}
		System.out.println();
		System.out.println(prev_list);
		System.out.println("The max total is " + max_total);
		System.out.println("The max average is " + max_avrg);
		System.out.println(lprev_list);
		System.out.println("The lowest total is " + lowest_total);
		System.out.println("The lowest average is " + lowest_avrg);
	}

	public static void main(String[] args) {

		run();

	}
}
