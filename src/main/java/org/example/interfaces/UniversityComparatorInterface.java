package org.example.interfaces;

import org.example.entities.University;

import java.util.Comparator;

public interface UniversityComparatorInterface extends Comparator<University> {
    int compare(University o1, University o2);
}
