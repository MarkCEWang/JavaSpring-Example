package com.Backend.jpa.springjpahibernateexample.controller;

import com.Backend.jpa.springjpahibernateexample.model.Users;
import com.Backend.jpa.springjpahibernateexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Users> getUser(@PathVariable("name") final String name) {
        return usersRepository.findByName(name);

    }

    @GetMapping("/id/{id}")
    public Users getId(@PathVariable("id") final Integer id) {
        return usersRepository.findOne(id);
    }

    @PostMapping("/")
    public Users createUser(@RequestBody Users user) {

        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        usersRepository.save(user);
        return user;
    }

    @PutMapping("/{id}")
    public Users updateAll(@PathVariable("id") final Integer id, @RequestBody Users updatedUser) {
        Users user = getId(id);
        user.updateAllFields(updatedUser);
        usersRepository.save(user);
        return user;
    }

    @PatchMapping("/{id}")
    public Users update(@PathVariable("id") final Integer id, @RequestBody Users updatedUser) {
        Users user = getId(id);
        user.updateFields(updatedUser);
        usersRepository.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Integer id) {
        Users user = getId(id);
        usersRepository.delete(user);
    }
}
