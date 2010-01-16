package dart.blackcat.graphdb.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public abstract class CloneableTestCase<T extends Cloneable> {
	
	protected T origin;
	protected T clone;
	
	@Before
	protected abstract void init();
	
	@Test
	public void cloneTest() {
		assertTrue(clone.equals(origin));
		assertTrue(origin.equals(clone));
		assertTrue(origin.hashCode() == clone.hashCode());
	}
}
