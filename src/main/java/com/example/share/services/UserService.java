package com.example.share.services;

import com.example.share.exceptions.users.AuthorizationError;
import com.example.share.exceptions.users.RegistrationError;
import com.example.share.exceptions.users.TokenError;
import com.example.share.models.User;
import com.example.share.repositories.UserRepository;
import com.example.share.requests.users.AuthorizationRequest;
import com.example.share.requests.users.RegistrationRequest;
import com.example.share.responses.users.AuthorizationResponse;
import com.example.share.responses.users.RegistrationResponse;
import com.example.share.utils.PasswordUtil;
import com.example.share.utils.TokenUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordUtil passwordUtil;
    private final TokenUtil tokenUtil;

    public UserService(UserRepository userRepository, PasswordUtil passwordUtil, TokenUtil tokenUtil) {
        this.userRepository = userRepository;
        this.passwordUtil = passwordUtil;
        this.tokenUtil = tokenUtil;
    }

    public RegistrationResponse registrationUser(RegistrationRequest data){
        userRepository.findByEmail(data.email()).ifPresent(action->{
            throw new RegistrationError("Невалидная почта");
        });

        User newUser = new User(data, passwordUtil.hashPassword(data.password()));
        userRepository.save(newUser);

        return new RegistrationResponse(true, "Регистрация прошла успешно");
    }

    public AuthorizationResponse authorizationUser(AuthorizationRequest data){
        User user = userRepository.findByEmail(data.email()).orElseThrow(AuthorizationError::new);

        if (!passwordUtil.checkPassword(data.password(), user.getPassword())){
            throw new AuthorizationError();
        }
        String token = tokenUtil.generationToken(user.getName());
        user.setToken(token);
        userRepository.save(user);
        return new AuthorizationResponse(true, "Успешно", token);
    }

    public boolean logoutUser(String token){
        User user = validateRequestToken(token);
        user.setToken(null);
        userRepository.save(user);
        return true;
    }

    public User validateRequestToken(String token){
       return userRepository.findByToken(tokenUtil.prepareToken(token)).orElseThrow(TokenError::new);
    }
}
