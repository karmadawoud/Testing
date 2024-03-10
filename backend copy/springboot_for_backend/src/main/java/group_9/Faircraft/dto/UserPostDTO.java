package group_9.Faircraft.dto;


import group_9.Faircraft.UserType;

public class UserPostDTO {
	String firstName;
	String lastName;
	String email;
	String password;
	UserType userType;

	public UserPostDTO(String firstName,
						String lastName,
					String email,
					String password,
					Boolean buyer, 
					Boolean middleman) 
	{
		super();
		this.firstName= firstName;
		this.lastName= lastName;
		this.email=email;
		this.password=password;
		this.userType= convertType(buyer,middleman);
		
	}

	public UserType convertType(Boolean buyer, Boolean middleman) {
        if (buyer != null && buyer && (middleman == null || !middleman)) {
            return UserType.BUYER;
        } else if (middleman != null && middleman && (buyer == null || !buyer)) {
            return UserType.MIDDLEMAN;
        } else {
            return UserType.NONE;
        }
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
