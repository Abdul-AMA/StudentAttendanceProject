# Student Attendance Project

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Usage](#usage)
- [Account Types](#account-types)
- [Admin Interface](#admin-interface)
- [Teacher Interface](#teacher-interface)
- [Notes](#notes)
- [UML Diagrams](#uml-diagrams)
- [Authors](#authors)
- [Acknowledgments](#acknowledgments)

## Overview
The Student Attendance Project is a Java-based application designed to simplify the process of managing student attendance in educational institutions. The program offers an intuitive graphical user interface (GUI) that allows administrators and teachers to efficiently handle various attendance-related tasks.

## Features
The Student Attendance Project offers the following key features:

1. User-friendly login interface with a username and password for access.
2. **Forgot Password** option for account recovery (admin/teacher).
3. **Lost Data** option to restore previous data (Note: Last modification may be lost).
4. Two account types: Admin and Teacher.
5. **Admin Interface** with the ability to:
    - Create, edit, and display courses.
    - Create, edit, and display teachers.
    - Link teachers to their respective courses.

6. **Teacher Interface** with the ability to:
    - Create, add, edit, and remove students from courses.
    - View student statistics within a course.
    - Create, edit, and remove lectures for a course.
    - View lecture statistics within a course.
    - Mark attendance for students in lectures using name, ID, phone number, or CSV import.
    - Use a webcam to scan ID cards for student identification and marking attendance.
    - View individual student records and make attendance changes for other lectures.
    - Display a table of students with an absence of 25% or more and export them to a CSV file.


## Usage
Follow the steps below to use the Student Attendance Project:

1. Clone or download the project from [GitHub Repo](https://github.com/Abdul-AMA/StudentAttendanceProject)
2. Install the necessary libraries (if any).
3. Run the project using the Java Runtime Environment.

## Account Types
The Student Attendance Project supports two account types:

1. **Admin Account**: The Admin account has fixed credentials with the following information:
    - Username: admin
    - Password: admin

2. **Teacher Account**: The Teacher account is created by the Admin and can be accessed using the credentials provided by the Admin.

## Admin Interface
The Admin Interface allows administrators to perform the following actions:

- Create, edit, and display courses.
- Create, edit, and display teachers.
- Link teachers to their respective courses.

## Teacher Interface
The Teacher Interface allows teachers to perform the following actions:

- Create, add, edit, and remove students from courses.
- View student statistics within a course.
- Create, edit, and remove lectures for a course.
- View lecture statistics within a course.
- Mark attendance for students in lectures using name, ID, phone number, or CSV import.
- Use a webcam to scan ID cards for student identification and marking attendance.
- View individual student records and make attendance changes for other lectures.
- Display a table of students with an absence of 25% or more and export them to a CSV file.

## Notes
- When marking attendance, remember to press **"Done"** after completion.
- To view student or lecture statistics, double-click on the respective row.
- For data modification (e.g., student or lecture details), double-click on the field in tables and change the value.

## UML Diagrams
You can find the UML diagrams in the "resources" directory in a PDF file. The diagrams provide a visual representation of the project's architecture and design.

## Authors
The Student Attendance Project was made with ❤ by:
- Abdulrahman Abu Amouna
- AbdelRahim Ouda

## Acknowledgments
We would like to express our gratitude to [Eng. Osama Zayan] for their contributions, support, and inspiration for this project.

Feel free to contact us at [abdamapro22@gmail.com] for any questions or feedback.

Happy coding!
