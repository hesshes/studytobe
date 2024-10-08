package com.hesshes.studytobe;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//list 2-25
public class JunitTest {
	static Set<JunitTest> testObjects = new HashSet<JunitTest>();

	@Test
	public void test1() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}

	@Test
	public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}

	@Test
	public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}

};