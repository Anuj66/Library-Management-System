package com.lms.demo.security.services;

import com.lms.demo.exceptionHandler.ObjectDoNotExists;
import com.lms.demo.model.User;
import com.lms.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws ObjectDoNotExists {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectDoNotExists("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
