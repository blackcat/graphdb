package dart.blackcat.graphdb.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dart.blackcat.graphdb.test.inmemory.EdgeTestCase;
import dart.blackcat.graphdb.test.inmemory.VertexTestCase;

@RunWith(Suite.class)
@SuiteClasses({
	EdgeTestCase.class,
	VertexTestCase.class,
})
public class AllTests {}
