package com.sros.cardmanagement.repository;

import com.sros.cardmanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
