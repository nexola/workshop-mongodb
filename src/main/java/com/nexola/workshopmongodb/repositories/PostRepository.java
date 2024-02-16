package com.nexola.workshopmongodb.repositories;

import com.nexola.workshopmongodb.models.entities.Post;
import com.nexola.workshopmongodb.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
