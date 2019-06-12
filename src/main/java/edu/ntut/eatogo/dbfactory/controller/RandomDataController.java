package edu.ntut.eatogo.dbfactory.controller;

import edu.ntut.eatogo.dbfactory.service.data.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class RandomDataController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "", notes = "Must populate user status first.")
    @PostMapping("user/random")
    public ResponseEntity<?> insertRandomUser() {
        userService.insertRandomUser();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("user/all")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
