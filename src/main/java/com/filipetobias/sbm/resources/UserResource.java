package com.filipetobias.sbm.resources;

import com.filipetobias.sbm.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User filipe = new User(1L, "Filipe Gabriel Tobias", "tobias.filipe@gmail.com");
        User bob = new User(2L, "Bob Singer", "bob.singer@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(filipe, bob));
        return ResponseEntity.ok().body(list);
    }
}
