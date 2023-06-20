//package ru.skypro.lessons.springboot.myemployeeweblibrary.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.AuthUser;
//import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.UserRepository;
//@Service
//public class SecurityUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//
//    public UserDetails loadUserByUsername(String username) {
//        AuthUser user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//
//        return new SecurityUserPrincipal(user);
//    }
//}