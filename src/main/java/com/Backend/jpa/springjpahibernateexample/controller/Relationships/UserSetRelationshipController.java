package com.Backend.jpa.springjpahibernateexample.controller.Relationships;

import com.Backend.jpa.springjpahibernateexample.controller.UsersController;
import com.Backend.jpa.springjpahibernateexample.model.Relationships.UserSetRelationship;
import com.Backend.jpa.springjpahibernateexample.repository.RelationshipsRepo.UserSetRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user_set_relationship")
public class UserSetRelationshipController {

    @Autowired
    UserSetRelationshipRepository userSetRelationshipRepository;

    @Autowired
    UsersController usersController;

    @GetMapping("/all")
    public List<UserSetRelationship> getAll() { return userSetRelationshipRepository.findAll(); }

    @GetMapping("/{id}")
    public UserSetRelationship getId(@PathVariable("id") final Integer id) { return userSetRelationshipRepository.findOne(id); }

    // get all user's uuid who has done the questions in this question set
    @GetMapping("/set/{setId}")
    public List<UserSetRelationship> getUUIDsBySet(@PathVariable("setId") final Integer setId) {
        return userSetRelationshipRepository.findBySetId(setId);
    }

    //get all question sets' id based an user has completed by UUID
    @GetMapping("/uuid/{uuid}")
    public List<UserSetRelationship> getSetsByUUID(@PathVariable("uuid") final String uuid) {
        return userSetRelationshipRepository.findByUuid(uuid);
    }

    @PostMapping("/")
    public UserSetRelationship create(@RequestBody UserSetRelationship userSetRelationship) {
        userSetRelationshipRepository.save(userSetRelationship);
        return userSetRelationship;
    }

}
