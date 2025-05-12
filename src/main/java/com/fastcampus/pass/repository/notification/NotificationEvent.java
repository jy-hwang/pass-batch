package com.fastcampus.pass.repository.notification;

import lombok.Getter;

public enum NotificationEvent {
  BEFORE_CLASS("수업 전 입니다.");

  @Getter
  private final String description;

  NotificationEvent(String description) {
    this.description = description;
  }

}
