package com.eci.arep.arep_taller05.repository;

import com.eci.arep.arep_taller05.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
