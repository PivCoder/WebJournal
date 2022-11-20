package Repositoryes;

import lombok.RequiredArgsConstructor;
import model.User;
import model.UserType;
import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailabilityBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService{

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public UserType saveUserType(UserType userType) {
        System.out.println(userTypeRepository);
        return userTypeRepository.save(userType);
    }

    @Override
    public List<UserType> fetchUsersType() {
        return (List<UserType>) userTypeRepository.findAll();
    }

    @Override
    public UserType updateUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    @Override
    public void deleteUserType(UserType userType) {
        userTypeRepository.delete(userType);
    }
}
