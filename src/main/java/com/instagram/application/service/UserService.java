package com.instagram.application.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instagram.application.dto.UserDto;
import com.instagram.application.exceptions.ResourceAlreadyExistsException;
import com.instagram.application.repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
       this.userRepository = userRepository;
       this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
        
        List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());
        
        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());

        return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
    }
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        var userFromDb = userRepository.findByUsername(s)
//                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
//        
//        List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());
//        
//        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());
//
//        return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
//    }
    public void addUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getEmail()).isEmpty()) {

            var userEntity = new com.instagram.application.model.User();
            BeanUtils.copyProperties(userDto, userEntity);
            userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

            List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());
            
            authorities.add((GrantedAuthority) () -> userDto.getRole().name());

            userRepository.save(userEntity);

        } else {
            throw new ResourceAlreadyExistsException("email is unavailable...");
        }
    }
//
//    public void deleteUser(Long userId) {
//        userRepository.deleteById(userId); 
//    }
  public void update(com.instagram.application.model.User userObj) {
	  userRepository.save(userObj); 
  }
  public Optional<com.instagram.application.model.User> getUserByUserId(Long id) {
	  return userRepository.findById(id); 
  }

    
    
}
