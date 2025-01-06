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
public class MergeSort {
    
    // Sort a list of HospitalISModel objects based on DoctorName (String) in ascending or descending order
    public List<HospitalISModel> sortByDoctorName(List<HospitalISModel> patientList, boolean isDesc) {
        if (patientList == null || patientList.isEmpty()) {
            throw new IllegalArgumentException("Patient list cannot be null or empty.");
        }

        // Convert the List to an array for merge sort (MergeSort works with arrays)
        List<HospitalISModel> sortedList = new ArrayList<>(patientList);
        mergeSort(sortedList, 0, sortedList.size() - 1, isDesc);
        return sortedList;
    }

    // The mergeSort function recursively splits the list and merges it back
    private void mergeSort(List<HospitalISModel> list, int left, int right, boolean isDesc) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(list, left, mid, isDesc);   // Sort the left half
            mergeSort(list, mid + 1, right, isDesc); // Sort the right half
            
            merge(list, left, mid, right, isDesc); // Merge the sorted halves
        }
    }

    // The merge function combines two sorted halves of the list
    private void merge(List<HospitalISModel> list, int left, int mid, int right, boolean isDesc) {
        // Temporary arrays for the two halves
        List<HospitalISModel> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<HospitalISModel> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));
        
        int i = 0, j = 0, k = left;
        
        // Merge the two halves based on DoctorName (String comparison)
        while (i < leftList.size() && j < rightList.size()) {
            if (shouldSwap(leftList.get(i).getDoctorName(), rightList.get(j).getDoctorName(), isDesc)) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        
        // Copy any remaining elements from the left half
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        
        // Copy any remaining elements from the right half
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

    // Determine whether to swap based on the sorting order (ascending/descending)
    private boolean shouldSwap(String leftDoctorName, String rightDoctorName, boolean isDesc) {
        return isDesc ? leftDoctorName.compareTo(rightDoctorName) > 0 : leftDoctorName.compareTo(rightDoctorName) < 0;
    }
}