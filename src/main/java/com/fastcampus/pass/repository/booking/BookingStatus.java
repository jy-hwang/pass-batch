package com.fastcampus.pass.repository.booking;

import lombok.Getter;

public enum BookingStatus {
  READY("준비"), IN_PROGRESS("실행 중"), COMPLETED("완료됨"), CANCELLED("취소됨");

  @Getter
  private final String description;

  BookingStatus(String description) {
    this.description = description;
  }

}
