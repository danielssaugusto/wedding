package org.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@DiscriminatorValue("PROFESSIONAL")
public class Professional extends User {
    private String jobTitle;

    public Professional(Long id, String fullName, String email, String password, String jobTitle) {
        super(id, fullName, email, password);
        this.jobTitle = jobTitle;
    }

    @Override
    public Role getRole() {
        return Role.PROFESSIONAL;
    };

}
