package com.increditek.lgapi.controller;

import com.increditek.lgapi.domain.PageableResponse;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getUsers(HttpServletRequest request,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "100") int pageSize,
                                     @RequestParam Optional<Boolean> isDeleted) {
        return new PageableResponse("lgapi/user", userService.findAll(isDeleted, page, pageSize), request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/get-by-username")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUserName(@RequestParam String userName) {
        return userService.findByUserName(userName);
    }

    @GetMapping("/get-by-email")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/get-by-subscription")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getUserEmailByNotficationSubscription(@RequestParam String notificationSubscription) {
        return userService.findEmailByNotificationSubscription(notificationSubscription);
    }
}
