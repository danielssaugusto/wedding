package org.example.service;

import org.example.model.Guest;
import org.example.model.GuestsList;
import org.example.repository.AdminRepository;
import org.example.repository.GuestRepository;
import org.example.repository.GuestsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private GuestsListRepository guestsListRepository;

    @Autowired
    private GuestRepository guestRepository;



    public GuestsList createList(String listName, List<Long> idsGuests) {
        GuestsList list = new GuestsList();
        list.setListName(listName);

        List<Guest> guests = guestRepository.findAllById(idsGuests);
        list.setGuests(guests);

        return guestsListRepository.save(list);
    }
}
