package group_9.Faircraft.Controller;

import group_9.Faircraft.repository.UserRepository;
import group_9.Faircraft.Model.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;

import java.util.Map;


//import org.apache.catalina.User; spring boot security and managing user sessions 



//login 
@RestController
@RequestMapping("/api")
public class AuthController{
    
    @Autowired
    private UserRepository userRepository;
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
     
    String email = credentials.get("email");
     String password = credentials.get("password");

        User user = userRepository.findByEmail(email);

        if (email != null && user.getPassword().equals(password)) {

            String token = generateToken(email);
            return ResponseEntity.ok().body(Map.of("token", token));
            
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    private String generateToken(String email) {
        return "generated_token_here";
    }
}


