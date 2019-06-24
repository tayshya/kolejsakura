CREATE database sakura_event;

Use sakura_event;

DROP TABLE if exists event;
CREATE TABLE event(

eventid int NOT NULL AUTO_INCREMENT,
eventname VARCHAR(100),
eventdesc VARCHAR(300),

PRIMARY KEY(eventid)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
categoryid int NOT NULL AUTO_INCREMENT,
categorytype VARCHAR(30),

PRIMARY KEY(categoryid)
);

DROP TABLE IF EXISTS participant;
CREATE TABLE participant(
partid int NOT NULL AUTO_INCREMENT,
part_No	int,

PRIMARY KEY(partid)
);


