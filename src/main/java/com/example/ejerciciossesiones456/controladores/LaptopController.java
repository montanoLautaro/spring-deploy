package com.example.ejerciciossesiones456.controladores;

import com.example.ejerciciossesiones456.entidades.Laptop;
import com.example.ejerciciossesiones456.repositorios.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public ResponseEntity<List<Laptop>> findAll(){
        List<Laptop> laptops = laptopRepository.findAll();
        if(laptops.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(laptops);
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            Laptop resultado = laptopRepository.save(laptop);
            return ResponseEntity.ok(resultado);
        }
        log.warn("Intentando crear una Laptop con un id ya existente");
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        if(id != null){
            Optional<Laptop> laptopOptional = laptopRepository.findById(id);
            if(laptopOptional.isPresent()){
                return ResponseEntity.ok(laptopOptional.get());
            }
        }
        log.warn("No se encontró una laptop con ese ID");
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() != null ){
            if(laptopRepository.existsById(laptop.getId())){
                Laptop resultado = laptopRepository.save(laptop);
                return ResponseEntity.ok(resultado);
            }else {
                log.warn("Intentando actualizar una laptop no existente");
                return ResponseEntity.notFound().build();
            }
        }
        log.warn("Intentando actualizar una laptop no existente");
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(id != null){
            if(laptopRepository.existsById(id)){
                laptopRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }else {
                log.warn("Intentando eliminar una laptop que no existe");
                return ResponseEntity.notFound().build();
            }
        }
        log.warn("Intentando eliminar una laptop que no existe");
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request para eliminar todas las laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
