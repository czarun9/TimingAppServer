package pl.wat.am.timingappserver.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}