package edu.fiu.group24.group_24_project.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(201).body(userRepository.save(user));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return userRepository.findById(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{username}")
    public ResponseEntity<?> patchUser(@PathVariable String username, @RequestBody Map<String, Object> updates) {


        if (updates.containsKey("userEmail") || updates.containsKey("email")) {
            return ResponseEntity.badRequest().body("Email cannot be changed.");
        }

        return userRepository.findById(username).map(user -> {
            if (updates.containsKey("userPassword")) user.setUserPassword((String) updates.get("userPassword"));
            if (updates.containsKey("userFirstName")) user.setUserFirstName((String) updates.get("userFirstName"));
            if (updates.containsKey("userLastName")) user.setUserLastName((String) updates.get("userLastName"));
            if (updates.containsKey("userHomeAddress")) user.setUserHomeAddress((String) updates.get("userHomeAddress"));

            userRepository.save(user);
            return ResponseEntity.ok(user);
        }).orElse(ResponseEntity.notFound().build());
    }
}
