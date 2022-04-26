-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- ------------------------------------------------------

--
-- Table structure for table groupdef
--
-- DROP TABLE IF EXISTS groupdef;
CREATE TABLE groupdef (
  id SERIAL PRIMARY KEY,
  name varchar(255) NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT groupname_UNIQUE UNIQUE (name)
);

--
-- Table structure for table person
--
-- DROP TABLE IF EXISTS person;
CREATE TABLE person (
  id SERIAL PRIMARY KEY,
  prename varchar(255) NOT NULL,
  surname varchar(255) DEFAULT NULL,
  birth timestamp DEFAULT NULL,
  gender smallint DEFAULT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL
);


--
-- Table structure for table `contact`
--

-- DROP TABLE IF EXISTS contact;
CREATE TABLE contact (
  id SERIAL PRIMARY KEY,
  type varchar(255) NOT NULL,
  value varchar(255) DEFAULT NULL,
  person_id int NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT contact_ibfk_1 FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

--
-- Table structure for table clubevent
--

-- DROP TABLE IF EXISTS clubevent;
CREATE TABLE clubevent (
  id varchar(250) NOT NULL,
  location varchar(255) DEFAULT NULL,
  ICALUID varchar(150) DEFAULT NULL,
  organizerDisplayName varchar(150) DEFAULT NULL,
  caption varchar(150) DEFAULT NULL,
  description varchar(500) DEFAULT NULL,
  start timestamp DEFAULT NULL,
  ende timestamp DEFAULT NULL,
  allDay smallint DEFAULT NULL,
  deleted smallint NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

--
-- Table structure for table pflichten
--
-- DROP TABLE IF EXISTS pflichten;
CREATE TABLE pflichten (
  id SERIAL PRIMARY KEY,
  name varchar(45) NOT NULL,
  fixed smallint DEFAULT NULL,
  ordered int NOT NULL,
  comment varchar(500) DEFAULT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT name_UNIQUE UNIQUE (name)
);

--
-- Table structure for table adress
--
-- DROP TABLE IF EXISTS adress;
CREATE TABLE adress (
  id SERIAL PRIMARY KEY,
  adress1 varchar(255) DEFAULT NULL,
  adress2 varchar(255) DEFAULT NULL,
  plz varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  person_id int NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT adress_ibfk_1 FOREIGN KEY (person_id) REFERENCES person (id)
);

--
-- Table structure for table altersgruppe
--
-- DROP TABLE IF EXISTS altersgruppe;
CREATE TABLE altersgruppe (
  id SERIAL PRIMARY KEY,
  event_id varchar(250) NOT NULL,
  pflicht_id int DEFAULT NULL,
  bezeichnung varchar(100) NOT NULL,
  start int DEFAULT NULL,
  ende varchar(45) DEFAULT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT fk_altersgruppe_event FOREIGN KEY (event_id) REFERENCES clubevent (id),
  CONSTRAINT fk_altersgruppe_pflicht FOREIGN KEY (pflicht_id) REFERENCES pflichten (id)
);

--
-- Table structure for table attendance
--
-- DROP TABLE IF EXISTS attendance;
CREATE TABLE attendance (
  id SERIAL PRIMARY KEY,
  on_date timestamp DEFAULT NULL,
  person_id int NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT UNIQUE_person_id_on_date UNIQUE (person_id,on_date),
  CONSTRAINT attendance_ibfk_1 FOREIGN KEY (person_id) REFERENCES person (id)
);

--
-- Table structure for table clubevent_addon
--

-- DROP TABLE IF EXISTS clubevent_addon;
CREATE TABLE clubevent_addon (
  id varchar(250) NOT NULL,
  competition_type varchar(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_event_addon_id FOREIGN KEY (id) REFERENCES clubevent (id)
);

--
-- Table structure for table clubevent_has_person
--

-- DROP TABLE IF EXISTS clubevent_has_person;
CREATE TABLE clubevent_has_person (
  clubevent_id varchar(250) NOT NULL,
  person_id int NOT NULL,
  comment varchar(250) NOT NULL,
  PRIMARY KEY (clubevent_id,person_id),
  CONSTRAINT fk_clubevent_has_person_clubevent1 FOREIGN KEY (clubevent_id) REFERENCES clubevent (id),
  CONSTRAINT fk_clubevent_has_person_person1 FOREIGN KEY (person_id) REFERENCES person (id)
);

--
-- Table structure for table deleted_entries
--

-- DROP TABLE IF EXISTS deleted_entries;
CREATE TABLE deleted_entries (
  id SERIAL PRIMARY KEY,
  tablename varchar(25) NOT NULL,
  entryId int NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL
);

--
-- Table structure for table event_has_altersgruppe
--

-- DROP TABLE IF EXISTS event_has_altersgruppe;
CREATE TABLE event_has_altersgruppe (
  id SERIAL PRIMARY KEY,
  event_id varchar(250) NOT NULL,
  altersgruppe_id int NOT NULL,
  CONSTRAINT fk_event_has_altersgruppe_altersgruppe FOREIGN KEY (altersgruppe_id) REFERENCES altersgruppe (id),
  CONSTRAINT fk_event_has_altersgruppe_event FOREIGN KEY (event_id) REFERENCES clubevent (id)
);

--
-- Table structure for table notes
--

-- DROP TABLE IF EXISTS notes;
CREATE TABLE notes (
  id SERIAL PRIMARY KEY,
  person_id int NOT NULL,
  notekey varchar(25) DEFAULT NULL,
  notetext varchar(2000) DEFAULT NULL,
  CONSTRAINT fk_notes_person FOREIGN KEY (person_id) REFERENCES person (id)
);

--
-- Table structure for table persongroup
--

-- DROP TABLE IF EXISTS persongroup;
CREATE TABLE persongroup (
  id SERIAL PRIMARY KEY,
  person_id int NOT NULL,
  group_id int NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT unique_person_group UNIQUE (person_id,group_id),
  CONSTRAINT persongroup_ibfk_1 FOREIGN KEY (person_id) REFERENCES person (id),
  CONSTRAINT persongroup_ibfk_2 FOREIGN KEY (group_id) REFERENCES groupdef (id)
);

--
-- Table structure for table relative
--

-- DROP TABLE IF EXISTS relative;
CREATE TABLE relative (
  id SERIAL PRIMARY KEY,
  person1 int NOT NULL,
  person2 int NOT NULL,
  TO_PERSON1_RELATION varchar(255) DEFAULT NULL,
  TO_PERSON2_RELATION varchar(255) DEFAULT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT relative_ibfk_1 FOREIGN KEY (person1) REFERENCES person (id),
  CONSTRAINT relative_ibfk_2 FOREIGN KEY (person2) REFERENCES person (id)
);

--
-- Table structure for table startpaesse
--

-- DROP TABLE IF EXISTS startpaesse;
CREATE TABLE startpaesse (
  id SERIAL PRIMARY KEY,
  person_id int NOT NULL,
  startpass_nr varchar(25) NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT startpass_nr UNIQUE (startpass_nr),
  CONSTRAINT startpaesse_ibfk_1 FOREIGN KEY (person_id) REFERENCES person (id)
);

--
-- Table structure for table startpass_startrechte
--

-- DROP TABLE IF EXISTS startpass_startrechte;
CREATE TABLE startpass_startrechte (
  id SERIAL PRIMARY KEY,
  startpass_id int NOT NULL,
  verein_name varchar(100) NOT NULL,
  fachgebiet varchar(25) NOT NULL,
  startrecht_beginn timestamp NOT NULL,
  startrecht_ende timestamp NOT NULL,
  changed timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  created timestamp DEFAULT CURRENT_TIMESTAMP,
  deleted timestamp DEFAULT NULL,
  CONSTRAINT startpass_startrechte_ibfk_1 FOREIGN KEY (startpass_id) REFERENCES startpaesse (id)
);

--
-- Table structure for table version
--
-- DROP TABLE IF EXISTS version;
CREATE TABLE version (
  id SERIAL PRIMARY KEY,
  version int NOT NULL,
  deleted timestamp DEFAULT NULL
);

-- Dump completed
