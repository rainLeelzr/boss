package com.rain.boss;

import com.rain.boss.perm.PermTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PermTestSuite.class})
public abstract class BossTestSuite {
}
