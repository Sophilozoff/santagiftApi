package fr.m2i.santagiftapi.repositories;

import fr.m2i.santagiftapi.enums.ERole;
import fr.m2i.santagiftapi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
