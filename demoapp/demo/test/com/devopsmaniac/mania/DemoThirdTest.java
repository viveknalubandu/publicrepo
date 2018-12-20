package demo.test.com.devopsmaniac.mania;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import demo.src.com.devopsmaniac.mania.Demo;

public class DemoThirdTest {

	@Test
	@Ignore	
	public void somethingRandom() {
		assertEquals( 1, Demo.somethingRandom(1) );
	}

	@Test
	@Ignore	
	public void anotherTest() {
		assertEquals( 1, Demo.somethingRandom(1) );
	}
	
	@Test
	@Ignore	
	public void yetAnotherTest() {
		assertEquals( 1, Demo.somethingRandom(1) );
	}
}
