DROP DATABASE IF EXISTS springormtodo;
CREATE DATABASE springormtodo; 
USE springormtodo;

DROP TABLE IF EXISTS todo;


CREATE TABLE IF NOT EXISTS todo (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  task varchar(100) not NULL,
  description varchar(255) DEFAULT NULL,
  done boolean DEFAULT false,
  insert_time datetime,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO todo (id, task, description, done, insert_time) VALUES
	(1, 'Go Gym', 'Cycling, Puchups', false, NOW()),
	(2, 'Groceries', 'Bread, Chocolate', false, NOW()),
	(3, 'Homework', 'Java, Python', true, NOW());
commit;