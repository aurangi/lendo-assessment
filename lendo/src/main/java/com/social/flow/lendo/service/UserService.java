package com.social.flow.lendo.service;

import com.social.flow.lendo.client.DataClient;
import com.social.flow.lendo.dto.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @NonNull
    private final DataClient dataClient;

    public List<User> getAllUsers(final int page, final int perPage) {
        return dataClient.getUsers(page,perPage);
    }

}
