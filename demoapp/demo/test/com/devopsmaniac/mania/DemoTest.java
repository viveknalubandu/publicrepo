package demo.test.com.devopsmaniac.mania;

import static org.junit.Assert.*;

import org.junit.Test;

import demo.src.com.devopsmaniac.mania.Demo;

public class DemoTest {

	@Test
	public void somethingRandom() {

		assertEquals( 2, Demo.somethingRandom(2) );
	}
}
