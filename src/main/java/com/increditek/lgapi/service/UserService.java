package com.increditek.lgapi.service;

import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.exception.ItemNotFoundException;
import com.increditek.lgapi.repository.SearchCriteria;
import com.increditek.lgapi.repository.UserRepository;
import com.increditek.lgapi.repository.UserSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Page<User> findAll(Optional<Boolean> isDeleted, int page, int pageSize) {
        return isDeleted.isPresent() ? userRepository.findAllByIsDeleted(isDeleted.get(), PageRequest.of(page, pageSize)) : userRepository.findAll(PageRequest.of(page, pageSize));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find User with id: " + id));
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(()-> new ItemNotFoundException("Count not find User with userName: " + userName));
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmailAndIsDeleted(email, false);
    }

    public List<String> findEmailByNotificationSubscription(String notificationSubscription) {
        UserSpecification us1 = new UserSpecification(new SearchCriteria("", "isDeleted", ":", false));
        UserSpecification us2 = new UserSpecification(new SearchCriteria("userNotifications", notificationSubscription, ":", true));

        return userRepository.findAll(Specification.where(us1).and(us2)).stream().map(u -> u.getEmail()).collect(Collectors.toList());
    }
}
