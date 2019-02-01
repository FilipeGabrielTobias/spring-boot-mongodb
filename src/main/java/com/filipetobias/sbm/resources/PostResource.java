package com.filipetobias.sbm.resources;

import com.filipetobias.sbm.domain.Post;
import com.filipetobias.sbm.dto.SearchDTO;
import com.filipetobias.sbm.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable  String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestBody SearchDTO search) {
        List<Post> post = postService.findByTitle(search);
        return ResponseEntity.ok().body(post);
    }
}
