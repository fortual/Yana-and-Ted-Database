
public class ComedianBean {

	private String firstName;
	private String lastName;
	java.sql.Date birthday;
	private String birthplace;
	int comid;
	public boolean valid = false;

	public ComedianBean() {
		
	}
	
	public ComedianBean(String newNameF, String newNameL, java.sql.Date newBirthday, String newBirthplace, int newId) {
		birthday = newBirthday;
		birthplace = newBirthplace;
		firstName = newNameF;
		lastName = newNameL;
		comid = newId;
		
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
	
	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date newDay) {
		birthday = newDay;	
	}
	
	public String getBirthplace() {
		return birthplace;
	}
	
	public void setBirthplace(String newPlace) {
		birthplace = newPlace;

	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
}