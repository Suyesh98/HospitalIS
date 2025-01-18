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
 * @author Suyesh Neupane
 */
public class InsertionSort {
    
    List<HospitalISModel> hospitalSortList;

    public InsertionSort() {
        hospitalSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of HospitalISModel objects by their PatientName in ascending or descending order.
     *
     * @param patientList the list of HospitalISModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<HospitalISModel> sortByPatientName(List<HospitalISModel> patientList, boolean isDesc) {
        this.hospitalSortList.clear();
        this.hospitalSortList.addAll(patientList);

        if (hospitalSortList == null || hospitalSortList.isEmpty()) {
            throw new IllegalArgumentException("Patient list cannot be null or empty.");
        }

        // Insertion sort algorithm
        for (int i = 1; i < hospitalSortList.size(); i++) {
            HospitalISModel currentPatient = hospitalSortList.get(i);
            int j = i - 1;

            // Move elements that are greater than currenthospital (or less, based on order)
            while (j >= 0 && shouldSwap(currentPatient.getPatientName(), hospitalSortList.get(j).getPatientName(), isDesc)) {
                hospitalSortList.set(j + 1, hospitalSortList.get(j));
                j = j - 1;
            }
            hospitalSortList.set(j + 1, currentPatient);
        }

        return hospitalSortList;
    }

    /**
     * Determines whether the current PatientName should be swapped based on the order.
     *
     * @param current the current PatientName value
     * @param comparison the PatientName to compare with
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current PatientName should be swapped; false otherwise
     */
    private boolean shouldSwap(String current, String other, boolean isDesc){
     int comparisonResult=current.compareTo(other);//lexicographical comparison
     return isDesc?comparisonResult>0:comparisonResult<0;
    }
}