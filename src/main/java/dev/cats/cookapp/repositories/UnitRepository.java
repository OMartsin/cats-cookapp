package dev.cats.cookapp.repositories;

import dev.cats.cookapp.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Optional<Unit> findByName(String name);
}