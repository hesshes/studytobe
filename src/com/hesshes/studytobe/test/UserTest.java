package com.hesshes.studytobe.test;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.hesshes.studytobe.domain.Level;
import com.hesshes.studytobe.domain.User;

import static org.hamcrest.CoreMatchers.is;

public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void upgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.nextLevel() == null)
                continue;
            user.setLevel(level);
            user.upgradeLevel();
            assertThat(user.getLevel(), is(level.nextLevel()));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void cannotUpgradeLevel() {
        Level[] levels = Level.values();
        for (Level level : levels) {
            if (level.nextLevel() != null)
                continue;
            user.setLevel(level);
            user.upgradeLevel();
        }
    }
}
