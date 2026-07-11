package org.example.repository;

import org.example.model.GuestsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestsListRepository extends JpaRepository<GuestsList, Long> {
}
