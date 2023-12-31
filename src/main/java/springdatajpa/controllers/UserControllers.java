package springdatajpa.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springdatajpa.ErrorResponse.ErrorEntity;
import springdatajpa.ErrorResponse.SuccessResponse;
import springdatajpa.dto.UserDto;
import springdatajpa.model.Mobile;
import springdatajpa.model.User;
import springdatajpa.service.MobileService;
import springdatajpa.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api")
@CrossOrigin("*")
public class UserControllers {

    private final UserService userService;
    private final MobileService mobileService;

    public UserControllers(UserService userService, MobileService mobileService) {
        this.userService = userService;
        this.mobileService = mobileService;
    }
    @PostMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody  @Valid UserDto userDto) {
            UserDto newUser = userService.createUser(userDto);
            Map<String, String> success = new HashMap<>();
            success.put("message", "User created successfully");
            success.put("status", "201");
            return new ResponseEntity<>(new SuccessResponse("User created successfully", success, newUser), HttpStatus.CREATED);
    }

    @PostMapping("addUserToMobile/user/{userId}/mobiles/{mobileId}")
    public ResponseEntity<?> addUserToMobile(@PathVariable Long mobileId, @PathVariable Long userId) {
        Mobile mobile = mobileService.getMobile(mobileId);
        UserDto userDto = userService.getUser(userId);
        if (mobile != null && userDto != null) {
            userDto.getMobiles().add(mobile);
            userService.createUser(userDto);
            return ResponseEntity.ok("Mobile assigned to the user successfully");
//            System.out.println("user -> "+ user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "getUsers")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.getUsers();
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}


//    @PostMapping("create-user")
//    public ResponseEntity<?> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            bindingResult.getFieldErrors().forEach(error ->
//                    errors.put(error.getField(), error.getDefaultMessage()));
//            return new ResponseEntity<>(new ErrorEntity("Validation failed", errors), HttpStatus.BAD_REQUEST);
//        } else {
//            User newUser = userService.createUser(user);
//            public ResponseEntity<?> createUser(@RequestBody  @Valid UserDto userDto) {
//                UserDto newUser = userService.createUser(userDto);
//                Map<String, String> success = new HashMap<>();
//                success.put("message", "User created successfully");
//                success.put("status", "201");
//                return new ResponseEntity<>(new SuccessResponse("User created successfully", success, newUser), HttpStatus.CREATED);
//            }
//        }