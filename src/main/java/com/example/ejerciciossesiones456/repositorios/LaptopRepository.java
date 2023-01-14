package com.example.ejerciciossesiones456.repositorios;

import com.example.ejerciciossesiones456.entidades.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
