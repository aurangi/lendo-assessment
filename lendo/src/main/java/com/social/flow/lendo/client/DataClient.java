package com.social.flow.lendo.client;

import com.social.flow.lendo.dto.Comment;
import com.social.flow.lendo.dto.Post;
import com.social.flow.lendo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "data-client", url = "https://gorest.co.in/public/v2")
public interface DataClient {

    @GetMapping("/users")
    List<User> getUsers(  @RequestParam("page") final int page,
                          @RequestParam("per_page") final  int perPage);

    @GetMapping("/posts")
    List<Post> getPosts(  @RequestParam("page") final int page,
                          @RequestParam("per_page") final int perPage);

    @GetMapping("/comments")
    List<Comment> getComments(  @RequestParam("page") final int page,
                                @RequestParam("per_page") final int perPage);

    @GetMapping("/users/{userId}/posts")
    List<Post> getPostsForUser(
            @PathVariable("userId") final Long userId,
            @RequestParam("page") int page,
            @RequestParam("per_page") int perPage
    );

    @GetMapping("/posts/{postId}/comments")
    List<Comment> getCommentsForPost(
            @PathVariable("postId") final  Long postId,
            @RequestParam("page") int page,
            @RequestParam("per_page") int perPage
    );
}
