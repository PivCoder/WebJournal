package Repositoryes;

import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> fetchUsers();
    User updateUser(User user);
    void deleteUser(User user);
}
