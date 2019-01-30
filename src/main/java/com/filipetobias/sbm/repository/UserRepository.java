package com.filipetobias.sbm.repository;

import com.filipetobias.sbm.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {


}
