package org.example.mediumapi.repository;

import org.example.mediumapi.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostsRepo extends MongoRepository<Post,String> {

}
