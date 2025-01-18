package com.social.flow.lendo;

import com.social.flow.lendo.models.User;
import com.social.flow.lendo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiUserData  implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TransactionTemplate transactionTemplate;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(final String... args) throws Exception {
        log.info("Going to insert data for api users.");
        this.transactionTemplate.execute((tx) -> {

            // insert user lendo
            User lendoUser =  new User();
            lendoUser.setUsername("lendo");
            lendoUser.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(lendoUser);

            // insert user aurang

            User user =  new User();
            user.setUsername("aurang");
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
            return null;
        });
    }
}
