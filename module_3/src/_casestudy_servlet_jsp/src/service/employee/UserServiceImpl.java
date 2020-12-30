package service.employee;

import model.employee.User;
import repository.employee.UserRepository;
import repository.employee.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
}