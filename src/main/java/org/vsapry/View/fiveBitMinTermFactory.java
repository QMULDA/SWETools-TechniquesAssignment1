package org.vsapry.View;

import org.vsapry.Model.MinTerm;

public class fiveBitMinTermFactory implements MinTermFactory{

    @Override
    public MinTerm createMinterm(int numericValue) {

        if(numericValue < 0 || numericValue > 31){
            throw new IllegalArgumentException("Number should be between 0 and 7");
        }

        String bits = String.format("%5s", Integer.toBinaryString(numericValue))
                .replace(' ', '0'); // ensures leading zeros        }
        return new MinTerm(bits);
    }

}
