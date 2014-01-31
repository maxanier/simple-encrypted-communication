package com.sec.util;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calc {

	// Returns a random BigInteger, maximum value is 2^bitLength-1, that is most
	// probably prime (chances that it is not prime are 2^(-100))
	public static BigInteger prime(int bitLength) {
		return BigInteger.probablePrime(bitLength, new java.util.Random());
	}

	// Returns a random primitive root of BigInteger p. p must be prime, else
	// null is returned
	public static BigInteger primeRoot(BigInteger p) {
		if (!p.isProbablePrime(100))
			return null;

		ArrayList<BigInteger> tried = new ArrayList<BigInteger>();
		while (true) {
			boolean found = false;
			BigInteger g = null;
			while (!found) {
				g = new BigInteger(p.bitCount(), new java.util.Random());
				if (tried.size() == 0)
					tried.add(g);
				boolean notInList = true;
				for (int i = 0; i < tried.size(); i++)
					if (tried.get(i) == g)
						notInList = false;
				if (notInList)
					tried.add(g);
				found = tried.get(tried.size() - 1) == g;
			}

			int[] mods = new int[p.subtract(new BigInteger("" + 1)).intValue()];
			for (int i = 0; i < (p.subtract(new BigInteger("" + 1)).intValue()); i++)
				mods[i] = g.modPow(new BigInteger("" + i), p).intValue();
			if (allUnequal(mods))
				return g;
		}
	}
	
	//Returns a random BigInteger, maximum size is p-sub
	public static BigInteger random(BigInteger p, int sub) {
		BigInteger r;
		BigInteger max = p.subtract(new BigInteger(""+sub));
		do {
			r = new BigInteger(p.bitCount(), new java.util.Random());
		}
		while(r.compareTo(max) > 0);
		return r;
	}
	
	//Checks whether all the values in num[] are unequal, used in prime root calculation
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