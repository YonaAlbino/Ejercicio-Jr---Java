package com.albino.PayGoal.repository;

import com.albino.PayGoal.model.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<userEntity, Long> {
    @Query(value = "SELECT * FROM user_entity WHERE email = :email", nativeQuery = true)
    Optional<userEntity> findByEmail(String email);
}
