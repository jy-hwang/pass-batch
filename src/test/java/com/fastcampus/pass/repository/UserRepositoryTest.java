package com.fastcampus.pass.repository;

import com.fastcampus.pass.repository.packaze.PackageRepository;
import com.fastcampus.pass.repository.user.UserEntity;
import com.fastcampus.pass.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
//@SpringBootTest
@DataJpaTest
@DisplayName("user repository test")
@ActiveProfiles("test")
public class UserRepositoryTest {

  @Autowired
  private final UserRepository userRepository;

  @DisplayName("user save test")
  @Test
  void test_userInsert(){
    UserEntity u1 = new UserEntity();
    final String userId = "C100" + RandomStringUtils.randomNumeric(4);

    u1.setUserId("");
    u1.set
  }

}
