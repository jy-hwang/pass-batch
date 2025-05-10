package com.fastcampus.pass.repository.pass;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PassModelMapperTest {

  @Test
  public void test_toPassEntity() {
    // given
    final LocalDateTime now = LocalDateTime.now();
    final String userId = "A1000000";

    BulkPassEntity bulkPassEntity = new BulkPassEntity();
    bulkPassEntity.setPackageSeq(1);
    bulkPassEntity.setUserGroupId("GROUP");
    bulkPassEntity.setStatus(BulkPassStatus.COMPLETED);
    bulkPassEntity.setCount(10);
    bulkPassEntity.setStartedAt(now.minusDays(60));
    bulkPassEntity.setEndedAt(now);

    log.info(bulkPassEntity.toString());
    // when
    final PassEntity passEntity = PassModelMapper.INSTANCE.toPassEntity(bulkPassEntity, userId);
    log.info(passEntity.toString());

    // then
    assertEquals(1, passEntity.getPackageSeq());
    assertEquals(PassStatus.READY, passEntity.getStatus());
    assertEquals(10, passEntity.getRemainingCount());
    assertEquals(now.minusDays(60), passEntity.getStartedAt());
    assertEquals(now, passEntity.getEndedAt());
    assertEquals(userId, passEntity.getUserId());
  }

}
