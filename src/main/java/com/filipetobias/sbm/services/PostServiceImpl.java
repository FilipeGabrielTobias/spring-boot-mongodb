package com.filipetobias.sbm.services;

import com.filipetobias.sbm.domain.Post;
import com.filipetobias.sbm.dto.SearchDTO;
import com.filipetobias.sbm.repository.PostRepository;
import com.filipetobias.sbm.resources.util.URL;
import com.filipetobias.sbm.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public List<Post> searchTitle(SearchDTO search) {
        return postRepository.searchTitle(search.getText());
    }

    @Override
    public List<Post> findByTitle(SearchDTO search) {
        return postRepository.findByTitleContaining(search.getText());
    }

    @Override
    public List<Post> fullSearch(SearchDTO search) {
        Date min = URL.convertDate(search.getMinDate(), new Date(0L));
        Date max = URL.convertDate(search.getMaxDate(), new Date());
        max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(search.getText(), min, max);
    }
}
