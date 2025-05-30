package com.fastcampus.pass.repository;

import com.fastcampus.pass.repository.packaze.PackageEntity;
import com.fastcampus.pass.repository.packaze.PackageRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
@ActiveProfiles("tc")
public class PackageRepositoryTest {

  @Autowired
  private PackageRepository packageRepository;

  @DisplayName("save test")
  @Test
  public void test_save() {
    //given
    PackageEntity packageEntity = new PackageEntity();
    packageEntity.setPackageName("바디 챌린지 PT 12주");
    packageEntity.setPeriod(84);

    //when
    packageRepository.save(packageEntity);

    //then
    assertNotNull(packageEntity.getPackageSeq());
  }

  @Test
  public void test_findByCreatedAtAfter() {
    // Given
    LocalDateTime dateTime = LocalDateTime.now().minusMinutes(1);

    PackageEntity packageEntity0 = new PackageEntity();
    packageEntity0.setPackageName("학생 전용 3개월");
    packageEntity0.setPeriod(90);
    packageRepository.save(packageEntity0);

    PackageEntity packageEntity1 = new PackageEntity();
    packageEntity1.setPackageName("학생 전용 6개월");
    packageEntity1.setPeriod(180);
    packageRepository.save(packageEntity1);

    // When
    final List<PackageEntity> packageEntities =
        packageRepository.findByCreatedAtAfter(
            dateTime,
            PageRequest.of(0, 1,
                Sort.by("packageSeq").descending()));

    // Then
    assertEquals(1, packageEntities.size());
    assertEquals(packageEntity1.getPackageSeq(), packageEntities.get(0).getPackageSeq());
  }

  @Test
  public void test_updateCountAndPeriod() {
    // Given
    PackageEntity packageEntity = new PackageEntity();
    packageEntity.setPackageName("바디 프로필 이벤트 4개월");
    packageEntity.setPeriod(90);
    packageRepository.save(packageEntity);

    // When
    int updatedCount = packageRepository.updateCountAndPeriod(packageEntity.getPackageSeq(), 30, 120);
    final PackageEntity updatedPackageEntity = packageRepository.findById(packageEntity.getPackageSeq()).get();

    // Then
    assertEquals(1, updatedCount);
    assertEquals(Optional.of(30L), updatedPackageEntity.getCount());
    assertEquals(Optional.of(120L), updatedPackageEntity.getPeriod());
  }

  @Test
  public void test_delete() {
    // Given
    PackageEntity packageEntity = new PackageEntity();
    packageEntity.setPackageName("제거할 이용권");
    packageEntity.setCount(1);
    PackageEntity newPackageEntity = packageRepository.save(packageEntity);

    // When
    packageRepository.deleteById(newPackageEntity.getPackageSeq());

    // Then
    assertTrue(packageRepository.findById(newPackageEntity.getPackageSeq()).isEmpty());
  }

}
