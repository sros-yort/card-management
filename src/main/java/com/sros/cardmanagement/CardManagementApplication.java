package com.sros.cardmanagement;

import com.sros.cardmanagement.entity.Card;
import com.sros.cardmanagement.entity.User;
import com.sros.cardmanagement.repository.CardRepository;
import com.sros.cardmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class CardManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
            CardRepository cardRepository = (CardRepository) ctx.getBean("cardRepository");

            User user = new User(1L, "Sros", "Yort", "Phnom Penh");
            User user2 = new User(2L, "Pong", "Ping", "Phnom Penh");
            userRepository.save(user);
            userRepository.save(user2);

            cardRepository.save(new Card("0000000000000001", "credit", 20D, 20D, Date.valueOf("2023-09-04"), "Activate", user));
            cardRepository.save(new Card("0000000000000002", "debit", 20D, 20D, Date.valueOf("2023-09-04"), "Padding", user));

            cardRepository.save(new Card("0000000000000003", "credit", 20D, 20D, Date.valueOf("2023-09-04"), "Activate", user2));
            cardRepository.save(new Card("0000000000000004", "debit", 20D, 20D, Date.valueOf("2023-09-04"), "Close", user2));
        };
    }
}
