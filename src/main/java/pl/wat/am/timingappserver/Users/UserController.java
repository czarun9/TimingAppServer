package pl.wat.am.timingappserver.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addLesson(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/users/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
