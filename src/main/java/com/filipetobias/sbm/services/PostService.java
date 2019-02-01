package com.filipetobias.sbm.services;

import com.filipetobias.sbm.domain.Post;
import com.filipetobias.sbm.dto.SearchDTO;

import java.util.Date;
import java.util.List;

public interface PostService {

    Post findById(String id);

    List<Post> searchTitle(SearchDTO search);

    List<Post> findByTitle(SearchDTO search);

    List<Post> fullSearch(SearchDTO search);
}
