package com.hesshes.studytobe.service;

import com.hesshes.studytobe.domain.User;

// list 5-33
public interface UserLevelUpgradePolicy {

    boolean canUpgradeLevel(User user);

    void upgradeLevel(User user);

}
