package com.social.flow.lendo.service;

import com.social.flow.lendo.client.DataClient;
import com.social.flow.lendo.dto.Comment;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    @NonNull
    private final DataClient dataClient;

    public List<Comment> getAllComments(final int page, final int perPage){

        return dataClient.getComments(page,perPage);
    }

    public List<Comment> getCommentsByPost(Long postId,final int page, final int perPage) {
        return  dataClient.getCommentsForPost(postId,page,perPage);
    }
}
