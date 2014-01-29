package com.sec.util;

import java.util.ArrayList;

public class Calc {

	//Returns a random prime number between 2 and max
	public static int primeNumber(int max) {
		int to = max + 1;
		boolean[] gestrichen = new boolean[to];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < to; i++) {
			gestrichen[i] = false;
		}
		for (int i = 2; i < Math.sqrt(to); i++) {
			if (!gestrichen[i]) {
				for (int j = i * i; j < to; j += i)
					gestrichen[j] = true;
			}
		}
		for (int i = 2; i < gestrichen.length; i++) {
			if (!gestrichen[i])
				primes.add(i);
		}
		return primes
				.get((int) Math.floor(Math.random() * (primes.size() - 1)));
	}

	//Returns a random primeroot modulo p
	public static int primeRoot(int p) {
		ArrayList<Integer> tried = new ArrayList<Integer>();
		while (true) {
			boolean found = false;
			int g = 0;
			while (!found) {
				g = (int) Math.floor(Math.random() * (p - 4) + 2);
				if (tried.size() == 0)
					tried.add(g);
				for (int i = 0; i < tried.size(); i++) {
					if (tried.get(i) == g)
						break;
					tried.add(g);
				}
				found = tried.get(tried.size() - 1) == g;
			}
			int[] mods = new int[p - 1];
			for (int i = 0; i < (p - 1); i++) 
				mods[i] = (int) Math.floor(Math.pow(g, i) % p);
			if (allUnequal(mods))
				return g;
		}
	}

	//Checks whether all the Integers in num[] are equal
	private static boolean allUnequal(int[] num) {
		boolean unequal = true;
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] == num[j])
					unequal = false;
			}
		}
		return unequal;
	}
}
