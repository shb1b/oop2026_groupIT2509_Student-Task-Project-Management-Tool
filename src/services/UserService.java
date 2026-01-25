package services;

import entities.User;
import repositories.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void showUsers() {
        for (User user : userRepository.getAllUsers()) {
            System.out.println(
                    "User: " + user.getName() + ", email: " + user.getEmail()
            );
        }
    }
}
