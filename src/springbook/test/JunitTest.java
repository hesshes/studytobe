package springbook.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.either;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/JunitTest-context.xml")
public class JunitTest {
    @Autowired
    ApplicationContext ctx;

    static Set<JunitTest> testObjects = new HashSet<JunitTest>();
    static ApplicationContext ctxObj = null;

    @Test
    public void test1() {
        assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);

        assertTrue(ctxObj == null || ctxObj == this.ctx);
        ctxObj = this.ctx;
    }

    @Test
    public void test2() {
        assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);

        assertTrue(ctxObj == null || ctxObj == this.ctx);
        ctxObj = this.ctx;
    }

    @Test
    public void test3() {
        assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);

        assertThat(ctx, either(is(nullValue())).or(is(this.ctx)));
        ctxObj = this.ctx;
    }

}
