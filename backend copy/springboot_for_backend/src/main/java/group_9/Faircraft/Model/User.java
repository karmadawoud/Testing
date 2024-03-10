package group_9.Faircraft.Model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import group_9.Faircraft.UserType;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="firstname")
	private String firstName;
	
	@NotBlank
	@Column(name="lastname")
	private String lastName;
	

	@NotBlank
	@Column(name="email")
	private String email;
	
	@NotBlank
	@Column(name="password")
	String password;
	
	UserType userType;
	
	// @Column(nullable = false, updatable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @CreatedDate
	// private Date createdAt;

	// @Column(nullable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @LastModifiedDate
	// private Date updatedAt;
	
	
	 public User() {
			super();
			
	}
		
	 
	 public User(String firstName,String lastName, String email, String password, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + firstName + lastName + ", email=" + email + ", password=" + password + ", userType="
				+ userType + "]";
	}
	
	
}
