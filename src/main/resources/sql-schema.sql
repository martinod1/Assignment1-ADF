SET FOREIGN_KEY_CHECKS=0;
drop table Image;
drop table ChObject;
drop table object_image;
drop table participation;
drop table participant;
drop table role;


CREATE TABLE ChObject(
	id INT primary key AUTO_INCREMENT,
	object_id INT(11) UNIQUE NOT NULL,
	title VARCHAR(255) NOT NULL,
	date VARCHAR(255) NOT NULL,
	medium VARCHAR(255) NOT NULL,
	creditline VARCHAR(255) NOT  NULL,
	description VARCHAR(800) NULL,
	gallery_text VARCHAR(1500) NULL
);

create table Image (
	id INT primary key AUTO_INCREMENT, 
	image_id INT(11) NOT NULL,
	url VARCHAR(255)  NOT  NULL,
	keyVal VARCHAR(255)  NOT NULL,
	width INT  NOT NULL,
	height INT NULL,
	is_primary INT NOT NULL,
	object_id INT NOT NULL,
	key image(image_id)
);

create table participation(
	participation_id INT primary key AUTO_INCREMENT,
	chobject_id INT,
	participant_id INT, 
	role_id INT
	);
create table participant(
	person_id INT primary key,
	person_name VARCHAR (255),
	person_date VARCHAR(255),
	person_url VARCHAR(255)
);

create table role(
	role_id INT primary key,
	role_name VARCHAR (255),
	role_display_name VARCHAR(255),
	role_url VARCHAR(255)
);



alter table participation add CONSTRAINT fk_participant FOREIGN KEY (participant_id) REFERENCES participant(person_id);
alter table participation add CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role(role_id);

SET FOREIGN_KEY_CHECKS=1;



*/