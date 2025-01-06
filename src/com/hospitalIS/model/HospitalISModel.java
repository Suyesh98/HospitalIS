/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalIS.model;

/**
 *
 * @author Suyesh Neupane
 */
public class HospitalISModel {
    private String doctorName;
    private int patientId;
    private String patientName;
    private String address;
    private int age;
    private String contact;
    private String department;

    public HospitalISModel(){

    }

    // Constructor
    public HospitalISModel(int patientId, String patientName, String doctorName, String address, int age, String contact, String department) {
    this.patientId = patientId;
    this.patientName = patientName;
    this.doctorName = doctorName;
    this.address = address;
    this.age = age;
    this.contact = contact;
    this.department = department;
}

    // Getters and Setters
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
  
}
