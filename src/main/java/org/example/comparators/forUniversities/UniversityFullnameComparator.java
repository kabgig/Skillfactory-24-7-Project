package org.example.comparators.forUniversities;

import org.apache.commons.lang3.StringUtils;
import org.example.entities.University;
import org.example.interfaces.UniversityComparatorInterface;

public class UniversityFullnameComparator implements UniversityComparatorInterface {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullname(), o2.getFullname());
    }
}
