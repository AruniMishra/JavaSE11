package collection;

import collection.SmartDog;

import java.util.Comparator;

class SmartDogComparator implements Comparator<SmartDog> {

    // see collection.ComparableExample.java
    public int compare(SmartDog s1, SmartDog s2) {
        return s1.dogType.smartLevel - (s2.dogType.smartLevel);
    }
}