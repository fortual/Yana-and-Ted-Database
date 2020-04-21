import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/InitServlet") // This is the URL of the servlet.
public class InitServlet extends HttpServlet {

	static Connection currentCon = null;
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Statement stmt = null;
		currentCon = ConnectionManager.getConnection();
		
		try {
			stmt = currentCon.createStatement();
			
			// Dropping tables
			stmt.executeUpdate("DROP TABLE IF EXISTS Users, Comedians, YoutubeVideos, Reviews, YoutubeTags, IsFavorite");

			// Table Creation
			stmt.executeUpdate("CREATE TABLE Users (email VARCHAR(50),pass VARCHAR(50),firstname VARCHAR(50),lastname VARCHAR(50),gender CHAR(1),age INTEGER,PRIMARY KEY(email));");
			stmt.executeUpdate("CREATE TABLE Comedians (comid INTEGER NOT NULL AUTO_INCREMENT,firstname VARCHAR(50),lastname VARCHAR(50),birthday DATE,birthplace VARCHAR(50),PRIMARY KEY(comid));");
			stmt.executeUpdate("CREATE TABLE YoutubeVideos (url VARCHAR(150),title VARCHAR(50),descrip VARCHAR(200),comid INTEGER NOT NULL,postuser VARCHAR(50) NOT NULL,postdate DATE,PRIMARY KEY(url),FOREIGN KEY(comid) REFERENCES Comedians(comid),FOREIGN KEY(postuser) REFERENCES Users(email));");
			stmt.executeUpdate("CREATE TABLE Reviews (reviewid INTEGER NOT NULL AUTO_INCREMENT,remark VARCHAR(100),rating CHAR(1),author VARCHAR(50) NOT NULL,youtubeid VARCHAR(150) NOT NULL,PRIMARY KEY(reviewid),FOREIGN KEY(author) REFERENCES Users(email),FOREIGN KEY(youtubeid) REFERENCES YoutubeVideos(url),CONSTRAINT ratingck CHECK (rating='P' OR rating='F' OR rating='G' OR rating='E'));");
			stmt.executeUpdate("CREATE TABLE `youtubetags` (`url` varchar(150) NOT NULL,`tag` varchar(50) NOT NULL,`email` VARCHAR(50),PRIMARY KEY (`url`,`tag`));");
			stmt.executeUpdate("CREATE TABLE IsFavorite(email VARCHAR(50),comid INTEGER,PRIMARY KEY(email, comid),FOREIGN KEY(email) REFERENCES Users(email),FOREIGN KEY(comid) REFERENCES Comedians(comid));");
			
			// Default Users
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('tjsase@gmail.com', 'pass1234', 'Ted', 'Sase', 'm', '22');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('db@talkingheads.com', 'db1234', 'David', 'Byrne', 'm', '67');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('weymouth@talkingheads.com', 'lorelei', 'Tina', 'Weymouth', 'f', '69');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('france@talkingheads.com', 'JAMES_BROWN', 'Chris', 'Frantz', 'm', '68');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('harry@talkingheads.com', 'ModernLovers', 'Jerry', 'Harrison', 'm', '71');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('freddy@theb52s.com', 'CaveofUnknown', 'Fred', 'Schneider', 'm', '68');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('cathy@theb52s.com', 'Tomatoes', 'Kate', 'Pierson', 'f', '71');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('cindy@theb52s.com', 'ChineseNoodles', 'Cindy', 'Wilson', 'f', '63');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('ricky@theb52s.com', 'HotTamales', 'Ricky', 'Wilson', 'm', '32');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`users` (`email`, `pass`, `firstname`, `lastname`, `gender`, `age`) VALUES ('keith@theb52s.com', 'EssencefromWithin', 'Keith', 'Strickland', 'm', '66');\r\n");
			
			// Default Comedians
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Hannibal', 'Buress', '1987-2-4', 'Chicago, IL');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Eric', 'Andre', '1987-4-4', 'Boca Raton, FL');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Tim', 'Heidecker', '1976-2-3', 'Allentown, PA');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Eric', 'Wareheim', '1976-4-7', 'Audubon, PA');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Matt', 'Weinhold', '1970-1-1', 'N/A');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('John', 'Mulaney', '1982-8-26', 'Chicago, IL');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Patton', 'Oswalt', '1969-1-27', 'Chicago, IL');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('John', 'Oliver', '1977-4-27', 'Erdington, Birmingham, England');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Bo', 'Burnham', '1990-8-21', 'Hamilton, MA');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`comedians` (`firstname`, `lastname`, `birthday`, `birthplace`) VALUES ('Jim', 'Carrey', '1962-1-17', 'Newmarket, ON');");
			
			// Default videos
			// Today's date
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=uQecHQfy8eQ', 'A Car Accident Is a Real Mood Killer', 'Hannibal Buress remembers getting his hat stolen by a very confident thief and getting into a car accident on his birthday. ', '1', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=xlonY2l3V9c', 'Jaywalking Is a Fantasy Crime', 'Hannibal Buress talks about getting a ticket for jaywalking in Montreal and wonders at the absurdities of airport security in his special Animal Furnace. ', '1', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=y3kGVty0dyg', 'Gangsters Ask Questions', '#HannibalBuress on racist porn comments, having too much pickle juice, and his problem with #LilWayne. ', '1', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=hHUNPS0BzYc', 'Your Prayers Mean Nothing', '#HannibalBuress on how much he hates his teenage cousin, not putting a napkin on his lap at restaurants, and why he doesnt want your prayers. ', '1', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=K8y-BA_gisw', 'Live From Amsterdam | Dead Parrot', 'Full Performance from Hannibal Buress. ', '1', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=quZU_hA4Pr4', 'Canceling Plans Is Like Heroin', 'getting his hat stolen by a very confident thief and getting into a car accident on his birthday. ', '6', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=BNlyZSvsNjw', 'Accidentally Got a Prostate Exam', 'As someone who’s always anxious, John Mulaney once tried to get a Xanax prescription from his doctor, only for his plan to go horribly awry. ', '6', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=F1sd4CRcaE0', 'Ice-T on SVU & Old Murder Investigations', 'John Mulaney isnt sure why Ice-T is always shocked in every episode of Law & Order: SVU after 11 years of working in the sex crimes department. ', '6', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=jRLH8E_CpP0', 'John Mulaney Monologue - SNL', 'John Mulaney does stand-up about hosting the first Saturday Night Live on Leap Year Day, having a baby boomer dad with no friends and his Make-A-Wish experience.', '6', 'tjsase@gmail.com', '" + date + "');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubevideos` (`url`, `title`, `descrip`, `comid`, `postuser`, `postdate`) VALUES ('https://www.youtube.com/watch?v=Mw7Gryt-rcc', 'What’s New Pussycat? 21 Times on a Diner Jukebox', 'John Mulaney recalls he and a friend pranking an entire Chicago diner by playing Tom Joness What’s New Pussycat? on the jukebox 21 times in a row.', '6', 'tjsase@gmail.com', '" + date + "');");
			
			// Default tags
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=uQecHQfy8eQ', 'Accident';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=xlonY2l3V9c', 'Jaywalking';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=y3kGVty0dyg', 'Gangsters';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=hHUNPS0BzYc', 'Prayers';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=K8y-BA_gisw', 'Amsterdam';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=quZU_hA4Pr4', 'Canceling';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=BNlyZSvsNjw', 'Prostate';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=F1sd4CRcaE0', 'SVU';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=jRLH8E_CpP0', 'SNL';");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`youtubetags` (`url`, `tag`) VALUES ('https://www.youtube.com/watch?v=Mw7Gryt-rcc', 'Jukebox';");
			
			// Default reviews
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('funny', 'g', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=uQecHQfy8eQ');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('lol', 'e', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=xlonY2l3V9c');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('wtf', 'f', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=y3kGVty0dyg');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('This is great!!', 'e', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=hHUNPS0BzYc');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('haha', 'g', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=K8y-BA_gisw');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('wow', 'f', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=quZU_hA4Pr4');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('silly', 'f', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=BNlyZSvsNjw');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('Heyo!', 'e', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=F1sd4CRcaE0');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('Huh?', 'g', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=jRLH8E_CpP0');\r\n");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`reviews` (`remark`, `rating`, `author`, `youtubeid`) VALUES ('Classic stuff', 'f', 'tjsase@gmail.com', 'https://www.youtube.com/watch?v=Mw7Gryt-rcc');\r\n");

			// Default favorites
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '1');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '2');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '3');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '4');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '5');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '6');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '7');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '8');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '9');");
			stmt.executeUpdate("INSERT INTO `ytcomedy`.`isfavorite` (`email`, `comid`) VALUES ('tjsase@gmail.com', '10');");
			
			stmt.executeUpdate("GRANT SELECT ON `ytcomedy`.`youtubevideos` TO 'usersearch'@'localhost';");
			stmt.executeUpdate("GRANT SELECT ON `ytcomedy`.`comedians` TO 'usersearch'@'localhost';");
			stmt.executeUpdate("GRANT SELECT ON `ytcomedy`.`isfavorite` TO 'usersearch'@'localhost';");
			stmt.executeUpdate("GRANT SELECT ON `ytcomedy`.`reviews` TO 'usersearch'@'localhost';");
			stmt.executeUpdate("GRANT SELECT ON `ytcomedy`.`youtubetags` TO 'usersearch'@'localhost';");
			
			stmt.close();
			currentCon.close();
			response.sendRedirect("Index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (currentCon != null)
				try {
					currentCon.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			response.sendRedirect("invalidLogin.jsp");
		}
	}
}