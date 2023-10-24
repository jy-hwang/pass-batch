package com.fastcampus.pass.job.pass;

import static org.junit.jupiter.api.Assertions.*;

import com.fastcampus.pass.config.TestBatchConfig;
import com.fastcampus.pass.repository.packaze.PackageEntity;
import com.fastcampus.pass.repository.pass.PassEntity;
import com.fastcampus.pass.repository.pass.PassRepository;
import com.fastcampus.pass.repository.pass.PassStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@SpringBatchTest
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {ExpirePassesJobConfig.class, TestBatchConfig.class})
class ExpirePassesJobConfigTest {

  @Autowired
  private JobLauncherTestUtils jobLauncherTestUtils;

  @Autowired
  private PassRepository passRepository;

  @Test
  void test_expirePassesJob() {
    //given

    //when
    //then

  }

  @Test
  void test_expirePassesStep() {
    //given

    //when
    //then

  }

  @Test
  void test_expirePassesItemReader() {
    //given

    //when
    //then

  }

  @Test
  void test_expirePassesItemProcessor() {
    //given

    //when
    //then

  }

  @Test
  void test_expirePassesItemWriter() {
    //given

    //when
    //then

  }

  private void addPassEntity(int size){
    final LocalDateTime now = LocalDateTime.now();
    final Random random = new Random();

    List<PassEntity> passEntities = new ArrayList<>();
    for(int i = 0 ; i<size; ++i){
      PassEntity passEntity = new PassEntity();
      passEntity.setPackageSeq(1);
      passEntity.setUserId("A" + 1000000 + i);
      passEntity.setStatus(PassStatus.PROGRESSED);
      passEntity.setRemainingCount(random.nextInt(11));
      passEntity.setStartedAt(now.minusDays(60));
      passEntity.setEndedAt(now.minusDays(10));
      passEntities.add(passEntity);
    }
passRepository.saveAll(passEntities);
  }

}