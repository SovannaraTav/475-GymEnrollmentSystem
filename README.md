# 475-GymEnrollmentSystem
This repository contains the code in our final CSS 475 Database Systems project. The task involved building a command line application as a team to address a hypothetical business problem of our choice. Further information can be found down below.
<br></br>

### Business Problem
**Objective:** As a small gym, we plan to expand our gym facilities by hiring new gym instructors and introducing new gym classes for gym members to enroll in.
<br></br>
**Challenges:** We are currently using an Excel spreadsheet, but its limitations make it hard to keep track of gym instructors, gym members, gym classes, gym rooms, gym class types, and enrollment.
<br></br>
**Impact:** With the limitations that using an Excel spreadsheet presents, it causes a scalability issue for further expansion and we don't have a way of easily guaranteeing data integrity to ensure all relevant fields are updated.
<br></br>

### High Level View of Project Solution
**Create Update Delete (CRUD) Operations:**
1) Gym instructors for the classes.
2) Gym members in each class.
3) Gym members.
4) Gym instructors.
5) Gym classes.
6) Gym rooms.
7) Gym rooms for the classes.
8) Gym class types.
<br></br>

**Querying Functionalities:**
1) Checking if a gym member's membership is active or not.
2) Get gym instructors for a class.
3) Get gym members for a class.
4) Get a gym member's classes with or without a provided date.
5) Get a gym instructor's classes with or without a provided date.
6) Get gym classes by class type with or without a provided date.
7) Get all gym class types, gym rooms, gym members, and gym instructors.
<br></br>

### Development Tools and Environment
PostgreSQL database hosted on a local machine with starter data. In addition, the use of the PostgreSQL JDBC Driver and Java with the IntelliJ IDEA.
