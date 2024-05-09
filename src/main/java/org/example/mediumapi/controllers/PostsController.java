package org.example.mediumapi.controllers;

import org.example.mediumapi.models.Post;
import org.example.mediumapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> getPosts() {
        List<Post> posts = postService.getAllPosts();
        return posts.stream()
                .peek(post -> {
                    if (post.getContent().length() > 100) {
                        post.setContent(post.getContent().substring(0, 100) + "...");
                    }
                })
                .collect(Collectors.toList());
    }


    @GetMapping("/{postId}")
    public Post getPost(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @PostMapping("/save")
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }
}
