package group_9.Faircraft.Service;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import group_9.Faircraft.Model.User;
import group_9.Faircraft.repository.UserRepository;
import group_9.Faircraft.exception.ResourceNotFoundException;
import group_9.Faircraft.UserType;

@Service
public class UserService {
	
	@Autowired
	
	UserRepository userRepository;
	
	public UserService() {
		super();
		
	}

	//to register user to database
	public Optional<User> registerUser(String firstName, String lastName, String email, String password, UserType userType)
{
	User newUser= new User(firstName,lastName,email,password,userType);
	return Optional.ofNullable(userRepository.save(newUser));
}
	
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
				
	}
	
	public Optional<User> findByID(Long id)
	{
		return userRepository.findById(id);
		
	}

	public void deleteUser(Long id) {
		User userDelete= userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		userRepository.delete(userDelete);

	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}
