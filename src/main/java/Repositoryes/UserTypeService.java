package Repositoryes;

import model.UserType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserTypeService {
    UserType saveUserType(UserType userType);

    List<UserType> fetchUsersType();

    UserType updateUserType(UserType userType);

    void deleteUserType(UserType userType);
}
