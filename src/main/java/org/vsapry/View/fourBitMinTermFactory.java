package org.vsapry.View;

import org.vsapry.Model.MinTerm;

public class fourBitMinTermFactory implements MinTermFactory {

    @Override
    public MinTerm createMinterm(int numericValue) {

        if(numericValue < 0 || numericValue > 15){
            throw new IllegalArgumentException("Number should be between 0 and 7");
        }

        String bits = String.format("%4s", Integer.toBinaryString(numericValue))
                .replace(' ', '0'); // ensures leading zeros        }
        return new MinTerm(bits);
    }
}
