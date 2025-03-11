package org.vsapry.Model;

import javax.naming.LimitExceededException;

public class Quine {
	// macro
	protected static final int MAX_TERMS = 0xff;// 0xff=255
	// attribute
	public MinTerm[] terms = new MinTerm[MAX_TERMS];
	public int numMinTermsInTerm = 0;

	// adding minterms
	public void addTerm(String str) throws LimitExceededException {
		if (numMinTermsInTerm == MAX_TERMS)
			throw new LimitExceededException("Cannot have more than 255 Terms");
		terms[numMinTermsInTerm++] = new MinTerm(str);
	}

	// converted to string
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < numMinTermsInTerm; i++) {
			buf.append(terms[i] + "\n");
		}
		return buf.toString();
	}

	// see whether the element already exists
	public boolean hasTerm(MinTerm a){
		for (int i = 0; i < numMinTermsInTerm; i++) {
			if (a.isSame(terms[i]))
				return true;
		}
		return false;
	}

	// verification of the function
	public void simplify(){
		while (reduce() > 0)
			;
	}

	// reduction of the minterm
	public int reduce(){
		// variable
		int reducedCount = 0;
		MinTerm[] reducedTerms = new MinTerm[MAX_TERMS];
		boolean[] used = new boolean[MAX_TERMS];
		// working with all minterms
		for (int i = 0; i < numMinTermsInTerm; i++) {
			for (int j = i + 1; j < numMinTermsInTerm; j++) {
				if (terms[i].numberOfDifferencesBetweenMinTerms(terms[j]) == 1) {
					reducedTerms[reducedCount++] = MinTerm.combine(terms[i], terms[j]);
					used[i] = true;
					used[j] = true;
				}
			}
		}

		int totalReduced = reducedCount;
		for (int i = 0; i < numMinTermsInTerm; i++) {
			if (!used[i]) {
				reducedTerms[totalReduced++] = terms[i];
			}
		}
		numMinTermsInTerm = 0;
		for (int i = 0; i < totalReduced; i++) {
			if (!hasTerm(reducedTerms[i]))
				terms[numMinTermsInTerm++] = reducedTerms[i];
		}
		return reducedCount;
	}
}