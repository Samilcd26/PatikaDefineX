package com.Hafta1.Hafta1Uygulama.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Hafta1.Hafta1Uygulama.model.Entities;
import com.Hafta1.Hafta1Uygulama.repository.EntityRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/v1")
public class TutorialController {

    @Autowired
    EntityRepository entityRepository;

    //All Entities
    @GetMapping("/tutorials")
    public ResponseEntity<List<Entities>> getAllEntites(@RequestParam(required = false) String title) {
        try {
            List<Entities> entities = new ArrayList<Entities>();

            if (title == null)
                entityRepository.findAll().forEach(entities::add);
            else
                entityRepository.findByTypeContaining(title).forEach(entities::add);

            if (entities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(entities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Find by id
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Entities> getEntityById(@PathVariable("id") long id) {
        Optional<Entities> entityData = entityRepository.findById(id);

        if (entityData.isPresent()) {
            return new ResponseEntity<>(entityData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Create entity
    @PostMapping("/addentities")
    public ResponseEntity<Entities> createEntity(@RequestBody Entities entities) {
        try {
            Entities _entities = entityRepository
                    .save(new Entities(entities.getId(),entities.getType(), entities.getArea(),entities.getPrice(), entities.getRooms()));
            return new ResponseEntity<>(_entities, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Entities> updateTutorial(@PathVariable("id") long id, @RequestBody Entities entities) {
        Optional<Entities> tutorialData = entityRepository.findById(id);

        if (tutorialData.isPresent()) {
            Entities _entities = tutorialData.get();
            _entities.setType(entities.getType());
            _entities.setArea(entities.getArea());
            _entities.setPrice(entities.getArea());
            _entities.setPrice(entities.getRooms());
            return new ResponseEntity<>(entityRepository.save(_entities), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            entityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            entityRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<Entities>> findByPublished() {
//        try {
//            List<Entities> entities = entityRepository.findByPublished(true);
//
//            if (entities.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(entities, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
