package com.social.flow.lendo.controller;

import com.social.flow.lendo.dto.Post;
import com.social.flow.lendo.exception.NoDataFoundException;
import com.social.flow.lendo.service.PostsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class PostsController {

    @NonNull
    private final PostsService postsService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts(  @RequestParam("page") final int page,
                                                 @RequestParam("per_page")  final int perPage) {
        List<Post> posts = postsService.getAllPosts(page,perPage);

        if (posts.isEmpty()) {
            throw new NoDataFoundException("No posts found");
        }

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable("userId") Long userId, @RequestParam("page") final int page,
                                                 @RequestParam("per_page")  final int perPage) {
        List<Post> posts = postsService.getPostsByUser(userId,page,perPage);

        if (posts.isEmpty()) {
            throw new NoDataFoundException("No posts found");
        }

        return ResponseEntity.ok(posts);
    }


}
