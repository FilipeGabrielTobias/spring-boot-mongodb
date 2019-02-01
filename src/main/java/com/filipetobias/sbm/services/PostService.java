package com.filipetobias.sbm.services;

import com.filipetobias.sbm.domain.Post;
import com.filipetobias.sbm.dto.SearchDTO;

import java.util.List;

public interface PostService {

    Post findById(String id);

    List<Post> findByTitle(SearchDTO text);
}
