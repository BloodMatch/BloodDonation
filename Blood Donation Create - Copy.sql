CREATE DATABASE blooddonation;
USE blooddonation;

CREATE TABLE AdminCenter (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  matricule varchar(20) NOT NULL UNIQUE, 
  UserId    int(10) NOT NULL, 
  CenterId  int(10) NOT NULL, 
  CONSTRAINT PK_admincenter 
    PRIMARY KEY (id)
);

CREATE TABLE AdminHospital (
  id         int(10) NOT NULL AUTO_INCREMENT, 
  matricule  varchar(15) NOT NULL UNIQUE, 
  service    varchar(30), 
  UserId     int(10) NOT NULL, 
  HospitalId int(10) NOT NULL, 
  CONSTRAINT PK_adminhostpital 
    PRIMARY KEY (id)
);

CREATE TABLE Analysis (
  id            int(10) NOT NULL AUTO_INCREMENT, 
  code          int(10) NOT NULL UNIQUE, 
  `date`        date NOT NULL, 
  comment       varchar(255), 
  results       varchar(1024), 
  AppointmentId int(10) NOT NULL, 
  CONSTRAINT PK_analysic 
    PRIMARY KEY (id)
);

CREATE TABLE Appointment (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  state        varchar(20) DEFAULT 'Proposed' NOT NULL, 
  donationType varchar(20) DEFAULT 'Blood' comment '
Donation type: 
Blood: The most common type of donation, during which approximately a pint of ''whole blood'' is given. This type of blood donation usually takes about an hour
Power Red: A Power Red donation collects the red cells but returns most of the plasma and platelets to the donor. These donors must meet specific eligibility requirements and have type A Neg, B Neg, or O blood.
Platelets: This type of donation collects the platelets and some plasma and returns the red cells and most of the plasma back to the donor. The donation takes approximately two to three hours.
AB Plasma: This type of donation collects AB plasma, then safely and comfortably returns the red cells, platelets and some saline back to the donor. It only takes a few minutes longer than donating blood. Only donors with type AB blood are eligible for AB Elite plasma donation.
 ', 
  time         TIMESTAMP, 
  satisfaction  int(2), 
  comment      varchar(255), 
  CenterId     int(10) NOT NULL, 
  DonorId      int(10) NOT NULL, 
  CONSTRAINT PK_donation 
    PRIMARY KEY (id)
);

CREATE TABLE Bag (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  type        varchar(20) DEFAULT 'Blood' NOT NULL UNIQUE, 
  `group`     varchar(3), 
  description varchar(255), 
  saftyStore  int(10) comment 'stock minimal', 
  PRIMARY KEY (id)
);

CREATE TABLE Center (
  id      int(10) NOT NULL AUTO_INCREMENT, 
  code    varchar(20) NOT NULL UNIQUE, 
  name    varchar(50) NOT NULL UNIQUE, 
  email   varchar(50) NOT NULL UNIQUE, 
  phone1  varchar(15) NOT NULL UNIQUE, 
  phone2  varchar(15), 
  city    varchar(20) NOT NULL, 
  address varchar(255) NOT NULL, 
  ZIPCode   int(10) NOT NULL, 
  CONSTRAINT PK_center 
    PRIMARY KEY (id)
);

CREATE TABLE Donor (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  cin       varchar(10) NOT NULL UNIQUE, 
  birthDay  date NOT NULL comment 'You must be at least 17 years old to create an online donor account. If you are 16 years old, you may donate with parental consent if allowed by state law, but you will not be able to create an online account.', 
  gender    varchar(5) NOT NULL, 
  `group`   varchar(3), 
  city      varchar(20) NOT NULL, 
  ZIPCode   int(10) NOT NULL, 
  image     varchar(50) DEFAULT 'default-avatar.jpg', 
  UserId    int(10) NOT NULL, 
  CONSTRAINT PK_donor 
    PRIMARY KEY (id)
) comment='Account Benefits: Create an account to easily schedule future appointments, manage existing appointments, see your blood type, view results of your mini-physical, and track donation history.';

CREATE TABLE History (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  operation varchar(64), 
  subject   varchar(64), 
  time      date, 
  UserId    int(10) NOT NULL, 
  CONSTRAINT PK_history 
    PRIMARY KEY (id)
);

CREATE TABLE Hospital (
  id      int(10) NOT NULL AUTO_INCREMENT, 
  code    varchar(20) NOT NULL UNIQUE, 
  name    varchar(50), 
  address varchar(255), 
  city    varchar(20), 
  CONSTRAINT PK_hospital 
    PRIMARY KEY (id)
);

CREATE TABLE Invoice (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  `date`    date NOT NULL, 
  amount    float, 
  RequestId int(10) NOT NULL, 
  CONSTRAINT PK_invoice 
    PRIMARY KEY (id)
);

CREATE TABLE Request (
  id                     int(10) NOT NULL AUTO_INCREMENT, 
  `date`                 date, 
  quantity               int(10), 
  Centercode             varchar(20) NOT NULL, 
  AdminHospitalMatricule varchar(15) NOT NULL, 
  BloodId                int(10) NOT NULL, 
  CenterId               int(10) NOT NULL, 
  AdminHospitalid        int(10), 
  CONSTRAINT PK_request 
    PRIMARY KEY (id)
);

CREATE TABLE Stock (
  id       int(10) NOT NULL, 
  quatnity int(10), 
  required bit(1), 
  CenterId int(10) NOT NULL, 
  BloodId  int(10) NOT NULL, 
  PRIMARY KEY (id, 
  CenterId, 
  BloodId)
);

CREATE TABLE `User` (
  id         int(10) NOT NULL AUTO_INCREMENT, 
  firstName varchar(30) NOT NULL, 
  lastName   varchar(30) NOT NULL, 
  email      varchar(50) NOT NULL UNIQUE, 
  passwd     varchar(255) NOT NULL, 
  phone      varchar(15) UNIQUE, 
  active     bit(1), 
  role       varchar(20), 
  CONSTRAINT Pk_user 
    PRIMARY KEY (id)
);

ALTER TABLE Donor ADD CONSTRAINT FKDonor300577 FOREIGN KEY (UserId) REFERENCES `User` (id);
ALTER TABLE AdminCenter ADD CONSTRAINT FKAdminCente322624 FOREIGN KEY (UserId) REFERENCES `User` (id);
ALTER TABLE AdminHospital ADD CONSTRAINT FKAdminHospi734389 FOREIGN KEY (UserId) REFERENCES `User` (id);
ALTER TABLE Appointment ADD CONSTRAINT FKAppointmen325683 FOREIGN KEY (DonorId) REFERENCES Donor (id);
ALTER TABLE Analysis ADD CONSTRAINT FKAnalysis233747 FOREIGN KEY (AppointmentId) REFERENCES Appointment (id);
ALTER TABLE AdminCenter ADD CONSTRAINT FKAdminCente241140 FOREIGN KEY (CenterId) REFERENCES Center (id);
ALTER TABLE Stock ADD CONSTRAINT FKStock265553 FOREIGN KEY (CenterId) REFERENCES Center (id);
ALTER TABLE Stock ADD CONSTRAINT FKStock854665 FOREIGN KEY (BloodId) REFERENCES Bag (id);
ALTER TABLE AdminHospital ADD CONSTRAINT FKAdminHospi321995 FOREIGN KEY (HospitalId) REFERENCES Hospital (id);
ALTER TABLE Request ADD CONSTRAINT FKRequest478049 FOREIGN KEY (AdminHospitalid) REFERENCES AdminHospital (id);
ALTER TABLE Request ADD CONSTRAINT FKRequest574980 FOREIGN KEY (CenterId) REFERENCES Center (id);
ALTER TABLE Invoice ADD CONSTRAINT FKInvoice168750 FOREIGN KEY (RequestId) REFERENCES Request (id);
ALTER TABLE History ADD CONSTRAINT FKHistory73898 FOREIGN KEY (UserId) REFERENCES `User` (id);
ALTER TABLE Request ADD CONSTRAINT FKRequest14132 FOREIGN KEY (BloodId) REFERENCES Bag (id);
ALTER TABLE Appointment ADD CONSTRAINT FKAppointmen921162 FOREIGN KEY (CenterId) REFERENCES Center (id);


/*-------------------------------------------*/
INSERT INTO USER (id, firstName, lastName, passwd, email, phone, active, role) 
VALUES
(2, 'Aniss', 'Nahim', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'donorAniss@gmail.com', '0615487812', FALSE, 'donor'),
(3, 'Ayoub', 'Benyas', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'donorAyoub@gmail.com','0626154878', FALSE, 'donor');

INSERT INTO CENTER (id, code, name, city, address, phone1, phone2, email, ZipCode) 
VALUES
(1, '151500', 'Centre Rabat', 'Rabat', 'National Blood Transfusion Center', '0505050202', '0505050203', 'RabatCenter@gmail.com', ''),
(3, 'Ayoub', 'Benyas', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'donorAyoub@gmail.com','0626154878', FALSE, 'donor');