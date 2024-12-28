package springbook.user.service;

import springbook.user.domain.User;

public interface UserLevelUpgrade {
    boolean canUpgradeLevel(User user);

    void upgradeLevel(User user);
}
