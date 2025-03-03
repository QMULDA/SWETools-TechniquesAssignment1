package org.vsapry.Controller;

import org.vsapry.ExceptionQuine;
import org.vsapry.Model.MinTerm;
import org.vsapry.Model.Quine;

public class QuineController {

    private Quine quine;

    public QuineController(Quine quine) {this.quine = quine;}

    public void addTerm(String str) throws ExceptionQuine {
        quine.addTerm(str);
    }

    public String toString(){
        return quine.toString();
    }

    public void simplify() throws ExceptionQuine{
        quine.simplify();
    }

}
