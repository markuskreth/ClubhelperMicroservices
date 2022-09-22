--
-- Dumping data for table groupdef
--

INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (1,'Aktive','2016-12-17 13:59:01','2016-12-17 14:59:01',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (2,'Angehörige','2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (3,'Übungsleiter','2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (6,'Ehemalige','2016-12-18 19:55:57','2016-12-18 20:55:57',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (7,'Wettkämpfer','2016-12-18 19:56:09','2016-12-18 20:56:09',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (8,'ADMIN','2016-12-30 21:34:13','2016-12-30 22:34:13',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (9,'Kampfrichter','2019-01-12 12:44:00','2019-01-12 13:44:00',NULL);
INSERT INTO groupdef(id, name, changed, created, deleted) VALUES (10,'Warteliste','2020-01-28 18:52:58','2020-01-28 19:52:58',NULL);

--
-- Dumping data for table person
--
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (1,'Samuel','Dennis','1983-09-11',1,'2020-01-18 15:14:19','2015-08-31 22:26:03',NULL,'markus','xxxxx');
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (2,'Paul','Wright','1964-02-14',2,'2019-01-27 14:18:15','2015-08-31 22:26:03','2019-01-27 22:05:11',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (3,'Edith','Armstrong','1988-02-26',2,'2020-01-18 15:13:54','2015-08-31 22:26:04',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (4,'George','Reid','1993-04-19',2,'2015-08-31 20:26:04','2015-08-31 22:26:04','2017-01-02 13:16:16',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (5,'Susie','Hansen','1975-05-07',2,'2015-08-31 20:26:04','2015-08-31 22:26:04','2017-01-02 13:16:19',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (6,'Olga','Reid','1958-01-09',NULL,'2015-08-31 20:26:04','2015-08-31 22:26:04','2019-01-27 22:05:19',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (7,'Danny','Malone','1955-02-15',2,'2015-08-31 20:26:04','2015-08-31 22:26:04','2019-01-27 22:05:16',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (8,'Isabelle','Schultz','1996-02-01',2,'2019-01-28 13:55:17','2015-08-31 22:26:04',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (9,'Rosetta','Romero','1996-11-27',2,'2015-08-31 20:26:04','2015-08-31 22:26:04',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (10,'Warren','McBride','1972-08-21',NULL,'2019-08-08 15:41:23','2015-08-31 22:26:04',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (11,'Leo','Swanson','1999-03-19',NULL,'2015-08-31 20:26:04','2015-08-31 22:26:04','2018-01-03 20:27:47',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (12,'Olga','Reid','1958-11-20',NULL,'2019-08-08 15:41:36','2015-08-31 22:26:04',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (13,'Hilda','White','1996-08-17',NULL,'2015-08-31 20:26:04','2015-08-31 22:26:04','2019-01-27 22:05:23',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (14,'Dustin','Bradley','1968-04-28',NULL,'2015-08-31 20:26:04','2015-08-31 22:26:04','2017-01-02 13:15:45',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (15,'Eleanor','Weber','1998-07-17',NULL,'2015-08-31 20:26:04','2015-08-31 22:26:04','2019-01-27 22:05:26',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (16,'Sue','Goodman','1992-07-23',NULL,'2015-08-31 20:26:04','2015-08-31 22:26:04','2019-01-27 22:05:30',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (17,'Rosetta','Lamb','1971-09-15',2,'2019-01-31 13:37:24','2015-08-31 22:26:04',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (18,'Nelle','Tran','1963-01-20',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2019-01-27 22:05:33',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (19,'Martha','Burns','1973-02-09',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2017-01-02 13:17:03',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (20,'Lois','Copeland','1985-09-05',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2017-01-02 13:17:32',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (21,'Herbert','Parsons','1992-03-26',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (22,'Warren','Zimmerman','1983-08-18',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2018-01-03 20:25:41',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (23,'Lida','Chavez','1963-11-06',NULL,'2016-05-30 21:15:00','2015-08-31 22:26:05','2019-01-27 22:05:37',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (24,'Bruce','Elliott','1994-07-17',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2017-01-02 13:18:03',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (25,'Violet','Holmes','1971-05-09',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2019-01-27 22:05:39',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (26,'Edith','Armstrong',NULL,NULL,'1988-08-31 20:26:05','2015-08-31 22:26:05','2019-01-27 22:05:44',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (27,'Julian','Johnson','1973-06-14',NULL,'2015-08-31 20:26:05','2015-08-31 22:26:05','2017-01-02 13:18:00',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (28,'Bobby','Gomez',NULL,NULL,'1997-08-31 20:26:05','2015-08-31 22:26:05','2018-01-03 20:26:05',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (29,'Eva','Nash','1979-04-28',2,'2015-08-31 20:26:05','2015-08-31 22:26:05','2017-01-02 13:15:55',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (30,'Ricky','Matthews',NULL,NULL,'1966-08-31 20:26:05','2015-08-31 22:26:05','2019-01-27 22:05:47',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (31,'Jean','Ingram',NULL,NULL,'1965-08-31 20:26:05','2015-08-31 22:26:05','2019-01-27 22:05:49',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (32,'Isabelle','Schultz','1996-08-11',2,'2015-08-31 20:26:06','2015-08-31 22:26:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (33,'Henrietta','Maldonado',NULL,NULL,'1998-08-31 20:26:06','2015-08-31 22:26:06','2019-01-27 22:06:17',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (34,'Isabel','Dennis',NULL,NULL,'2001-08-31 20:26:06','2015-08-31 22:26:06','2017-01-02 13:16:31',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (35,'Clayton','Gomez','1998-10-04',NULL,'2015-08-31 20:26:06','2015-08-31 22:26:06','2019-01-27 22:06:20',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (36,'Estelle','Davis',NULL,NULL,'2000-08-31 20:26:06','2015-08-31 22:26:06','2017-01-09 15:46:15',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (37,'Adeline','Fitzgerald',NULL,NULL,'1989-08-31 20:26:06','2015-08-31 22:26:06','2017-01-09 15:45:54',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (38,'Dora','Barnes','1958-03-29',NULL,'2019-01-28 14:02:40','2015-08-31 22:26:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (39,'Eric','Hayes',NULL,NULL,'1981-08-31 20:26:06','2015-08-31 22:26:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (40,'Dean','Schmidt','1974-01-31',NULL,'2015-08-31 20:26:06','2015-08-31 22:26:06','2017-01-02 13:15:58',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (41,'Lida','Chavez','1963-08-01',1,'2015-08-31 20:26:06','2015-08-31 22:26:06','2019-01-27 22:06:34',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (42,'Keith','Mills','1986-01-04',NULL,'2015-08-31 20:26:06','2015-08-31 22:26:06','2017-01-02 13:16:43',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (43,'Leo','Swanson','1999-11-30',NULL,'2015-08-31 20:26:06','2015-08-31 22:26:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (44,'Martha','Burns','1973-11-12',NULL,'2015-08-31 20:26:06','2015-08-31 22:26:06','2017-01-02 13:16:00',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (45,'Keith','Mills','1986-09-13',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07','2017-01-02 13:16:02',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (46,'Fanny','Collins','1967-06-01',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (47,'Angel','Gordon','1960-11-02',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (48,'Eva','Nash','1979-06-25',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07','2019-01-27 22:06:49',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (49,'Catherine','Hicks','1956-08-22',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07','2019-01-27 22:06:52',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (50,'Martha','Burns','1973-08-28',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07','2019-01-27 22:17:54',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (51,'Matthew','Padilla','1991-09-13',2,'2017-10-29 08:17:31','2015-08-31 22:26:07',NULL,'bergmann','xxxxx');
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (52,'Lula','Hansen',NULL,2,'1980-01-28 13:56:28','2015-08-31 22:26:07',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (53,'Catherine','Hicks',NULL,NULL,'1956-08-31 20:26:07','2015-08-31 22:26:07','2017-01-02 13:15:52',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (54,'Isaiah','Schmidt','1995-10-22',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07','2017-01-07 19:58:05',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (55,'George','Reid',NULL,NULL,'1993-08-31 20:26:07','2015-08-31 22:26:07','2019-01-27 22:06:57',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (56,'Jennie','Shaw','1972-01-01',NULL,'2015-08-31 20:26:07','2015-08-31 22:26:07',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (57,'Rodney','Foster',NULL,NULL,'1964-08-31 20:26:07','2015-08-31 22:26:07',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (58,'Leo','Swanson',NULL,NULL,'1999-08-31 20:26:07','2015-08-31 22:26:07','2019-01-27 22:18:02',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (59,'Calvin','Austin','1978-12-15',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,'reese','xxxxx');
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (60,'Tyler','Gonzales','1986-06-30',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08','2017-01-02 13:18:07',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (61,'Leo','Swanson','1999-07-16',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (62,'Rodney','Foster','1964-06-11',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,'ruiz','xxxxx');
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (63,'Sue','Goodman','1992-06-17',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (64,'Violet','Holmes','1971-08-06',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08','2019-01-27 22:18:13',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (65,'Samuel','Dennis','1983-11-27',NULL,'2019-08-08 16:17:54','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (66,'Isaac','Austin',NULL,NULL,'1988-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (67,'Rosetta','Lamb','1971-07-23',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (68,'Henrietta','Maldonado',NULL,NULL,'1998-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (69,'Inez','Parks','1995-09-11',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (70,'Ida','Douglas','1965-04-08',NULL,'2015-08-31 20:26:08','2015-08-31 22:26:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (71,'Isabel','Dennis',NULL,NULL,'2001-08-31 20:26:08','2015-08-31 22:26:08','2019-01-27 22:18:34',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (72,'Inez','Parks','1995-02-16',2,'2015-09-21 15:18:17','2015-09-21 17:18:17',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (73,'Ida','Douglas',NULL,NULL,'1965-09-21 15:18:42','2015-09-21 17:18:42',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (74,'George','Reid','1993-05-31',NULL,'2016-01-26 18:03:07','2016-01-26 19:03:07',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (75,'Mason','Gilbert',NULL,2,'1982-04-14 13:45:53','2016-01-27 18:20:33',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (76,'Harvey','Matthews',NULL,NULL,'1995-04-15 16:40:46','2016-01-27 18:21:10',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (77,'Adelaide','Sanchez','1977-04-15',1,'2019-01-27 21:18:53','2016-02-28 18:30:13','2019-01-27 22:19:00',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (78,'Fanny','Collins',NULL,NULL,'1967-02-28 17:31:36','2016-02-28 18:31:36',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (79,'Susie','Hansen',NULL,NULL,'1975-03-10 08:56:43','2016-03-10 09:56:43','2019-01-27 22:19:03',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (81,'Bruce','Elliott',NULL,NULL,'1994-04-13 14:55:33','2016-04-13 16:55:33','2019-01-27 22:19:06',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (82,'Rosetta','Romero','1996-06-15',NULL,'2016-04-13 17:07:34','2016-04-13 19:07:34',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (83,'Matthew','Padilla','1991-06-22',NULL,'2016-04-13 17:09:48','2016-04-13 19:09:48',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (84,'Keith','Mills','1986-10-04',2,'2019-08-16 14:55:09','2016-04-13 19:11:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (85,'Lois','Copeland','1985-04-14',NULL,'2016-04-13 17:12:03','2016-04-13 19:12:03',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (86,'Sean','Nunez','1959-09-09',NULL,'2016-04-13 17:14:19','2016-04-13 19:14:19',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (87,'Edward','Delgado','1972-06-09',NULL,'2016-04-13 17:14:45','2016-04-13 19:14:45',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (89,'Vera','Buchanan',NULL,NULL,'1965-04-27 14:57:06','2016-04-27 16:57:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (90,'Catherine','Hicks','1956-06-26',NULL,'2016-05-04 15:06:27','2016-05-04 17:06:27',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (91,'Olga','Reid',NULL,NULL,'1958-05-04 15:06:44','2016-05-04 17:06:44',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (92,'Angel','Gordon',NULL,2,'1960-01-16 11:32:54','2017-01-16 12:32:54',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (93,'Dora','Barnes',NULL,2,'1958-09-24 03:49:26',NULL,NULL,'rebecca','xxxxx');
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (119,'Isabel','Dennis','2001-05-17',NULL,'2019-01-28 14:05:09','2017-06-18 12:44:52',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (120,'Flora','Hudson','1965-08-31',NULL,NULL,'2017-08-09 21:13:20',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (121,'Nelle','Tran','1963-03-07',2,'2017-10-28 23:51:54','2017-10-29 01:51:54','2019-01-27 22:19:27',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (122,'Fanny','Kim','1974-04-27',NULL,'2017-11-05 12:47:51','2017-11-05 13:47:51',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (123,'Lois','Copeland','1985-03-08',NULL,'2018-01-17 17:43:47','2018-01-17 18:43:47',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (124,'Inez','Parks','1995-09-06',NULL,'2018-01-17 17:44:31','2018-01-17 18:44:31',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (125,'Terry','Bell','1983-08-03',NULL,'2018-01-17 17:45:51','2018-01-17 18:45:51','2018-06-26 06:35:25',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (126,'Isaac','Austin','1988-02-21',NULL,'2018-01-17 17:47:41','2018-01-17 18:47:41',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (127,'Marcus','Cook','1983-10-01',NULL,'2018-01-17 17:49:08','2018-01-17 18:49:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (128,'Harvey','Matthews','1995-03-05',NULL,'2018-01-17 17:50:49','2018-01-17 18:50:49',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (129,'Francis','Bailey','1970-11-18',NULL,'2018-01-17 17:51:53','2018-01-17 18:51:53',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (130,'Vera','Buchanan','1965-05-02',NULL,'2018-01-17 17:53:32','2018-01-17 18:53:32',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (131,'Dean','Schmidt','1974-10-07',NULL,'2018-02-07 19:09:39','2018-02-07 20:09:39',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (132,'Hilda','White','1996-01-29',NULL,'2018-02-07 19:13:22','2018-02-07 20:11:26',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (133,'Rosetta','Lamb','1971-03-19',NULL,'2018-02-21 17:31:59','2018-02-21 18:31:59',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (134,'Virgie','Webb','1979-08-03',1,'2018-08-25 08:57:17','2018-02-21 18:33:19',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (135,'Dora','Barnes','1958-09-12',NULL,'2018-02-21 17:34:59','2018-02-21 18:34:59',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (136,'Isabelle','Schultz','1996-05-20',NULL,'2018-02-21 17:36:57','2018-02-21 18:36:57',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (137,'Terry','Bell','1983-12-01',NULL,'2019-09-24 03:49:35','2018-04-14 12:26:14',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (138,'Eliza','Moore','1974-08-29',NULL,'2018-04-22 17:05:06','2018-04-22 19:05:06',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (139,'Lucille','Long','1960-08-29',NULL,'2018-04-22 17:06:58','2018-04-22 19:06:58',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (140,'Eva','Nash','1979-12-26',2,'2018-06-20 15:57:01','2018-06-20 17:57:01',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (141,'Eva','Nash','1979-06-18',2,'2019-02-17 19:09:55','2018-06-25 17:04:38',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (142,'Tyler','Gonzales','1986-10-23',1,'2019-09-24 03:49:47','2018-11-28 18:21:08',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (143,'Fanny','Kim','1974-08-06',NULL,'2018-11-28 17:23:32','2018-11-28 18:23:32',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (144,'Ricky','Matthews','1966-09-29',NULL,'2019-01-16 17:03:40','2019-01-16 18:03:40',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (145,'Isaiah','Schmidt','1995-09-28',NULL,'2019-01-16 17:05:03','2019-01-16 18:05:03','2019-01-27 22:19:53',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (148,'Steve','Hawkins','1995-08-07',2,'2019-09-24 03:49:56','2019-01-31 22:40:02',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (165,'Ricky','Matthews','1966-10-08',2,'2019-08-17 14:24:47','2019-08-17 16:24:35','2019-08-20 00:48:24',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (166,'Sean','Nunez','1959-10-07',1,'2019-08-17 14:45:57','2019-08-17 16:45:13','2019-08-20 00:48:27',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (167,'Matthew','Padilla','1991-08-13',2,'2019-08-19 22:36:06','2019-08-20 00:36:06','2019-08-20 00:43:35',NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (168,'Catherine','Hicks','1956-08-10',2,'2019-08-19 23:17:14','2019-08-20 01:14:52',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (169,'Hilda','White','1996-08-19',1,'2020-01-28 17:53:17','2020-01-28 18:53:17',NULL,NULL,NULL);
INSERT INTO person(id, prename, surname, birth, gender, changed, created, deleted, username, password) VALUES (170,'Stephen','Castro','1977-10-09',2,'2020-01-28 18:13:30','2020-01-28 19:07:01',NULL,NULL,NULL);

--
-- Dumping data for table clubevent
--
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('1f3tph0d1lmoe80fs7dokeo1ds',NULL,'1f3tph0d1lmoe80fs7dokeo1ds@google.com','mtv_allgemein','Turnfest Oldenburg',NULL,'2020-05-20','2020-05-24',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('1hqi3ntpo80mf3evls4jqh5505',NULL,'1hqi3ntpo80mf3evls4jqh5505@google.com','mtv_wettkampf','Bezirks DMT',NULL,'2019-03-02','2019-03-02',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('2jpqksdhsk6g97r1cjh3t5llck','Göttingen','2jpqksdhsk6g97r1cjh3t5llck@google.com','mtv_wettkampf','LM Senioren: Katharina','Absagen: Nika, Maarten','2019-11-23','2019-11-23',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('3pqgg0g4lqdf1veik7e28vbam4',NULL,'3pqgg0g4lqdf1veik7e28vbam4@google.com','mtv_wettkampf','BZEinsteigerwettkampf','Absagen: Saskia','2019-11-30','2019-11-30',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('416dla37hvjknqrgoqaq91utbk','Laatzen?','416dla37hvjknqrgoqaq91utbk@google.com','mtv_wettkampf','LM Mannschaft',NULL,'2019-06-22','2019-06-22',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('5ab6m62nuqbmsea8gqgbp7hj5k','Laatzen','5ab6m62nuqbmsea8gqgbp7hj5k@google.com','mtv_wettkampf','KR-Einzel-MS',NULL,'2019-08-24','2019-08-24',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('6goj4cr6cgom2b9o69h68b9kcko36b9oc4o6ab9i70pm4e1o68p6aohi6s',NULL,'6goj4cr6cgom2b9o69h68b9kcko36b9oc4o6ab9i70pm4e1o68p6aohi6s@google.com','mtv_allgemein','Prämienveranstaltung sparkasse',NULL,'2019-12-05','2019-12-05',0,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('6k86gnjvjat0mbud82jmuml0kc','Pattensen?','6k86gnjvjat0mbud82jmuml0kc@google.com','mtv_wettkampf','KR-Mannschafts-MS',NULL,'2019-05-11','2019-05-12',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('6oqjacr4chij8b9k6cs3ib9k74r32bb170qmabb170s36cr368qm2o9j74','Laatzen','6oqjacr4chij8b9k6cs3ib9k74r32bb170qmabb170s36cr368qm2o9j74@google.com','mtv_wettkampf','Lehrgang Tipps&Tricks',NULL,'2019-10-27','2019-10-27',0,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('6phj4chj6pj30bb36tgj2b9k6oqjab9oc4q32b9icph3gopg71ijic9gcg',NULL,'6phj4chj6pj30bb36tgj2b9k6oqjab9oc4q32b9icph3gopg71ijic9gcg@google.com','mtv_allgemein','Vereinsmeisterschaft',NULL,'2019-11-16','2019-11-16',0,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('6ss34dhkcdhjgb9ickqjcb9k69hj8b9p6gqm8bb171h66d1mckq64e1ncg',NULL,'6ss34dhkcdhjgb9ickqjcb9k69hj8b9p6gqm8bb171h66d1mckq64e1ncg@google.com','mtv_allgemein','Ultimate kommt zurück',NULL,'2019-11-01','2019-11-01',0,1);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('7b6ugv4gh4slj47qsrjhfod3pg','Wunstorf','7b6ugv4gh4slj47qsrjhfod3pg@google.com','mtv_wettkampf','BZ DMT',NULL,'2019-03-02','2019-03-02',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('8q1am0fl47cn1h22j9m3348q48','Salzgitter','8q1am0fl47cn1h22j9m3348q48@google.com','mtv_wettkampf','LM Einzel',NULL,'2019-04-06','2019-04-06',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('8s2qo3v7pbclupqhsjfm1jfmqo','Poggenhagen','8s2qo3v7pbclupqhsjfm1jfmqo@google.com','mtv_wettkampf','BZMannschaftsMS',NULL,'2019-05-18','2019-05-18',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('a1inmotgn59qlou6n2kij3buco','Wunstorf','a1inmotgn59qlou6n2kij3buco@google.com','mtv_allgemein','F-Schein',NULL,'2019-06-29','2019-06-30',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('b0nj81eie0tc1neln1lmh5t9rs','Grasdorf, 30880 Laatzen, Deutschland','b0nj81eie0tc1neln1lmh5t9rs@google.com','mtv_wettkampf','BZSynchronMS',NULL,'2019-09-14','2019-09-14',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('b16m8eb2dmontpqki35ehvnlko','Laatzen, Albert-Einstein-Schule','b16m8eb2dmontpqki35ehvnlko@google.com','mtv_wettkampf','LM Synchron: Nika & Tala',NULL,'2019-11-02','2019-11-02',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('d79sjvhr416m3lbu2tn3m0omv4','Berenbostel, Garbsen, Deutschland','d79sjvhr416m3lbu2tn3m0omv4@google.com','mtv_allgemein','KR-Schein Passiv',NULL,'2019-01-12','2019-01-12',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('da5vvbhhoivia5sl5dhdqcn5fc',NULL,'da5vvbhhoivia5sl5dhdqcn5fc@google.com','mtv_wettkampf','LM Synchron',NULL,'2019-10-26','2019-10-26',0,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('ipq6elmji5p4bbkgvrbv28vgks','Poggenhagen','ipq6elmji5p4bbkgvrbv28vgks@google.com','mtv_wettkampf','BZEinzelMS',NULL,'2019-08-31','2019-08-31',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('j905urdm6gut66efql31nddta0','Laatzen','j905urdm6gut66efql31nddta0@google.com','mtv_allgemein','G-Schein',NULL,'2019-03-09','2019-03-10',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('ktginr305jn6l71omiggs4u1d8','Bremerhaven, Deutschland','ktginr305jn6l71omiggs4u1d8@google.com','mtv_wettkampf','Küstenteam-Cup',NULL,'2019-09-28','2019-09-28',1,1);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('l5s96f8l1fn5tdsqn4ir7hgc04','Melle','l5s96f8l1fn5tdsqn4ir7hgc04@google.com','mtv_allgemein','Trainer C 1. Teil',NULL,'2019-10-04','2019-10-06',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('nvlcjgfs6vl4i3sc4rhgnlc2g8','Laatzen','nvlcjgfs6vl4i3sc4rhgnlc2g8@google.com','mtv_wettkampf','Leine-Pokal',NULL,'2019-05-04','2019-05-04',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('obsq4kli1u16o9e01enbhde1a4','Laatzen','obsq4kli1u16o9e01enbhde1a4@google.com','mtv_wettkampf','Kreissynchronmeisterschaften',NULL,'2019-08-25','2019-08-25',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('q7mcfne5l3qgb2i82egmmb7kt4','Darmstadt','q7mcfne5l3qgb2i82egmmb7kt4@google.com','mtv_wettkampf','HCC-Ball','Absagen: Nika','2019-12-07','2019-12-07',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('qpj15a2495o7k8ee62fsrg8akk','Neu Wulmsdorf','qpj15a2495o7k8ee62fsrg8akk@google.com','mtv_wettkampf','LM DMT',NULL,'2019-02-16','2019-02-16',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('qs45hjtsivmjmpriirmn0mjf5g','Grasdorf, 30880 Laatzen, Deutschland','qs45hjtsivmjmpriirmn0mjf5g@google.com','mtv_wettkampf','Oldies Cup',NULL,'2019-09-20','2019-09-22',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h71fn8pbidlkmsdb168pjaphl70qj4d9g6t076or8elm6cpbid5imsbjfe9jg',NULL,'F_2018_termin5a235f5852507@schulferien.org','Schulferien','Weihnachtsferien 2018 Niedersachsen','Alle Termine auf www.schulferien.org','2018-12-24','2019-01-04',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8dhk61076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e5574640@schulferien.org','Schulferien','Winterferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-01-31','2019-02-01',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8dj4c9076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e55746db@schulferien.org','Schulferien','Osterferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-04-08','2019-04-23',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8dpm6d076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e5574763@schulferien.org','Schulferien','Pfingstferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-05-31','2019-05-31',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8dr471076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e55747d8@schulferien.org','Schulferien','Pfingstferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-06-11','2019-06-11',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8e1kc9076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e557484b@schulferien.org','Schulferien','Sommerferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-07-04','2019-08-14',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8e32cp076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e55748bf@schulferien.org','Schulferien','Herbstferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-10-04','2019-10-18',1,0);
-- INSERT INTO clubevent(id, location, ICALUID, organizerDisplayName, caption, description, start, end, allDay, deleted) VALUES ('_8pfj4c1h75fn8pbidlkmsdb360o3ip9l6krj8e9l6p076or8elm6cpbid5imsbjfe9jg',NULL,'F_2019_termin5c009e5574956@schulferien.org','Schulferien','Weihnachtsferien 2019 Niedersachsen','Alle Termine auf www.schulferien.org','2019-12-23','2020-01-06',1,0);

--
-- Dumping data for table pflichten
--
INSERT INTO pflichten(id, name, fixed, ordered, comment, changed, created, deleted) VALUES (1,'P3',1,3,NULL,'2019-01-27 22:40:17','2019-01-27 23:40:17',NULL);
INSERT INTO pflichten(id, name, fixed, ordered, comment, changed, created, deleted) VALUES (2,'P4',1,4,NULL,'2019-01-27 22:40:17','2019-01-27 23:40:17',NULL);
INSERT INTO pflichten(id, name, fixed, ordered, comment, changed, created, deleted) VALUES (3,'P5',1,5,NULL,'2019-01-27 22:40:17','2019-01-27 23:40:17',NULL);
INSERT INTO pflichten(id, name, fixed, ordered, comment, changed, created, deleted) VALUES (4,'P6',1,6,NULL,'2019-01-27 22:40:17','2019-01-27 23:40:17',NULL);
INSERT INTO pflichten(id, name, fixed, ordered, comment, changed, created, deleted) VALUES (5,'P7',1,7,NULL,'2019-01-27 22:40:17','2019-01-27 23:40:17',NULL);
INSERT INTO pflichten(id, name, fixed, ordered, comment, changed, created, deleted) VALUES (6,'P8',1,8,NULL,'2019-01-27 22:40:17','2019-01-27 23:40:17',NULL);

--
-- Dumping data for table adress
--
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (2,'Kacveb View','','30004','Leadenit',1,'2019-01-29 00:06:52','2015-08-31 22:26:16',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (3,'Etco Point','','30003','Uwsatubi',41,'2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (4,'Bafsam Path','','30004','Jihuvbe',70,'2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (5,'Vojir Heights','','30004','Loksekoc',38,'2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (6,'Vipmub Pike','','30003','Ugenukiv',74,'2016-01-26 18:04:00','2016-01-26 19:04:00',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (7,'Hiogo Trail','','30002','Owacomso',62,'2016-04-13 17:06:15','2016-04-13 19:06:15',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (8,'Falwuh Heights','','30005','Vehiwdu',1,'2019-01-29 00:06:52','2019-01-29 00:36:02','2019-01-29 01:06:27');
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (9,'Sohwi Key','','30005','Kapesil',17,'2019-01-31 13:37:24','2019-01-31 14:37:24',NULL);
INSERT INTO adress(id, adress1, adress2, plz, city, person_id, changed, created, deleted) VALUES (11,'Ufdaw Mill','','30001','Kuzmirog',148,'2019-01-31 21:42:05','2019-01-31 22:42:05',NULL);

--
-- Dumping data for table altersgruppe
--
-- INSERT INTO altersgruppe(id, event_id, PFLICHT_ID, bezeichnung, start, end, changed, created, deleted) VALUES (1,'nvlcjgfs6vl4i3sc4rhgnlc2g8',2,'Jugend D',2010,'2019','2019-01-27 21:46:28','2019-01-27 22:46:28',NULL);
-- INSERT INTO altersgruppe(id, event_id, PFLICHT_ID, bezeichnung, start, end, changed, created, deleted) VALUES (2,'nvlcjgfs6vl4i3sc4rhgnlc2g8',4,'Jugend C',2008,'2009','2019-01-27 21:46:58','2019-01-27 22:46:58',NULL);
-- INSERT INTO altersgruppe(id, event_id, PFLICHT_ID, bezeichnung, start, end, changed, created, deleted) VALUES (3,'nvlcjgfs6vl4i3sc4rhgnlc2g8',6,'Jugend B',2003,'2007','2019-01-27 21:50:56','2019-01-27 22:47:26',NULL);

--
-- Dumping data for table attendance
--
--	INSERT INTO attendance VALUES (1,'2018-01-17',1,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (2,'2018-01-17',120,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (3,'2018-01-17',121,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (4,'2018-01-17',38,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (5,'2018-01-17',3,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (6,'2018-01-17',62,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (7,'2018-01-17',72,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (8,'2018-01-17',75,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (9,'2018-01-17',9,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (10,'2018-01-17',92,'2018-01-17 17:42:48','2018-01-17 18:42:48',NULL);
--	INSERT INTO attendance VALUES (11,'2018-01-17',123,'2018-01-17 17:44:55','2018-01-17 18:44:55',NULL);
--	INSERT INTO attendance VALUES (12,'2018-01-17',124,'2018-01-17 17:44:55','2018-01-17 18:44:55',NULL);
--	INSERT INTO attendance VALUES (13,'2018-01-17',125,'2018-01-17 17:46:19','2018-01-17 18:46:19',NULL);
--	INSERT INTO attendance VALUES (14,'2018-01-17',126,'2018-01-17 17:48:08','2018-01-17 18:48:08',NULL);
--	INSERT INTO attendance VALUES (15,'2018-01-17',127,'2018-01-17 17:49:37','2018-01-17 18:49:37',NULL);
--	INSERT INTO attendance VALUES (16,'2018-01-17',128,'2018-01-17 17:51:06','2018-01-17 18:51:06',NULL);
--	INSERT INTO attendance VALUES (17,'2018-01-17',129,'2018-01-17 17:52:46','2018-01-17 18:52:46',NULL);
--	INSERT INTO attendance VALUES (18,'2018-01-17',32,'2018-01-17 20:21:37','2018-01-17 21:21:37',NULL);
--	INSERT INTO attendance VALUES (19,'2018-02-07',1,'2018-02-07 17:01:35','2018-02-07 18:01:35',NULL);
--	INSERT INTO attendance VALUES (20,'2018-02-07',32,'2018-02-07 17:01:35','2018-02-07 18:01:35',NULL);
--	INSERT INTO attendance VALUES (21,'2018-02-07',8,'2018-02-07 17:01:35','2018-02-07 18:01:35',NULL);
--	INSERT INTO attendance VALUES (22,'2018-02-07',3,'2018-02-07 17:01:35','2018-02-07 18:01:35',NULL);
--	INSERT INTO attendance VALUES (23,'2018-02-07',72,'2018-02-07 17:01:35','2018-02-07 18:01:35',NULL);
--	INSERT INTO attendance VALUES (24,'2018-02-07',15,'2018-02-07 19:10:01','2018-02-07 20:10:01',NULL);
--	INSERT INTO attendance VALUES (25,'2018-02-07',131,'2018-02-07 19:10:11','2018-02-07 20:10:11',NULL);
--	INSERT INTO attendance VALUES (26,'2018-02-07',127,'2018-02-07 19:13:12','2018-02-07 20:13:12',NULL);
--	INSERT INTO attendance VALUES (27,'2018-02-07',129,'2018-02-07 19:13:12','2018-02-07 20:13:12',NULL);
--	INSERT INTO attendance VALUES (28,'2018-02-07',132,'2018-02-07 19:13:12','2018-02-07 20:13:12',NULL);
--	INSERT INTO attendance VALUES (29,'2018-02-19',72,'2018-02-19 19:34:11','2018-02-19 20:34:11',NULL);
--	INSERT INTO attendance VALUES (30,'2018-02-19',32,'2018-02-19 19:34:11','2018-02-19 20:34:11',NULL);
--	INSERT INTO attendance VALUES (31,'2018-02-21',1,'2018-02-21 17:32:12','2018-02-21 18:32:12',NULL);
--	INSERT INTO attendance VALUES (32,'2018-02-21',127,'2018-02-21 17:32:12','2018-02-21 18:32:12',NULL);
--	INSERT INTO attendance VALUES (33,'2018-02-21',129,'2018-02-21 17:32:12','2018-02-21 18:32:12',NULL);
--	INSERT INTO attendance VALUES (34,'2018-02-21',134,'2018-02-21 17:35:07','2018-02-21 18:35:07',NULL);
--	INSERT INTO attendance VALUES (35,'2018-02-21',8,'2018-02-21 17:35:07','2018-02-21 18:35:07',NULL);
--	INSERT INTO attendance VALUES (36,'2018-02-21',32,'2018-02-21 17:35:07','2018-02-21 18:35:07',NULL);
--	INSERT INTO attendance VALUES (37,'2018-02-21',3,'2018-02-21 17:35:07','2018-02-21 18:35:07',NULL);
--	INSERT INTO attendance VALUES (38,'2018-02-21',17,'2018-02-21 17:35:39','2018-02-21 18:35:39',NULL);
--	INSERT INTO attendance VALUES (39,'2018-02-21',135,'2018-02-21 17:35:39','2018-02-21 18:35:39',NULL);
--	INSERT INTO attendance VALUES (40,'2018-02-21',72,'2018-02-21 17:35:39','2018-02-21 18:35:39',NULL);
--	INSERT INTO attendance VALUES (41,'2018-02-21',75,'2018-02-21 17:35:39','2018-02-21 18:35:39',NULL);
--	INSERT INTO attendance VALUES (42,'2018-02-21',15,'2018-02-21 17:37:31','2018-02-21 18:37:31',NULL);

--
-- Dumping data for table clubevent_addon
--
-- INSERT INTO clubevent_addon VALUES ('2jpqksdhsk6g97r1cjh3t5llck','EINZEL');
-- INSERT INTO clubevent_addon VALUES ('3pqgg0g4lqdf1veik7e28vbam4','EINZEL');
-- INSERT INTO clubevent_addon VALUES ('416dla37hvjknqrgoqaq91utbk','MANNSCHAFT');
-- INSERT INTO clubevent_addon VALUES ('5ab6m62nuqbmsea8gqgbp7hj5k','EINZEL');
-- INSERT INTO clubevent_addon VALUES ('6k86gnjvjat0mbud82jmuml0kc','MANNSCHAFT');
-- INSERT INTO clubevent_addon VALUES ('7b6ugv4gh4slj47qsrjhfod3pg','DOPPELMINI');
-- INSERT INTO clubevent_addon VALUES ('8q1am0fl47cn1h22j9m3348q48','EINZEL');
-- INSERT INTO clubevent_addon VALUES ('8s2qo3v7pbclupqhsjfm1jfmqo','MANNSCHAFT');
-- INSERT INTO clubevent_addon VALUES ('b0nj81eie0tc1neln1lmh5t9rs','SYNCHRON');
-- INSERT INTO clubevent_addon VALUES ('da5vvbhhoivia5sl5dhdqcn5fc','SYNCHRON');
-- INSERT INTO clubevent_addon VALUES ('ipq6elmji5p4bbkgvrbv28vgks','EINZEL');
-- INSERT INTO clubevent_addon VALUES ('nvlcjgfs6vl4i3sc4rhgnlc2g8','EINZEL');
-- INSERT INTO clubevent_addon VALUES ('obsq4kli1u16o9e01enbhde1a4','SYNCHRON');
-- INSERT INTO clubevent_addon VALUES ('q7mcfne5l3qgb2i82egmmb7kt4','DOPPELMINI');
-- INSERT INTO clubevent_addon VALUES ('qpj15a2495o7k8ee62fsrg8akk','DOPPELMINI');
-- INSERT INTO clubevent_addon VALUES ('qs45hjtsivmjmpriirmn0mjf5g','EINZEL');

--
-- Dumping data for table clubevent_has_person
--
-- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('nvlcjgfs6vl4i3sc4rhgnlc2g8',32,'');
-- -- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('nvlcjgfs6vl4i3sc4rhgnlc2g8',72,'');
-- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('nvlcjgfs6vl4i3sc4rhgnlc2g8',134,'');
-- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('nvlcjgfs6vl4i3sc4rhgnlc2g8',141,'');
-- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('qpj15a2495o7k8ee62fsrg8akk',32,'');
-- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('qpj15a2495o7k8ee62fsrg8akk',72,'');
-- INSERT INTO clubevent_has_person(clubevent_id, person_id, comment) VALUES ('qpj15a2495o7k8ee62fsrg8akk',134,'');

-- (id, name, changed, created, deleted)
--
-- Dumping data for table contact
--
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (1,'Telefon','(888) 602-2973',1,'2019-01-29 00:06:52','2015-08-31 22:26:08',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (2,'Email','zotak@seenwo.bj',1,'2019-01-29 00:06:52','2015-08-31 22:26:09','2019-01-27 17:37:51');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (3,'Mobile','vo@tivos.hu',1,'2019-06-09 12:38:52','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (4,'Telefon','(540) 566-6632',2,'2019-01-27 14:18:15','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (5,'Telefon','(540) 566-6632',3,'2019-08-10 22:19:10','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (6,'Email','kon@wi.as',3,'2019-08-10 22:19:10','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (7,'Mobile','zigdav@of.kz',3,'2019-08-10 22:19:10','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (8,'Telefon','(283) 478-9810',4,'2015-08-31 20:26:09','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (9,'Mobile','we@gezpahen.lv',4,'2015-08-31 20:26:09','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (10,'Telefon','(334) 355-3748',5,'2015-08-31 20:26:09','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (11,'Mobile','lole@mo.fk',5,'2015-08-31 20:26:09','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (12,'Telefon','(248) 698-3997',6,'2015-08-31 20:26:09','2015-08-31 22:26:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (13,'Telefon','(464) 629-7364',7,'2015-08-31 20:26:10','2015-08-31 22:26:10','2018-01-03 20:27:01');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (14,'Mobile','pimavwo@romiw.mp',8,'2019-01-28 13:55:17','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (15,'Mobile','lole@mo.fk',9,'2015-08-31 20:26:10','2015-08-31 22:26:10','2017-03-05 23:17:44');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (16,'Telefon','(516) 427-8337',10,'2019-08-08 15:41:23','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (17,'Telefon','(931) 911-1814',11,'2015-08-31 20:26:10','2015-08-31 22:26:10','2018-01-03 20:27:30');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (18,'Telefon','(936) 440-2039',13,'2015-08-31 20:26:10','2015-08-31 22:26:10','2018-01-04 14:20:14');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (19,'Telefon','(833) 772-7674',14,'2015-08-31 20:26:10','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (20,'Mobile','raali@nirre.mt',14,'2015-08-31 20:26:10','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (21,'Telefon','(608) 941-4676',15,'2015-08-31 20:26:10','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (22,'Telefon','(234) 970-2034',17,'2019-01-31 13:37:24','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (23,'Mobile','uberutuz@ciwfan.ba',17,'2019-01-31 13:37:24','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (24,'Email','meudoak@kuhgugol.lr',17,'2019-01-31 13:37:24','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (25,'Telefon','(516) 427-8337',20,'2015-08-31 20:26:10','2015-08-31 22:26:10',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (26,'Telefon','(508) 986-2859',21,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (27,'Telefon','(264) 271-7618',22,'2015-08-31 20:26:11','2015-08-31 22:26:11','2018-01-03 20:25:41');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (28,'Mobile','pufuh@eriwak.mt',22,'2015-08-31 20:26:11','2015-08-31 22:26:11','2018-01-03 20:25:41');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (29,'Telefon','(936) 440-2039',24,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (30,'Telefon','(209) 967-1945',25,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (31,'Telefon','(762) 946-8176',27,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (32,'Mobile','nug@pig.mr',28,'2015-08-31 20:26:11','2015-08-31 22:26:11','2018-01-03 20:26:05');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (33,'Email','midupab@nopaj.ga',28,'2015-08-31 20:26:11','2015-08-31 22:26:11','2018-01-03 20:26:05');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (34,'Email','etcej@tud.de',29,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (35,'Mobile','sanud@mub.bs',30,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (36,'Telefon','(464) 629-7364',30,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (37,'Telefon','(846) 479-6053',31,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (38,'Mobile','nug@pig.mr',32,'2015-08-31 20:26:11','2015-08-31 22:26:11',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (39,'Email','wenfe@gedage.to',32,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (40,'Telefon','(608) 941-4676',32,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (41,'Email','agugo@pavaso.kz',33,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (42,'Telefon','(307) 537-9417',33,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (43,'Mobile','ovajom@uleabo.ae',34,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (44,'Mobile','na@ibiaf.re',35,'2015-08-31 20:26:12','2015-08-31 22:26:12','2018-01-04 14:21:10');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (45,'Email','bufce@pud.vg',35,'2015-08-31 20:26:12','2015-08-31 22:26:12','2018-01-04 14:21:10');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (46,'Telefon','(524) 642-2004',35,'2015-08-31 20:26:12','2015-08-31 22:26:12','2018-01-04 14:21:10');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (47,'Mobile','pufuh@eriwak.mt',35,'2015-08-31 20:26:12','2015-08-31 22:26:12','2018-01-04 14:21:10');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (48,'Mobile','dullo@since.fr',36,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (49,'Mobile','he@na.cv',38,'2019-01-28 14:02:40','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (50,'Email','bu@abe.md',38,'2019-01-28 14:02:40','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (51,'Telefon','(680) 418-9656',39,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (52,'Telefon','(215) 873-8629',41,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (53,'Telefon','(651) 755-3059',42,'2015-08-31 20:26:12','2015-08-31 22:26:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (54,'Email','rulmi@giam.dk',42,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (55,'Mobile','erazaj@li.th',42,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (56,'Mobile','do@repaguno.sg',48,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (57,'Mobile','ve@nihzuwwa.bz',51,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (58,'Email','ov@eku.ml',51,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (59,'Mobile','rulmi@giam.dk',52,'2019-01-28 13:56:28','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (60,'Email','lole@mo.fk',52,'2019-01-28 13:56:28','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (61,'Mobile','fidig@fugih.bb',49,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (62,'Email','se@talmu.gi',49,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (63,'Mobile','fe@nagopid.eh',29,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (64,'Email','za@vol.tk',53,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (65,'Telefon','(737) 442-7131',53,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (66,'Mobile','ji@agsifgi.ru',53,'2015-08-31 20:26:13','2015-08-31 22:26:13',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (67,'Mobile','iwo@kil.gs',47,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (68,'Telefon','(902) 398-1248',43,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (69,'Mobile','he@na.cv',54,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (70,'Email','abi@penkisag.er',54,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (71,'Mobile','foisi@durwo.pt',56,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (72,'Email','fehepte@jajfawzib.ac',58,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (73,'Mobile','ve@nihzuwwa.bz',41,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (74,'Mobile','vo@tivos.hu',59,'2015-08-31 20:26:14','2015-08-31 22:26:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (75,'Email','agugo@pavaso.kz',59,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (76,'Telefon','(902) 398-1248',61,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (77,'Mobile','cubuj@sauku.kz',62,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (78,'Mobile','ubaicitu@al.re',62,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (79,'Telefon','(651) 755-3059',7,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (80,'Mobile','za@vol.tk',63,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (81,'Telefon','(427) 897-8264',64,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (82,'Email','fe@nagopid.eh',43,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (83,'Mobile','abi@penkisag.er',66,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (84,'Email','we@gezpahen.lv',7,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (85,'Mobile','belhicke@voznuz.wf',68,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (86,'Mobile','ilizafep@ze.in',70,'2015-08-31 20:26:15','2015-08-31 22:26:15',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (87,'Email','moges@zosice.br',66,'2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (88,'Mobile','cujope@vanzu.gh',61,'2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (89,'Mobile','otufira@kog.gb',73,'2015-09-21 15:18:56','2015-09-21 17:18:56',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (90,'Email','ri@sota.hu',73,'2016-01-25 18:10:17','2016-01-25 19:10:17',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (91,'Telefon','(420) 244-1950',74,'2016-01-26 18:04:07','2016-01-26 19:04:07',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (92,'Email','jot@seov.sn',74,'2016-01-26 18:04:39','2016-01-26 19:04:39',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (93,'Email','erazaj@li.th',76,'2016-01-27 17:21:24','2016-01-27 18:21:24',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (94,'Mobile','siwar@upewuf.cg',12,'2019-08-08 15:41:36','2016-01-30 10:30:37',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (95,'Mobile','haces@viwali.ml',12,'2019-08-08 15:41:36','2016-01-30 14:58:54',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (96,'Mobile','lole@mo.fk',76,'2016-02-08 16:15:59','2016-02-08 17:15:59',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (97,'Mobile','sowi@nigsite.fj',78,'2016-02-28 17:32:17','2016-02-28 18:32:17',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (98,'Email','zenvazkus@veohav.va',78,'2016-03-01 19:44:54','2016-03-01 20:44:54',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (99,'Mobile','rulmi@giam.dk',79,'2016-03-10 08:57:00','2016-03-10 09:57:00',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (100,'Mobile','ilizafep@ze.in',81,'2016-04-13 14:56:01','2016-04-13 16:56:01',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (101,'Mobile','lebanema@wamo.am',82,'2016-04-13 17:08:07','2016-04-13 19:08:07',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (102,'Mobile','pegev@egojine.tm',83,'2016-04-13 17:09:55','2016-04-13 19:09:55',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (103,'Mobile','bu@abe.md',85,'2016-04-13 17:12:19','2016-04-13 19:12:19',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (104,'Mobile','fehepte@jajfawzib.ac',84,'2019-08-16 14:55:09','2016-04-13 19:16:44',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (105,'Mobile','otufira@kog.gb',89,'2016-04-27 14:57:25','2016-04-27 16:57:25',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (106,'Mobile','sowi@nigsite.fj',50,'2016-04-27 18:34:08','2016-04-27 20:34:08',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (107,'Mobile','agugo@pavaso.kz',91,'2016-05-04 15:07:17','2016-05-04 17:07:17',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (108,'Telefon','(215) 616-5620',93,'2019-01-28 14:04:58','2017-04-05 11:59:12',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (109,'Mobile','fidig@fugih.bb',7,'2017-06-18 10:12:51','2017-03-08 08:35:34',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (110,'Telefon','(584) 253-6269',119,'2019-01-28 14:05:09','2017-07-02 07:19:01',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (111,'Email','catji@fir.vu',119,'2019-01-28 14:05:09','2017-07-02 07:19:38',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (112,'Mobile','zugzil@ruzepid.aq',119,'2019-01-28 14:05:09','2017-07-02 07:21:14',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (113,'Email','ag@tugidi.ye',120,'2017-08-09 19:14:46','2017-08-09 21:14:46',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (114,'Mobile','hog@giot.vu',120,'2017-08-09 19:15:23','2017-08-09 21:15:23',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (115,'Mobile','zenvazkus@veohav.va',129,'2018-01-17 17:52:22','2018-01-17 18:52:22',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (116,'Mobile','lohen@cepforham.an',133,'2018-03-07 18:57:09','2018-03-07 19:57:09',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (117,'Mobile','jivzib@efa.dk',140,'2018-06-20 15:57:32','2018-06-20 17:57:32',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (118,'Mobile','ovur@waus.cv',141,'2019-02-17 19:09:55','2018-06-25 17:05:03',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (119,'Mobile','sanud@mub.bs',141,'2019-02-17 19:09:55','2018-06-25 17:05:24',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (120,'Telefon','(630) 397-2432',142,'2018-11-28 17:22:00','2018-11-28 18:22:00',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (121,'Telefon','(944) 836-6361',143,'2018-11-28 17:24:00','2018-11-28 18:24:00',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (122,'Mobile','zugzil@ruzepid.aq',144,'2019-01-16 17:04:05','2019-01-16 18:04:05',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (123,'Email','kojvutmoz@nem.il',145,'2019-01-16 17:05:27','2019-01-16 18:05:27',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (125,'Email','otadisdu@koahju.gb',1,'2019-01-29 00:06:52','2019-01-28 01:52:34',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (126,'Telefon','(833) 772-7674',1,'2019-01-28 23:36:02','2019-01-28 02:00:16','2019-01-29 00:37:16');
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (127,'Email','cad@fed.no',93,'2019-01-28 14:04:58','2019-01-28 15:04:58',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (129,'Mobile','agugo@pavaso.kz',148,'2019-01-31 21:42:05','2019-01-31 22:42:05',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (130,'Email','ve@nihzuwwa.bz',148,'2019-01-31 21:42:05','2019-01-31 22:42:05',NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (147,'Mobile','kokejuz@lec.it',168,NULL,NULL,NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (148,'Email','foisi@durwo.pt',170,NULL,NULL,NULL);
INSERT INTO contact(id, type, value, person_id, changed, created, deleted) VALUES (149,'Email','af@necoj.ac',170,NULL,NULL,NULL);

--
-- Dumping data for table deleted_entries
--
-- INSERT INTO deleted_entries VALUES (1,'person',14,'2017-01-02 12:15:45','2017-01-02 13:15:45',NULL);
-- INSERT INTO deleted_entries VALUES (2,'person',53,'2017-01-02 12:15:52','2017-01-02 13:15:52',NULL);
-- INSERT INTO deleted_entries VALUES (3,'person',29,'2017-01-02 12:15:55','2017-01-02 13:15:55',NULL);
-- INSERT INTO deleted_entries VALUES (4,'person',40,'2017-01-02 12:15:58','2017-01-02 13:15:58',NULL);
-- INSERT INTO deleted_entries VALUES (5,'person',44,'2017-01-02 12:16:00','2017-01-02 13:16:00',NULL);
-- INSERT INTO deleted_entries VALUES (6,'person',45,'2017-01-02 12:16:02','2017-01-02 13:16:02',NULL);
-- INSERT INTO deleted_entries VALUES (7,'person',4,'2017-01-02 12:16:16','2017-01-02 13:16:16',NULL);
-- INSERT INTO deleted_entries VALUES (8,'person',5,'2017-01-02 12:16:19','2017-01-02 13:16:19',NULL);
-- -- INSERT INTO deleted_entries VALUES (9,'person',34,'2017-01-02 12:16:31','2017-01-02 13:16:31',NULL);
-- INSERT INTO deleted_entries VALUES (10,'person',42,'2017-01-02 12:16:43','2017-01-02 13:16:43',NULL);
-- INSERT INTO deleted_entries VALUES (11,'person',19,'2017-01-02 12:17:03','2017-01-02 13:17:03',NULL);
-- -- INSERT INTO deleted_entries VALUES (12,'person',20,'2017-01-02 12:17:32','2017-01-02 13:17:32',NULL);
-- INSERT INTO deleted_entries VALUES (13,'person',27,'2017-01-02 12:18:00','2017-01-02 13:18:00',NULL);
-- INSERT INTO deleted_entries VALUES (14,'person',24,'2017-01-02 12:18:03','2017-01-02 13:18:03',NULL);
-- INSERT INTO deleted_entries VALUES (15,'person',60,'2017-01-02 12:18:07','2017-01-02 13:18:07',NULL);
-- INSERT INTO deleted_entries VALUES (16,'person',54,'2017-01-07 18:58:05','2017-01-07 19:58:05',NULL);
-- INSERT INTO deleted_entries VALUES (17,'person',37,'2017-01-09 14:45:54','2017-01-09 15:45:54',NULL);
-- INSERT INTO deleted_entries VALUES (18,'person',36,'2017-01-09 14:46:15','2017-01-09 15:46:15',NULL);
-- INSERT INTO deleted_entries VALUES (19,'contact',15,'2017-03-05 22:17:44','2017-03-05 23:17:44',NULL);
-- INSERT INTO deleted_entries VALUES (22,'person',22,'2018-01-03 19:25:41','2018-01-03 20:25:41',NULL);
-- INSERT INTO deleted_entries VALUES (27,'contact',27,'2018-01-03 19:25:41','2018-01-03 20:25:41',NULL);
-- INSERT INTO deleted_entries VALUES (28,'contact',28,'2018-01-03 19:25:41','2018-01-03 20:25:41',NULL);
-- INSERT INTO deleted_entries VALUES (32,'contact',32,'2018-01-03 19:26:05','2018-01-03 20:26:05',NULL);
-- INSERT INTO deleted_entries VALUES (33,'contact',33,'2018-01-03 19:26:05','2018-01-03 20:26:05',NULL);
-- INSERT INTO deleted_entries VALUES (44,'contact',44,'2018-01-04 13:21:10','2018-01-04 14:21:10',NULL);
-- INSERT INTO deleted_entries VALUES (45,'contact',45,'2018-01-04 13:21:10','2018-01-04 14:21:10',NULL);
-- INSERT INTO deleted_entries VALUES (46,'contact',46,'2018-01-04 13:21:10','2018-01-04 14:21:10',NULL);
-- INSERT INTO deleted_entries VALUES (47,'contact',47,'2018-01-04 13:21:10','2018-01-04 14:21:10',NULL);
-- INSERT INTO deleted_entries VALUES (125,'person',125,'2018-06-26 04:35:25','2018-06-26 06:35:25',NULL);
-- INSERT INTO deleted_entries VALUES (140,'person',140,'2018-05-01 12:35:34','2018-05-01 14:35:34',NULL);
-- INSERT INTO deleted_entries VALUES (141,'person',141,'2018-05-01 12:35:59','2018-05-01 14:35:59',NULL);

--
-- Dumping data for table startpaesse
--
INSERT INTO startpaesse(id, person_id, startpass_nr, changed, created, deleted) VALUES (1,1,'90EFBTZ973',NULL,NULL,NULL);
INSERT INTO startpaesse(id, person_id, startpass_nr, changed, created, deleted) VALUES (2,32,'961VPTDV05',NULL,NULL,NULL);
INSERT INTO startpaesse(id, person_id, startpass_nr, changed, created, deleted) VALUES (3,134,'84I8BJBR08',NULL,NULL,NULL);
INSERT INTO startpaesse(id, person_id, startpass_nr, changed, created, deleted) VALUES (4,72,'328W3LUC09',NULL,NULL,NULL);
INSERT INTO startpaesse(id, person_id, startpass_nr, changed, created, deleted) VALUES (6,141,'71BDW73U07','2019-02-17 19:09:55','2019-02-17 20:09:55',NULL);

--
-- Dumping data for table notes
--
INSERT INTO notes(id, person_id, notekey, notetext) VALUES (1,3,'','Eine Notzi zu Person x');
INSERT INTO notes(id, person_id, notekey, notetext) VALUES (2,1,'','Eine Noziz zu Person y');
INSERT INTO notes(id, person_id, notekey, notetext) VALUES (4,170,'','Email vom \n28.01.2020');

--
-- Dumping data for table persongroup
--
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (2,1,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (5,26,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (6,86,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (7,16,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (9,56,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (10,15,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (11,54,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (12,11,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (13,46,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (14,3,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (15,76,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (16,6,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (17,83,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (18,90,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (19,30,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (22,34,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (23,28,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (25,21,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (26,67,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (27,69,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (28,62,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (30,47,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (34,73,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (35,17,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (36,85,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (37,89,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (38,58,1,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (40,39,2,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (41,66,2,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (42,53,3,'2016-12-18 19:55:01','2016-12-18 20:55:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (44,82,1,'2016-12-18 19:55:02','2016-12-18 20:55:02',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (45,40,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (47,63,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (49,55,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (50,64,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (51,31,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (52,75,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (54,33,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (55,60,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (57,25,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (60,59,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (61,36,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (63,87,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (65,51,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (67,70,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (68,44,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (69,68,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (70,32,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (72,72,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (73,91,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (74,45,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (75,43,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (76,27,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (77,79,1,'2016-12-18 19:55:04','2016-12-18 20:55:04',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (78,20,1,'2016-12-18 19:55:05','2016-12-18 20:55:05',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (80,22,1,'2016-12-18 19:55:09','2016-12-18 20:55:09',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (81,23,1,'2016-12-18 19:55:09','2016-12-18 20:55:09',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (82,24,1,'2016-12-18 19:55:09','2016-12-18 20:55:09',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (86,18,1,'2016-12-18 19:55:10','2016-12-18 20:55:10',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (88,9,1,'2016-12-18 19:55:10','2016-12-18 20:55:10',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (89,13,1,'2016-12-18 19:55:10','2016-12-18 20:55:10',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (90,1,7,'2016-12-18 19:56:25','2016-12-18 20:56:25',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (91,37,1,'2016-12-19 15:22:52','2016-12-19 16:22:52',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (92,14,6,'2016-12-19 15:23:20','2016-12-19 16:23:20',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (93,29,6,'2016-12-21 20:14:43','2016-12-21 21:14:43',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (94,1,8,'2016-12-31 15:37:37','2016-12-31 16:37:37',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (96,3,3,'2017-01-09 14:46:37','2017-01-09 15:46:37',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (97,57,2,'2017-01-09 14:47:21','2017-01-09 15:47:21',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (98,76,2,'2017-01-09 15:06:51','2017-01-09 16:06:51',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (99,92,3,'2017-01-16 11:32:54','2017-01-16 12:32:54',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (104,120,1,'2017-09-04 20:17:36','2017-09-04 22:17:36',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (105,119,1,'2017-09-04 20:17:36','2017-09-04 22:17:36',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (108,122,1,'2017-11-05 12:47:52','2017-11-05 13:47:52',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (110,124,1,'2018-01-17 17:44:31','2018-01-17 18:44:31',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (112,126,1,'2018-01-17 17:47:42','2018-01-17 18:47:42',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (113,127,1,'2018-01-17 17:49:08','2018-01-17 18:49:08',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (114,128,1,'2018-01-17 17:50:50','2018-01-17 18:50:50',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (115,129,1,'2018-01-17 17:51:53','2018-01-17 18:51:53',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (116,130,1,'2018-01-17 17:53:32','2018-01-17 18:53:32',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (117,131,1,'2018-02-07 19:09:39','2018-02-07 20:09:39',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (118,132,1,'2018-02-07 19:11:26','2018-02-07 20:11:26',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (119,133,1,'2018-02-21 17:31:59','2018-02-21 18:31:59',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (120,134,1,'2018-02-21 17:33:19','2018-02-21 18:33:19',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (121,135,1,'2018-02-21 17:34:59','2018-02-21 18:34:59',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (122,136,1,'2018-02-21 17:36:57','2018-02-21 18:36:57',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (125,138,1,'2018-04-22 17:05:07','2018-04-22 19:05:07',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (126,139,1,'2018-04-22 17:06:58','2018-04-22 19:06:58',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (127,140,1,'2018-06-20 15:57:01','2018-06-20 17:57:01',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (129,141,1,'2018-06-25 15:04:40','2018-06-25 17:04:40',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (130,141,7,'2018-06-25 15:04:40','2018-06-25 17:04:40',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (131,142,1,'2018-11-28 17:21:08','2018-11-28 18:21:08',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (133,143,1,'2018-11-28 17:23:32','2018-11-28 18:23:32',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (134,1,3,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (135,32,7,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (136,51,9,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (137,51,8,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (138,51,3,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (139,52,2,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (140,52,9,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (141,134,7,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (142,81,2,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (143,78,2,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (146,144,1,'2019-01-16 17:03:41','2019-01-16 18:03:41',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (147,145,1,'2019-01-16 17:05:03','2019-01-16 18:05:03',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (149,2,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (150,8,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (151,9,3,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (152,4,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (153,7,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (154,5,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (155,32,3,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (156,121,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (157,72,7,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (158,123,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (159,48,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (160,42,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (161,74,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (162,50,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (163,77,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (164,51,7,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (165,49,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (166,71,2,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (167,19,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (168,61,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (169,41,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (170,53,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (171,38,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (172,35,6,NULL,NULL,NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (181,10,6,'2019-08-08 17:41:23','2019-08-08 19:41:23',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (182,12,6,'2019-08-08 17:41:36','2019-08-08 19:41:36',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (183,65,6,'2019-08-08 18:17:53','2019-08-08 20:17:53',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (185,3,6,'2019-08-11 00:19:10','2019-08-11 02:19:10',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (197,84,6,'2019-08-16 16:55:09','2019-08-16 18:55:09',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (233,165,1,'2019-08-17 16:24:35','2019-08-17 18:24:35',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (234,165,3,'2019-08-17 16:24:46','2019-08-17 18:24:46',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (237,166,1,'2019-08-17 16:45:13','2019-08-17 18:45:13',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (238,166,3,'2019-08-17 16:45:18','2019-08-17 18:45:18',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (241,166,9,'2019-08-17 16:45:57','2019-08-17 18:45:57',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (242,167,1,'2019-08-20 00:36:06','2019-08-20 02:36:06',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (243,168,1,'2019-08-20 01:14:52','2019-08-20 03:14:52',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (244,168,7,'2019-08-20 01:16:08','2019-08-20 03:16:08',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (245,93,6,'2019-09-24 05:49:25','2019-09-24 07:49:25',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (246,137,6,'2019-09-24 05:49:34','2019-09-24 07:49:34',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (247,148,6,'2019-09-24 05:49:56','2019-09-24 07:49:56',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (248,169,2,'2020-01-28 18:53:17','2020-01-28 19:53:17',NULL);
INSERT INTO persongroup(id, person_id, group_id, changed, created, deleted) VALUES (249,170,10,'2020-01-28 19:07:00','2020-01-28 20:07:00',NULL);

--
-- Dumping data for table relative
--
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (1,51,1,'RELATIONSHIP','RELATIONSHIP','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (2,4,5,'SIBLINGS','SIBLINGS','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (3,52,17,'PARENT','CHILD','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (4,8,9,'SIBLINGS','SIBLINGS','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (5,53,29,'PARENT','CHILD','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (6,35,55,'CHILD','PARENT','2015-08-31 20:26:16','2015-08-31 22:26:16','2018-01-04 14:21:10');
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (7,57,41,'PARENT','CHILD','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (8,58,41,'PARENT','CHILD','2015-08-31 20:26:16','2015-08-31 22:26:16',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (9,58,57,'RELATIONSHIP','RELATIONSHIP','2015-08-31 20:26:17','2015-08-31 22:26:17',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (10,60,30,'SIBLINGS','SIBLINGS','2015-08-31 20:26:17','2015-08-31 22:26:17',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (11,66,65,'CHILD','PARENT','2015-08-31 20:26:17','2015-08-31 22:26:17',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (12,68,67,'PARENT','CHILD','2015-08-31 20:26:17','2015-08-31 22:26:17',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (13,70,69,'PARENT','CHILD','2015-08-31 20:26:17','2015-08-31 22:26:17',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (14,71,61,'PARENT','CHILD','2015-08-31 20:26:17','2015-08-31 22:26:17',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (15,73,72,'PARENT','CHILD','2015-09-21 15:19:21','2015-09-21 17:19:21',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (16,76,75,'PARENT','CHILD','2016-01-27 17:22:31','2016-01-27 18:22:31',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (17,78,77,'PARENT','CHILD','2016-02-28 17:32:37','2016-02-28 18:32:37',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (19,87,83,'SIBLINGS','SIBLINGS','2016-04-13 17:15:19','2016-04-13 19:15:19',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (20,86,83,'SIBLINGS','SIBLINGS','2016-04-13 17:16:29','2016-04-13 19:16:29',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (22,90,91,'CHILD','PARENT','2016-05-04 15:06:59','2016-05-04 17:06:59',NULL);
INSERT INTO relative(id, person1, person2, TO_PERSON1_RELATION, TO_PERSON2_RELATION, changed, created, deleted) VALUES (23,50,3,'SIBLINGS','SIBLINGS','2016-05-10 06:45:57','2016-05-10 08:45:57',NULL);

--
-- Dumping data for table version
--

INSERT INTO version(id, version, deleted) VALUES (1,10,NULL);
