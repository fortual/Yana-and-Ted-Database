import  java.sql.Date;
public class VideoBean {

	private String url;
	private String title;
	private String descrip;
	private int comid;
	private String postuser;
	private Date postdate;
	public boolean valid = false;

	public VideoBean() {}
	
	public VideoBean(String newUrl, String newTitle, String newDescrip, int newid, String newUser, Date newDate) {
		url = newUrl;
		descrip = newDescrip;
		comid = newid;
		postuser = newUser;
		postdate = newDate;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescrip() {
		return descrip;
	}
	
	public int getComid() {
		return comid;
	}
	
	public String getPostUser() {
		return postuser;
	}
	
	public Date getDate() {
		return postdate;
	}
	
	
	public void setUrl(String newUrl) {
		url = newUrl;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public void setDescrip(String newDescrip) {
		descrip = newDescrip;
	}

	public void setComid(int newid) {
		comid = newid;
	}

	public void setUser(String newUser) {
		postuser = newUser;
	}

	public void setDate(Date newDate) {
		postdate = newDate;
	}

	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

}