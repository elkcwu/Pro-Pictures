package com.kwu.propictures.service;

//import com.kwu.propictures.model.User;
////import com.kwu.propictures.repository.SecurityRepository;
//import com.kwu.propictures.repository.SecurityRepository;
//import com.kwu.propictures.security.SecurityUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;

//@Service
//public class SecurityUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    SecurityRepository secuRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = secuRepository.findByUsername(username);
//        user.orElseThrow(()-> new UsernameNotFoundException("Not found: " + username));
//        return user.map((SecurityUserDetails::new)).get();
//    }
//}
