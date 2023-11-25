/* Save and run the entire script in one file */
/* Student information database tables 
   Run this from the root */

drop database javabook;
create database javabook;
create user 'scott'@'localhost' identified by 'tiger';
grant select, insert, update, delete, create, create view, drop,
execute, references on javabook.* to 'scott'@'localhost';

use javabook;

drop table if exists Student;
drop table if exists Course;
drop table if exists College;
drop table if exists Subject;
drop table if exists Department;
drop table if exists Enrollment;
drop table if exists TaughtBy;
drop table if exists Faculty;

create table Department (
                            deptId char(4) not null,
                            name varchar(25) unique, /* works in MYSQL */
                            chairId varchar(9),
                            collegeId varchar(4),
                            constraint pkDepartment primary key (deptId));

create table Enrollment (
                            ssn char(9) not null,
                            courseId char(5) not null,
                            dateRegistered date,
                            grade char(1),
                            constraint pkEnrollment primary key (ssn, courseId));

create table TaughtBy (
                          courseId char(5),
                          ssn char(9));

create table Faculty(
                        ssn char(9) not null,
                        firstName varchar(25),
                        mi char(1),
                        lastName varchar(25),
                        phone char(10),
                        email varchar(50),
                        office varchar(15),
                        startTime date,
                        rank varchar(20),
                        salary double,
                        deptId char(4),
                        constraint pkFaculty primary key (ssn));

create table Subject (
                         subjectId char(4) not null,
                         name varchar(25),
                         startTime date,
                         deptId char(4),
                         constraint pkSubject primary key (subjectId));

create table Student (
                         ssn char(9) not null,
                         firstName varchar(25),
                         mi char(1),
                         lastName varchar(25),
                         phone char(11),
                         birthDate date,
                         street varchar(100),
                         zipCode char(5),
                         deptId char(4),
                         constraint pkStudent primary key (ssn),
                         constraint fkDeptId foreign key (deptId)
                             references Department(deptId));

create table Course(
                       courseId char(5),
                       subjectId char(4) not null,
                       courseNumber integer,
                       title varchar(50) not null,
                       numOfCredits integer,
                       constraint pkCourse primary key (courseId),
                       constraint fkSubjectId foreign key (subjectId)
                           references Subject(subjectId));

create table College(
                        collegeId char(4) not null,
                        name varchar(25) not null,
                        since date,
                        deanId char(9),
                        constraint pkCollege primary key (collegeId),
                        constraint fkDeanId foreign key (deanId)
                            references Faculty(ssn));

insert into Department values (
                                  'CS', 'Computer Science', '111221115', 'SC');
insert into Department values (
                                  'MATH', 'Mathematics', '111221116', 'SC');
insert into Department values (
                                  'CHEM', 'Chemistry', '111225555', 'SC');
insert into Department values (
                                  'EDUC', 'Education', '333114444', 'EDUC');
insert into Department values (
                                  'ACCT', 'Accounting', '333115555', 'BUSS');
insert into Department values (
                                  'BIOL', 'Biology', '111225555', 'SC');


insert into Enrollment values (
                                  '444111110', '11111', now(), 'A');
/* In MS Access, replace now() by date() */
insert into Enrollment values (
                                  '444111110', '11112', now(), 'B');
insert into Enrollment values (
                                  '444111110', '11113', now(), 'C');
insert into Enrollment values (
                                  '444111111', '11111', now(), 'D');
insert into Enrollment values (
                                  '444111111', '11112', now(), 'F');
insert into Enrollment values (
                                  '444111111', '11113', now(), 'A');
insert into Enrollment values (
                                  '444111112', '11111', now(), null);
insert into Enrollment values (
                                  '444111112', '11112', now(), null);
insert into Enrollment values (
                                  '444111112', '11114', now(), 'B');
insert into Enrollment values (
                                  '444111112', '11115', now(), 'C');
insert into Enrollment values (
                                  '444111112', '11116', now(), null);
insert into Enrollment values (
                                  '444111113', '11111', now(), null);
insert into Enrollment values (
                                  '444111113', '11113', now(), null);
insert into Enrollment values (
                                  '444111114', '11115', now(), null);
insert into Enrollment values (
                                  '444111115', '11115', now(), null);
insert into Enrollment values (
                                  '444111115', '11116', now(), null);
insert into Enrollment values (
                                  '444111116', '11111', now(), null);
insert into Enrollment values (
                                  '444111117', '11111', now(), null);
insert into Enrollment values (
                                  '444111118', '11111', now(), null);
insert into Enrollment values (
                                  '444111118', '11112', now(), null);
insert into Enrollment values (
                                  '444111118', '11113', now(), null);

insert into TaughtBy values (
                                '11111', '111221111');
insert into TaughtBy values (
                                '11112', '111221111');
insert into TaughtBy values (
                                '11113', '111221111');
insert into TaughtBy values (
                                '11114', '111221115');
insert into TaughtBy values (
                                '11115', '111221110');
insert into TaughtBy values (
                                '11116', '111221115');
insert into TaughtBy values (
                                '11117', '111221116');
insert into TaughtBy values (
                                '11118', '111221112');

insert into Subject values (
                               'CSCI', 'Computer Science', '1980-08-01', 'CS');
insert into Subject values (
                               'ITEC', 'Information Technology', '2002-01-01', 'CS');
insert into Subject values (
                               'MATH', 'Mathematical Science', '1935-08-01', 'MATH');
insert into Subject values (
                               'STAT', 'Statistics', '1980-08-01', 'MATH');
insert into Subject values (
                               'EDUC', 'Education', '1980-08-01', 'EDUC');

insert into Faculty values (
                               111221110, 'Patty', 'R', 'Smith', '9129215555',
                               'patty@yahoo.com', 'SC129', '1976-10-11',
                               'Full Professor', 60000, 'MATH');
insert into Faculty values (
                               111221111, 'George', 'P', 'Franklin', '9129212525',
                               'george@yahoo.com', 'SC130', '1986-10-12',
                               'Associate Professor', 65000, 'CS');
insert into Faculty values (
                               111221112, 'Jean', 'D', 'Yao', '9129215556',
                               'jean@yahoo.com', 'SC131', '1976-08-13',
                               'Full Professor', 65000, 'MATH');
insert into Faculty values (
                               '111221113', 'Frank', 'E', 'Goldman', '9129215557',
                               'frank@yahoo.com', 'SC132', '1996-01-14',
                               'Assistant Professor', 60000, 'ACCT');
insert into Faculty values (
                               '111221114', 'Steve', 'T', 'Templeton', '9129215558',
                               'steve@yahoo.com', 'UH132', '1998-01-01',
                               'Assistant Professor', 60000, 'ACCT');
insert into Faculty values (
                               '111221115', 'Alex', 'T', 'Bedat', '9129215559',
                               'alex@yahoo.com', 'SC133', '2000-01-01',
                               'Full Professor', 95000, 'CS');
insert into Faculty values (
                               '111221116', 'Judy', 'T', 'Woo', '9129215560',
                               'judy@yahoo.com', 'SC133', '2000-01-01',
                               'Full Professor', 55000, 'MATH');
insert into Faculty values (
                               '111221117', 'Joe', 'R', 'Chang', '9129215561',
                               'joe@yahoo.com', 'ED133', '2000-01-01',
                               'Full Professor', 55000, 'EDUC');
insert into Faculty values (
                               '111221118', 'Francis', 'R', 'Chin', '9129215562',
                               'joe@yahoo.com', 'ED133', '1989-01-01',
                               'Full Professor', 75000, 'BIOL');
insert into Faculty values (
                               '111221119', 'Ray', 'R', 'Smith', '9129215563',
                               'ray@yahoo.com', 'SC133', '1994-01-01',
                               'Full Professor', 85000, 'CHEM');

insert into Student values (
                               '444111110', 'Jacob', 'R', 'Smith', null,
                               '1985-04-09', '99 Kingston Street', '31435', 'BIOL');
insert into Student values (
                               '444111111', 'John', 'K', 'Stevenson', '9129219434',
                               null, '100 Main Street', '31411', 'BIOL');
insert into Student values (
                               '444111112', 'George', 'R', 'Heintz', '9129213454',
                               '1974-10-10', '1200 Abercorn Street', '31419', 'CS');
insert into Student values (
                               '444111113', 'Frank', 'E', 'Jones', '9125919434',
                               '1970-09-09', '100 Main Street', '31411', 'BIOL');
insert into Student values (
                               '444111114', 'Jean', 'K', 'Smith', '9129219434',
                               '1970-02-09', '100 Main Street', '31411', 'CHEM');
insert into Student values (
                               '444111115', 'Josh', 'R', 'Woo', '7075989434',
                               '1970-02-09', '555 Franklin Street', '31411', 'CHEM');
insert into Student values (
                               '444111116', 'Josh', 'R', 'Smith', '9129219434',
                               '1973-02-09', '100 Main Street', '31411', 'BIOL');
insert into Student values (
                               '444111117', 'Joy', 'P', 'Kennedy', '9129229434',
                               '1974-03-19', '103 Bay Street', '31412', 'CS');
insert into Student values (
                               '444111118', 'Toni', 'R', 'Peterson', '9129229434',
                               '1964-04-29', '103 Bay Street', '31412', 'MATH');
insert into Student values (
                               '444111119', 'Patrick', 'R', 'Stoneman', null,
                               '1969-04-29', '101 Washington Street', '31435', 'MATH');
insert into Student values (
                               '444111120', 'Rick', 'R', 'Carter', null,
                               '1986-04-09', '19 West Ford Street', '31411', 'BIOL');

insert into Course values (
                              '11111', 'CSCI', '1301', 'Intro to Java I', 4);
insert into Course values (
                              '11112', 'CSCI', '1302', 'Intro to Java II', 3);
insert into Course values (
                              '11113', 'CSCI', '4720', 'Database Systems', 3);
insert into Course values (
                              '11114', 'CSCI', '4750', 'Rapid Java Application', 3);
insert into Course values (
                              '11115', 'MATH', '2750', 'Calculus I', 5);
insert into Course values (
                              '11116', 'MATH', '3750', 'Calculus II', 5);
insert into Course values (
                              '11117', 'EDUC', '1111', 'Reading', 3);
insert into Course values (
                              '11118', 'ITEC', '1344', 'Database Administration', 3);

insert into College values (
                               'SC', 'Science', '1994-01-01','111221110');
insert into College values (
                               'NURS', 'Nursing', '1994-01-01',null);
insert into College values (
                               'EDUC', 'Education', '1994-01-01', '111221117');
insert into College values (
                               'BUSS', 'Business', '1994-01-01', '111221114');

/* For exercise 34.7 in intro6e  */
drop table if exists csci4990;
drop table if exists csci1301;
drop table if exists csci1302;

create table csci4990 (
                          ssn char(11),
                          name varchar(25),
                          score float);

insert into csci4990 values (
                                '111-22-3333', 'John F Smith', 85.4);

create table csci1301 (
                          ssn char(11),
                          name varchar(25),
                          score float);

insert into csci1301 values (
                                '111-22-3333', 'John F Smith', 75.4);

create table csci1302 (
                          ssn char(11),
                          name varchar(25),
                          score float);

insert into csci1302 values (
                                '111-22-3333', 'John F Smith', 55.4);

/* For exercise 34.8 in intro6e */
drop table if exists Account;
drop table if exists Address;

create table Account (
                         username varchar(20),
                         password varchar(25),
                         name varchar(20));

insert into Account values (
                               'javaman', 'namavaj', 'John F. Smith');

/* For the Database Programming Chapter in intro7e */
create table Staff (
                       id char(9) not null,
                       lastName varchar(15),
                       firstName varchar(15),
                       mi char(1),
                       address varchar(20),
                       city varchar(20),
                       state char(2),
                       telephone char(10),
                       email varchar(40),
                       primary key (id)
);

create table Quiz(
                     questionId int,
                     question varchar(4000),
                     choicea varchar(1000),
                     choiceb varchar(1000),
                     choicec varchar(1000),
                     choiced varchar(1000),
                     answer varchar(5));

/* For the example in the Web chapters in intro7e */
create table Address (
                         firstname varchar(25),
                         mi char(1),
                         lastname varchar(25),
                         street varchar(40),
                         city varchar(20),
                         state varchar(2),
                         zip varchar(5),
                         telephone varchar(10),
                         email varchar(30),
                         primary key (firstname, mi, lastname)
);

/* For the example in the advanced database chatper in intro7e. Use MySQL version 5*/
drop table if exists Person;
drop table if exists StateCapital;

create table Person (
                        firstName varchar(20),
                        mi char(1),
                        lastName varchar(20)
);

/* For the example in the advanced database chatper. Use MySQL version 5*/
create table StateCapital (
                              state varchar(40),
                              capital varchar(40)
);

insert into StateCapital values (
                                    'Georgia', 'Atlanta');
insert into StateCapital values (
                                    'Texas', 'Austin');
insert into StateCapital values (
                                    'Indiana', 'Indianapolis');
insert into StateCapital values (
                                    'Illlinois', 'Springfield');
insert into StateCapital values (
                                    'California', 'Sacramento');
/*
insert into StateCapital values (
  'Alabama', 'Montgomery');
insert into StateCapital values (
  'Alaska', 'Juneau');
insert into StateCapital values (
  'Arizona', 'Phoenix');
*/

drop table Country;

create table Country(name varchar(30), flag blob,
                     description varchar(255));

create table Student1 (
                          username varchar(50) not null,
                          password varchar(50) not null,
                          fullname varchar(200) not null,
                          constraint pkStudent primary key (username)
);

insert into Student1 values ('abc1', 'abc', 'John  F Smith');
insert into Student1 values ('abc2', 'abc', 'Peter R  Smith');
insert into Student1 values ('abc3', 'abc', 'Jane    Paul');
insert into Student1 values ('abc4', 'abc', 'George   King');

create table Student2 (
                          username varchar(50) not null,
                          password varchar(50) not null,
                          firstname varchar(100),
                          lastname varchar(100),
                          constraint pkStudent primary key (username)
);


/* For the exercise in the advanced database chatper. Use MySQL version 5*/
create table Temp(num1 double, num2 double, num3 double);

/* For the callable statement example. Use MySQL version 5 */
drop function if exists studentFound;

delimiter //

create function studentFound(first VARCHAR(20), last VARCHAR(20))
    returns int
begin
    declare result int;

    select count(*) into result
  from Student
  where Student.firstName = first and
    Student.lastName = last;

    return result;
    end;
    //

delimiter ;  /* Please note that there is a space between delimiter and ; */


/* For the example in the RMI and Web service */
    drop table if exists Scores;
    create table Scores (name varchar(20),
  score double, permission double);

    insert into Scores values ('John', 90.5, 1);
    insert into Scores values ('Michael', 100, 1);
    insert into Scores values ('Michelle', 100, 0);

    commit;