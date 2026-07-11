package org.example.service;

import org.example.model.Guest;
import org.example.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    UserService userService;


}
