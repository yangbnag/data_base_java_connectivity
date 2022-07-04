package com.jdbc.basic.account.repository;

import com.jdbc.basic.schedule.domain.User;

public interface StartRepository {

    boolean checkId(String userId);

    boolean save(User user);

    String getPwd(String userId);
}
