CREATE TABLE Users (
	email VARCHAR(50),
	pass VARCHAR(50),
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	gender CHAR(1),
	age INTEGER,
	PRIMARY KEY(email));

CREATE TABLE Comedians (
	comid INTEGER,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	birthday DATE,
	birthplace VARCHAR(50),
	PRIMARY KEY(comid));

CREATE TABLE YoutubeVideos (
	url VARCHAR(150),
	title VARCHAR(50),
	descrip VARCHAR(200),
	comid INTEGER NOT NULL,
	postuser VARCHAR(50) NOT NULL,
	postdate DATE,
	PRIMARY KEY(url),
	FOREIGN KEY(comid) REFERENCES Comedians(comid),
	FOREIGN KEY(postuser) REFERENCES Users(email));
	
	
CREATE TABLE Reviews (
	reviewid INTEGER NOT NULL AUTO_INCREMENT,
	remark VARCHAR(100),
	rating CHAR(1), -- P.F.G.E
	author VARCHAR(50) NOT NULL,
	youtubeid VARCHAR(150) NOT NULL,
	PRIMARY KEY(reviewid),
	FOREIGN KEY(author) REFERENCES Users(email),
	FOREIGN KEY(youtubeid) REFERENCES YoutubeVideos(url),
	CONSTRAINT ratingck CHECK (rating='P' OR rating='F' OR rating='G' OR rating='E'));
	
CREATE TABLE YoutubeTags(
	url VARCHAR(150),
	tag VARCHAR(50),
	PRIMARY KEY(url, tag));
	
CREATE TABLE IsFavorite(
	email VARCHAR(50),
	comid INTEGER,
	PRIMARY KEY(email, comid),
	FOREIGN KEY(email) REFERENCES Users(email),
	FOREIGN KEY(comid) REFERENCES Comedians(comid));