package group_9.Faircraft.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group_9.Faircraft.UserType;
import group_9.Faircraft.Model.User;
import group_9.Faircraft.Service.UserService;
import group_9.Faircraft.dto.UserPostDTO;

//register 
@RestController
public class UserController{
	@Autowired
	UserService userService;
	
	//get user(all)
	@GetMapping("/user")
	public List<User> getUsers(){
		return userService.getUsers();
		
	}
	
	@PostMapping("/add/user")
	public ResponseEntity<Optional<User>> registerUser(@RequestBody UserPostDTO newUserDTO){
		if(newUserDTO.getFirstName()==null ||
			newUserDTO.getLastName()==null ||
				newUserDTO.getEmail()==null ||
				newUserDTO.getPassword()==null ||
				newUserDTO.getUserType()==UserType.NONE) {
			return new ResponseEntity<>(Optional.ofNullable(null),HttpStatus.BAD_REQUEST);
		}
		
		Optional<User> registeredUser = userService.registerUser(
								newUserDTO.getFirstName(),
								newUserDTO.getLastName(),
								newUserDTO.getEmail(), 
								newUserDTO.getPassword(),
								newUserDTO.getUserType() );
		
		return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);



		//add passcode later 
	}
	
	//get user by id
	@GetMapping("user/{id}")
	public Optional<User> getUserById(@PathVariable(value="id")long Id){
		return userService.findByID(Id);
		
	}
	
	//delete user by id
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable(value="id")long Id) {
		userService.deleteUser(Id);
		return "user deleted";
	}
	
	//get user by email 
	@GetMapping("/user/findByEmail")
	public Optional<User> getUserByEmail(@RequestParam String email){
		return Optional.ofNullable(userService.findByEmail(email));
	}
	
	
	
	
	

}