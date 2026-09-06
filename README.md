# Mini Hospital Emergency Management System

This project implements a Java-based mini hospital emergency management system using core data structures:

- Binary Search Tree for patient records
- Queue for emergency patient management
- Stack for completed treatment history
- Singly Linked List for patient visit history

## Features

- Register, search, and delete patients by Patient ID
- Display all patients in ascending ID order using in-order traversal
- Add and remove patients from the emergency queue
- Store completed treatment records in a stack
- Track patient visit history with linked-list visits

## Project Structure

```text
src/
  main/java/hospital/
    EmergencyQueue.java
    HospitalManagementSystem.java
    Patient.java
    PatientBST.java
    PatientVisitHistory.java
    TreatmentRecord.java
    TreatmentStack.java
    VisitRecord.java
  test/java/hospital/
    HospitalSystemTest.java
```

## How to Run

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out hospital.HospitalManagementSystem
```

## Test Run

```bash
javac -d out $(find src/main/java -name "*.java")
javac -cp out -d out/test src/test/java/hospital/HospitalSystemTest.java
java -cp out:out/test hospital.HospitalSystemTest
```

## Development Evidence

This repository contains multiple commits showing the progressive development of the assignment, including project setup, implementation of core data structures, and validation.
