package com.example.tugetduckzillserver.domain.user.domain.repository;

import com.example.tugetduckzillserver.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 퍼시스턴스 레이어, 영속성을 가지는 속성(파일, 데이터베이스)을 가진 인터페이스
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);
    // 복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리

    boolean existsByAccountId(String accountId);
}
