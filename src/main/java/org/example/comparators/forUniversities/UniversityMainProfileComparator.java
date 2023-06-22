package org.example.comparators.forUniversities;

import org.example.University;
import org.example.interfaces.UniversityComparatorInterface;

public class UniversityMainProfileComparator implements UniversityComparatorInterface {
    @Override
    public int compare(University o1, University o2) {
        return o1.getMainProfile().compareTo(o2.getMainProfile());
    }
}
