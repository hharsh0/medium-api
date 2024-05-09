package org.example.mediumapi.sample;

import jakarta.annotation.PostConstruct;
import org.example.mediumapi.models.Post;
import org.example.mediumapi.services.PostService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SampleDataLoader {
    private final PostService postService;
    public SampleDataLoader(PostService postService) {
        this.postService = postService;
    }

    @PostConstruct
    public void loadSampleData(){
        if(postService.getAllPosts().isEmpty()){
            Post post1 = Post.builder()
                    .title("Sample Post 1")
                    .content("This is the content of Sample Post 1.")
                    .timeToRead(5)
                    .chipTitles(Arrays.asList("Java", "Spring"))
                    .build();

            Post post2 = Post.builder()
                    .title("Sample Post 2")
                    .content("This is the content of Sample Post 2.")
                    .timeToRead(7)
                    .chipTitles(Arrays.asList("Java", "Spring Boot"))
                    .build();

            Post post3 = Post.builder()
                    .title("Sample Post 3")
                    .content("This is the content of Sample Post 3.")
                    .timeToRead(10)
                    .chipTitles(Arrays.asList("Java", "Spring Data"))
                    .build();

            List<Post> samplePosts = Arrays.asList(post1, post2, post3);
            samplePosts.forEach(postService::savePost);
        }
    }
}
