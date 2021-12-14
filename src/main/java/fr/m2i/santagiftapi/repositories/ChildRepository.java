package fr.m2i.santagiftapi.repositories;

import fr.m2i.santagiftapi.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
