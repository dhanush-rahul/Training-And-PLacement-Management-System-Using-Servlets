# Training-And-PLacement-Management-System-Using-Servlets

# SQL Queries

create database placement;
use placement;

create table login(AdminUsername varchar(20) primary key,AdminPassword varchar(20),
Stream varchar(20),
Role varchar(10));


create table StudentLogin(StudentUsername varchar(20) primary key,
StudentPassword varchar(20),StudentID varchar(10) unique,stream varchar(20),foreign key(StudentID)
references StudentDetails(StudentID));



create table StudentDetails(StudentUsername varchar(20),StudentID varchar(20) primary key,StudentPassword varchar(20),
Stream varchar(20),AvgGPA float,CurrentStatus varchar(20));


create table CompanyDetails(CompanyName varchar(20) primary key,Stream varchar(20),Eligibility varchar(20),Role varchar(20),Pay int, Contract int, TypeOfJob varchar(20),ScheduleDate date,State varchar(20),CurrentStatus varchar(20));

create table PlacedStudents(StudentUsername varchar(20),StudentID varchar(20),Stream varchar(5),
GPA float,CompanyName varchar(20),Role varchar(20));


create table StudentComplaints(StudentID varchar(20),Stream varchar(5),Complaint varchar(50));

create table Discussions(Faculty varchar(20),Activity varchar(200));
