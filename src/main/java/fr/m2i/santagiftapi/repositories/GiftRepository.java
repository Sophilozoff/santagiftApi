package fr.m2i.santagiftapi.repositories;

import fr.m2i.santagiftapi.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long> {
}
