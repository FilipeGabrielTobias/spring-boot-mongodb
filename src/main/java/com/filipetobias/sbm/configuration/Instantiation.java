package com.filipetobias.sbm.configuration;

import com.filipetobias.sbm.domain.User;
import com.filipetobias.sbm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws Exception {
        userRepository.deleteAll();

        User filipe = new User(null, "Filipe Gabriel Tobias", "tobias.filipe@gmail.com");
        User bob = new User(null, "Bob Singer", "bob.singer@gmail.com");

        userRepository.saveAll(Arrays.asList(filipe, bob));
    }
}
