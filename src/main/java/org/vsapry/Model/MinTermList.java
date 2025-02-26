package org.vsapry.Model;
import org.vsapry.Model.MinTerm;
import java.util.Set;
import java.util.TreeSet;

public class MinTermList {

    private Set<String> set=new TreeSet<String>();

    public void setMinList(String x){

        set.add(x);

    }

    public Set<String> getMin() {
        return new TreeSet<>(set);
    }

}
