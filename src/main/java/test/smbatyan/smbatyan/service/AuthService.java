package test.smbatyan.smbatyan.service;

import test.smbatyan.smbatyan.model.User;
import test.smbatyan.smbatyan.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String username, String password) {
        User user = new User();
        user.setUser(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}