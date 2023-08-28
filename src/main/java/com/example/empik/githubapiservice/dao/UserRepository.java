package com.example.empik.githubapiservice.dao;

import com.example.empik.githubapiservice.model.entity.GitHubApiRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GitHubApiRequests, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE GitHubApiRequests u SET u.requestCount = u.requestCount + 1 WHERE u.login = :login")
    void incrementRequestCount(@Param("login") String login);

    Optional<GitHubApiRequests> findByLogin(String login);
}
