package com.sros.cardmanagement.repository;

import com.sros.cardmanagement.entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
    Iterable<Card> findByUserId(long userId);
}
