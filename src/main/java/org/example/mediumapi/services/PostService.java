package org.example.mediumapi.services;

import org.example.mediumapi.models.Post;
import org.example.mediumapi.repository.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostsRepo postsRepo;

    public List<Post> getAllPosts(){
        return postsRepo.findAll();
    }

    public Post getPostById(String id){
        return postsRepo.findById(id).orElse(null);
    }

    public Post savePost(Post post){
        return postsRepo.save(post);
    }
}
