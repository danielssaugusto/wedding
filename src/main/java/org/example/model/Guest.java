package org.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

/* * Status
* Attending
* Not Attending
* Pending
* Declined
* */

@Entity
@Setter
@Getter
@DiscriminatorValue("GUEST")
public class Guest extends User {
    @Enumerated(EnumType.STRING)
    private RSVPStatus status;

    public Guest() {
        super(null, null, null, null);
    }


    public Guest(Long id, String fullName, String email, String password) {
        super(id, fullName, email, password);
    }

    @Override
    public Role getRole() {
        return Role.GUEST;
    }
}
