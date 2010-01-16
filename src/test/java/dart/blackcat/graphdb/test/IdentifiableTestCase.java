package dart.blackcat.graphdb.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dart.blackcat.graphdb.Identifiable;



@SuppressWarnings("unchecked")
public abstract class IdentifiableTestCase<T extends Identifiable> extends CloneableTestCase<T> {

	protected T[] a = (T[]) new Identifiable[3];
	protected T b;
	
	@Before
	public abstract void init();
	
	@Test
	public void equalsTest() {
		assertEquals(a[0], b);
		assertEquals(b, a[0]);
		assertFalse(a[1].equals(b));
	}
	
	@Test
	public void hashCodeTest() {
		assertTrue (a[0].hashCode() == b.hashCode());
		assertFalse(a[1].hashCode() == b.hashCode());
	}
	
}
