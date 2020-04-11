import  java.sql.Date;
public class ComedianBean {

	private Date birthday;
	private String birthplace;
	private String firstName;
	private String lastName;
	private int comid;
	public boolean valid = false;

	public ComedianBean() {
		
	}
	
	public ComedianBean(String newNameF, String newNameL, Date newBirthday, String newBirthplace, int newId) {
		birthday = newBirthday;
		birthplace = newBirthplace;
		firstName = newNameF;
		lastName = newNameL;
		comid = newId;
		
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date newBirthday) {
		birthday = newBirthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String newBirthplace) {
		birthplace = newBirthplace;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	
	public int getComid() {
		return comid;
	}
	
	public void setComid(int newId) {
		comid = newId;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
}