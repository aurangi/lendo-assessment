package com.social.flow.lendo.controller;

import com.social.flow.lendo.dto.Comment;
import com.social.flow.lendo.dto.User;
import com.social.flow.lendo.exception.NoDataFoundException;
import com.social.flow.lendo.service.CommentsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class CommentsController {

    @NonNull
    private final CommentsService commentsService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments( @RequestParam("page") final int page,
                                                      @RequestParam("per_page") final int perPage){
        List<Comment> comments = commentsService.getAllComments(page,perPage);
        if (comments.isEmpty()) {
            throw new NoDataFoundException("No data found");
        }

        return ResponseEntity.ok(comments);
    }
}
