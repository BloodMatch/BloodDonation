CREATE TABLE AdminCenter (
  matricule  varchar(20) NOT NULL, 
  Userid     int(10) NOT NULL, 
  Centercode varchar(20) NOT NULL, 
  CONSTRAINT PK_admincenter PRIMARY KEY (matricule)
);
    
CREATE TABLE AdminHospital (
  matricule    varchar(15) NOT NULL, 
  service      varchar(30), 
  Userid       int(10) NOT NULL, 
  Hospitalcode varchar(20) NOT NULL, 
  CONSTRAINT PK_adminhostpital PRIMARY KEY (matricule)
);

CREATE TABLE Analysis (
  code          int(10) NOT NULL AUTO_INCREMENT, 
  `date`        date NOT NULL, 
  comment       varchar(255), 
  results       varchar(1024), 
  Appointmentid int(10) NOT NULL, 
  CONSTRAINT PK_analysic PRIMARY KEY (code)
);
    
CREATE TABLE Appointment (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  state       varchar(20) DEFAULT 'proposed' NOT NULL, 
  `date`      date, 
  satsfaction int(2), 
  comment     varchar(255), 
  Donorcin    varchar(10) NOT NULL, 
  CONSTRAINT PK_donation PRIMARY KEY (id)
);
    
CREATE TABLE Bag (
  Centercode varchar(20) NOT NULL, 
  Bloodtype  varchar(3) NOT NULL, 
  quatnity   int(10), 
  required   bit(1), 
  PRIMARY KEY (Centercode, Bloodtype)
);

CREATE TABLE Blood (
  type        varchar(3) NOT NULL, 
  description varchar(255), 
  PRIMARY KEY (type)
);

CREATE TABLE Center (
  code     varchar(20) NOT NULL, 
  name     varchar(50) NOT NULL, 
  email    varchar(50) NOT NULL, 
  phone1   varchar(15) NOT NULL, 
  phone2   varchar(15), 
  address  varchar(255) NOT NULL, 
  commune  varchar(20) NOT NULL, 
  province varchar(20) NOT NULL, 
  region   varchar(20) NOT NULL, 
  CONSTRAINT PK_center PRIMARY KEY (code)
);

CREATE TABLE Donor (
  cin        varchar(10) NOT NULL, 
  birthDay   date NOT NULL, 
  sexe       char(2) NOT NULL, 
  Bloodtype  varchar(3) NOT NULL, 
  profession varchar(20), 
  ville      varchar(255), 
  image      varchar(50) DEFAULT 'img/default-avatar.jpg', 
  Userid     int(10) NOT NULL, 
  CONSTRAINT PK_donor PRIMARY KEY (cin)
);
    
CREATE TABLE History (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  operation varchar(64), 
  subject   varchar(64), 
  time      date, 
  Userid    int(10) NOT NULL, 
  CONSTRAINT PK_history PRIMARY KEY (id)
);
    
CREATE TABLE Hospital (
  code    varchar(20) NOT NULL, 
  name    varchar(50), 
  address varchar(255), 
  ville   varchar(20), 
  CONSTRAINT PK_hospital PRIMARY KEY (code)
);

CREATE TABLE Invoice (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  `date`    date NOT NULL, 
  amount    float, 
  Requestid int(10) NOT NULL, 
  CONSTRAINT PK_invoice PRIMARY KEY (id)
);
    
CREATE TABLE Request (
  id                     int(10) NOT NULL AUTO_INCREMENT, 
  `date`                 date, 
  Bloodtype              varchar(3) NOT NULL, 
  quantity               int(10), 
  AdminHospitalmatricule varchar(15) NOT NULL, 
  Centercode             varchar(20) NOT NULL, 
  CONSTRAINT PK_request PRIMARY KEY (id)
);

CREATE TABLE `User` (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  userName  varchar(30), 
  passwd    varchar(255), 
  firstName varchar(30), 
  lastName  varchar(30), 
  email     varchar(50), 
  phone     varchar(15), 
  active    bit(1), 
  role      varchar(20), 
  CONSTRAINT Pk_user PRIMARY KEY (id)
);

ALTER TABLE Donor ADD CONSTRAINT FKDonor299585 FOREIGN KEY (Userid) REFERENCES `User` (id);
ALTER TABLE AdminCenter ADD CONSTRAINT FKAdminCente321632 FOREIGN KEY (Userid) REFERENCES `User` (id);
ALTER TABLE AdminHospital ADD CONSTRAINT FKAdminHospi735381 FOREIGN KEY (Userid) REFERENCES `User` (id);
ALTER TABLE Appointment ADD CONSTRAINT FKAppointmen80230 FOREIGN KEY (Donorcin) REFERENCES Donor (cin);
ALTER TABLE Analysis ADD CONSTRAINT FKAnalysis232755 FOREIGN KEY (Appointmentid) REFERENCES Appointment (id);
ALTER TABLE AdminCenter ADD CONSTRAINT FKAdminCente2012 FOREIGN KEY (Centercode) REFERENCES Center (code);
ALTER TABLE Bag ADD CONSTRAINT FKBag875034 FOREIGN KEY (Centercode) REFERENCES Center (code);
ALTER TABLE Bag ADD CONSTRAINT FKBag576996 FOREIGN KEY (Bloodtype) REFERENCES Blood (type);
ALTER TABLE AdminHospital ADD CONSTRAINT FKAdminHospi115875 FOREIGN KEY (Hospitalcode) REFERENCES Hospital (code);
ALTER TABLE Request ADD CONSTRAINT FKRequest246331 FOREIGN KEY (AdminHospitalmatricule) REFERENCES AdminHospital (matricule);
ALTER TABLE Request ADD CONSTRAINT FKRequest814108 FOREIGN KEY (Centercode) REFERENCES Center (code);
ALTER TABLE Invoice ADD CONSTRAINT FKInvoice169742 FOREIGN KEY (Requestid) REFERENCES Request (id);
ALTER TABLE History ADD CONSTRAINT FKHistory74890 FOREIGN KEY (Userid) REFERENCES `User` (id);
ALTER TABLE Donor ADD CONSTRAINT FKDonor427972 FOREIGN KEY (Bloodtype) REFERENCES Blood (type);
ALTER TABLE Request ADD CONSTRAINT FKRequest705450 FOREIGN KEY (Bloodtype) REFERENCES Blood (type);

COMMIT;*