/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitallIS.controller.algorithms;
import com.hospitalIS.model.HospitalISModel;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Suyesh Neupane 23048682
 */
public class SelectionSort {
    
    List<HospitalISModel> hospitalSortList;

    public SelectionSort() {
        hospitalSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of HospitalISModel objects by their Patient ID in ascending or descending order.
     *
     * @param patientList the list of hospitalISModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<HospitalISModel> sortByPatientId(List<HospitalISModel> patientList, boolean isDesc) {
        this.hospitalSortList.clear();
        this.hospitalSortList.addAll(patientList);

        if (hospitalSortList == null || hospitalSortList.isEmpty()) {
            throw new IllegalArgumentException("patient list cannot be null or empty.");
        }

        // Selection sort algorithm
        for (int i = 0; i < hospitalSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(hospitalSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(hospitalSortList, i, extremumIndex);
            }
        }

        return hospitalSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list from the start index.
     *
     * @param hospitalSortList the list of HospitalISModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<HospitalISModel> hospitalSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < hospitalSortList.size(); j++) {
            if (shouldSwap(hospitalSortList.get(j).getPatientId(), hospitalSortList.get(extremumIndex).getPatientId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should replace the extremum; false otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param hospitalSortList the list of HospitalISModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<HospitalISModel> hospitalSortList, int i, int j) {
        HospitalISModel temp = hospitalSortList.get(i);
        hospitalSortList.set(i, hospitalSortList.get(j));
        hospitalSortList.set(j, temp);
    }
}