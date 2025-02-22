package org.vsapry.Model;

import java.util.Set;
import java.util.TreeSet;

public class GetMintermList {

	static Set<String> set=new TreeSet<String>();

	
	public void setMinList(String x){
	
		set.add(x);
		
	}

//TODO REROUTE ALL THE GUI CALLS TO MINTERM LIST TO MINTERMCONTROLLLER


public static Set<String> getMin(){
	return set;
}
	
}





