package org.fanyi.fanyibackend.repository;

import org.fanyi.fanyibackend.po.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhoneAndPwd(String phone, String pwd);

    Optional<User> findByPhone(String phone);
}
