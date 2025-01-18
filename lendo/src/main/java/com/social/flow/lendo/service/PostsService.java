package com.social.flow.lendo.service;

import com.social.flow.lendo.client.DataClient;
import com.social.flow.lendo.dto.Post;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {

    @NonNull
    private final DataClient dataClient;

    public List<Post> getAllPosts(final int page, final int perPage){
        return dataClient.getPosts(page,perPage);
    }

    public List<Post> getPostsByUser(final Long userId, final int page, final int perPage){
        return dataClient.getPostsForUser(userId,page,perPage);
    }

}
