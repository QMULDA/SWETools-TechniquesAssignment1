package org.vsapry.Model;

public class MinTerm {
	// input data representation
	public static final char NOT_CH = '0';
	public static final char SET_CH = '1';
	public static final char ANY_CH = '_';
	// internal data representation
	protected static final int NOT = 0;
	protected static final int SET = 1;
	protected static final int ANY = -1;
	// attribute
	protected int numberOfCharsInMinTerm;
	protected int[] term;

	// constructing & reading
	//it creates an array of integers that is the same length as the string
	//for every char  in string, it looks at the char and fills the array with the correct mapping
	public MinTerm(String str) {
		term = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case NOT_CH:
				term[numberOfCharsInMinTerm++] = NOT;
				break;
			case SET_CH:
				term[numberOfCharsInMinTerm++] = SET;
				break;
			case ANY_CH:
				term[numberOfCharsInMinTerm++] = ANY;
				break;
			}
		}
	}

	// converted to string
	//creates a stringbuffer that is the length of the number of terms
	//for every term, it is converted from 0,1,-1 to "0","1","-1"
	public String integersToString() {
		StringBuffer buf = new StringBuffer(numberOfCharsInMinTerm);
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			switch (term[i]) {
			case NOT:
				buf.append(NOT_CH);
				break;
			case SET:
				buf.append(SET_CH);
				break;
			case ANY:
				buf.append(ANY_CH);
				break;
			}
		}
		return buf.toString();
	}

	public boolean isSame(MinTerm a) {
		if (numberOfCharsInMinTerm != a.numberOfCharsInMinTerm)
			throw new IllegalArgumentException("MinTerms need to be the same length of characters to compare");
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			if (term[i] != a.term[i])
				return false;
		}
		return true;
	}

	public int numberOfDifferencesBetweenMinTerms(MinTerm a) {
		if (numberOfCharsInMinTerm != a.numberOfCharsInMinTerm)
			throw new IllegalArgumentException("MinTerms are differing lengths");
		int numberOfDifferencesBetweenMinTerms = 0;
		for (int i = 0; i < numberOfCharsInMinTerm; i++) {
			if (term[i] != a.term[i])
				numberOfDifferencesBetweenMinTerms++;
		}
		return numberOfDifferencesBetweenMinTerms;
	}

	public static MinTerm combine(MinTerm a, MinTerm b) {
		StringBuffer buf = new StringBuffer(a.numberOfCharsInMinTerm);
		for (int i = 0; i < a.numberOfCharsInMinTerm; i++) {
			if (a.term[i] != b.term[i])
				buf.append(ANY_CH);
			else
				buf.append(a.integersToString().charAt(i));
		}
		return new MinTerm(buf.toString());
	}
}
