public class ComedianBean {

	private String firstName;
	private String lastName;
	java.sql.Date birthday;
	private String birthplace;
	public boolean valid = false;

	public ComedianBean() {
		
	}
	
	public ComedianBean(String newNameF, String newNameL, java.sql.Date newDay, String newPlace) {
		
		firstName = newNameF;
		lastName = newNameL;
		birthday = newDay;
		birthplace = newPlace;
		
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