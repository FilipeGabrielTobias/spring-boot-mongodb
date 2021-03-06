package com.filipetobias.sbm.configuration;

import com.filipetobias.sbm.domain.Post;
import com.filipetobias.sbm.domain.User;
import com.filipetobias.sbm.dto.AuthorDTO;
import com.filipetobias.sbm.dto.CommentDTO;
import com.filipetobias.sbm.repository.PostRepository;
import com.filipetobias.sbm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User filipe = new User(null, "Filipe Gabriel Tobias", "tobias.filipe@gmail.com");
        User bob = new User(null, "Bob Singer", "bob.singer@gmail.com");

        userRepository.saveAll(Arrays.asList(filipe, bob));


        Post post1 = new Post(null, sdf.parse("31/01/2019"), "Partiu Viagem!", "Vou viajar para São Paulo!", new AuthorDTO(filipe));
        Post post2 = new Post(null, sdf.parse("31/01/2019"), "Bora Trabalhar", "Hoje o dia vai ser longo!", new AuthorDTO(bob));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("01/02/2019"), new AuthorDTO(bob));
        CommentDTO c2 = new CommentDTO("Valeu!!", sdf.parse("01/02/2019"), new AuthorDTO(filipe));

        post1.getComments().addAll(Arrays.asList(c1, c2));

        postRepository.saveAll(Arrays.asList(post1, post2));

        filipe.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(filipe);
    }
}
