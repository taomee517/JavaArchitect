package org.demo.lambda.function;

import org.demo.lambda.evolution.entity.Man;

import java.util.Comparator;

public class AgeComparator implements Comparator<Man> {

    @Override
    public int compare(Man o1, Man o2) {
        int o1Age = o1.getAge();
        int o2Age = o2.getAge();
        if (o1Age>o2Age){
            return 1;
        }else if(o1Age<o2Age) {
            return -1;
        }
        return 0;
    }
}
