package com.ganzymalgwi.completeuserregistration.user;

import com.ganzymalgwi.completeuserregistration.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);
}
