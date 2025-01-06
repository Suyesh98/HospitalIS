package com.hospitalIS.util;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 *
 * @author Suyesh Neupane
 */

public class ValidationUtil {

    // Regular expressions for validation
    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$"); // Only alphabets and spaces
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+"); // Numeric pattern
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^(97|98)\\d{8}$"); // Starts with 97 or 98, 10 digits
    private static final Pattern ALPHA_NUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s]+$"); // Alphanumeric with spaces
    private static final Pattern PATIENT_ID_PATTERN = Pattern.compile("^\\d{5}$"); // Patient ID with 5 digits
    private static final Pattern DEPARTMENT_PATTERN = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$"); // Up to 2 words, only alphabets

    // Helper method to check if a string is null or empty
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the doctor's name.
     * It should contain only alphabets and up to 4 words.
     *
     * @param doctorName the doctor's name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidDoctorName(String doctorName, JLabel lblError) {
        if (isNullOrEmpty(doctorName)) {
            lblError.setText("Doctor name cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(doctorName).matches() || doctorName.split("\\s+").length > 4) {
            lblError.setText("Doctor name must contain only alphabets and up to 4 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the patient ID.
     * It should be numeric and exactly 5 digits.
     *
     * @param patientId the patient ID to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidPatientId(String patientId, JLabel lblError) {
        if (isNullOrEmpty(patientId)) {
            lblError.setText("Patient ID cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!PATIENT_ID_PATTERN.matcher(patientId).matches()) {
            lblError.setText("Patient ID must be exactly 5 digits.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the patient's name.
     * It should contain only alphabets and up to 4 words.
     *
     * @param patientName the patient's name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidPatientName(String patientName, JLabel lblError) {
        if (isNullOrEmpty(patientName)) {
            lblError.setText("Patient name cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(patientName).matches() || patientName.split("\\s+").length > 4) {
            lblError.setText("Patient name must contain only alphabets and up to 4 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the address.
     * It should contain alphanumeric characters and up to 4 words.
     *
     * @param address the address to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidAddress(String address, JLabel lblError) {
        if (isNullOrEmpty(address)) {
            lblError.setText("Address cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!ALPHA_NUMERIC_PATTERN.matcher(address).matches() || address.split("\\s+").length > 4) {
            lblError.setText("Address must contain alphanumeric characters and up to 4 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the age.
     * It should be numeric and greater than 0.
     *
     * @param age the age to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidAge(String age, JLabel lblError) {
        if (isNullOrEmpty(age)) {
            lblError.setText("Age cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        try {
            int parsedAge = Integer.parseInt(age);
            if (parsedAge <= 0 || parsedAge>100) {
                lblError.setText("Age must be greater than 0 and less than 100.");
                lblError.setForeground(Color.RED);
                return false;
            }
        } catch (NumberFormatException e) {
            lblError.setText("Age must be a valid number.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the contact number.
     * It should be 10 digits, starting with 97 or 98.
     *
     * @param contact the contact number to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidContact(String contact, JLabel lblError) {
        if (isNullOrEmpty(contact)) {
            lblError.setText("Contact cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!CONTACT_PATTERN.matcher(contact).matches()) {
            lblError.setText("Contact must start with 97 or 98 and contain 10 digits.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }

    /**
     * Validates the department.
     * It should contain only alphabets and up to 2 words.
     *
     * @param department the department name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidDepartment(String department, JLabel lblError) {
        if (isNullOrEmpty(department)) {
            lblError.setText("Department cannot be empty.");
            lblError.setForeground(Color.RED);
            return false;
        }
        if (!DEPARTMENT_PATTERN.matcher(department).matches() || department.split("\\s+").length > 2) {
            lblError.setText("Department must contain only alphabets and up to 2 words.");
            lblError.setForeground(Color.RED);
            return false;
        }
        return true;
    }
}