/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitallIS.controller.algorithms;
import com.hospitalIS.model.HospitalISModel;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Suyesh Neupane
 */

public class BinarySearch {

    // Generic binary search method
    public HospitalISModel searchByField(String searchValue, String searchColumn, List<HospitalISModel> patientList, int left, int right) {
        if (right < left) {
            return null; // Element not found
        }

        int mid = (left + right) / 2;

        // Get the value based on the selected column
        String midValue = getFieldValue(patientList.get(mid), searchColumn);

        // Handle numeric comparisons for Drone ID
        if (searchColumn.equals("Patient ID")) {
            try {
                int searchInt = Integer.parseInt(searchValue); // Convert the search value to an integer
                int midInt = Integer.parseInt(midValue); // Convert mid value (Drone ID) to integer

                if (searchInt == midInt) { // Match found
                    return patientList.get(mid);
                } else if (searchInt < midInt) { // Search left half
                    return searchByField(searchValue, searchColumn, patientList, left, mid - 1);
                } else { // Search right half
                    return searchByField(searchValue, searchColumn, patientList, mid + 1, right);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for patient ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        // Default case (string comparison for other fields, if needed)
        int comparison = searchValue.compareToIgnoreCase(midValue);
        if (comparison == 0) { // Match found
            return patientList.get(mid);
        } else if (comparison < 0) { // Search left half
            return searchByField(searchValue, searchColumn, patientList, left, mid - 1);
        } else { // Search right half
            return searchByField(searchValue, searchColumn, patientList, mid + 1, right);
        }
    }

    // Helper method to fetch value based on selected column
    private String getFieldValue(HospitalISModel drone, String columnName) {
        switch (columnName) {
            case "Patient ID":
                return String.valueOf(drone.getPatientId()); // Convert integer to string
            case "Patient Name":
                return drone.getPatientName();
            case "Doctor Name":
                return drone.getDoctorName();
            case "Address":
                return drone.getAddress();
            case "Age":
                return String.valueOf(drone.getAge());
            case "Contact":
                return drone.getContact();
            case "Department":
                return drone.getDepartment();
            default:
                return ""; // Default case for unsupported columns
        }
    }
}