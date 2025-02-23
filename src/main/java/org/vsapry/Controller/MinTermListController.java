package org.vsapry.Controller;

import java.util.Set;
import org.vsapry.Model.MinTermList;
import org.vsapry.Model.MinTerm;

public class MinTermListController {

    public static Set<String> getMin(){
        return MinTermList.getMin();
    }

}
