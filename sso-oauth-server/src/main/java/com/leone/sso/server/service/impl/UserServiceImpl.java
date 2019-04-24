package com.leone.sso.server.service.impl;

import com.leone.sso.server.pojo.MyUserDetails;
import com.leone.sso.server.pojo.User;
import com.leone.sso.server.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * <p> 
 *
 * @author leone
 * @since 2019-04-24
 **/
@Primary
@Service
public class UserServiceImpl implements UserService {
 
    private final static Set<User> users = new HashSet<>();
 
    static {
        users.add(new User(1, "user1", "123451"));
        users.add(new User(2, "user2", "123452"));
        users.add(new User(3, "user3", "123453"));
        users.add(new User(4, "user4", "123454"));
    }
 
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = users.stream().filter((u) -> u.getUsername().equals(s)).findFirst();
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("there's no user founded!");
        } else {
            return UserDetailConverter.convert(user.get());
        }
    }
 
    private static class UserDetailConverter {
        static UserDetails convert(User user) {
            return new MyUserDetails(user);
        }
    }
}
