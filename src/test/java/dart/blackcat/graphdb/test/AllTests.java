package dart.blackcat.graphdb.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dart.blackcat.graphdb.test.inmemory.EdgeTestCase;
import dart.blackcat.graphdb.test.inmemory.GraphTestCase;
import dart.blackcat.graphdb.test.inmemory.NodeTestCase;

@RunWith(Suite.class)
@SuiteClasses({
	EdgeTestCase.class,
	NodeTestCase.class,
	GraphTestCase.class,
})
public class AllTests {}
