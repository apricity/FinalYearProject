import junit.framework.TestCase;

import java.util.ArrayList;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestClusteringsGraph03_4 extends TestCase
{
	private String directory;
	private UndirectedGraph<Vertex, DefaultEdge> inputGraph;
	private Vertex[] inputVertexSet;
	private OrbitFinder orbitFinder;
	private KMeansClusterer kMeanClusterer;
	
	// constructor
	public TestClusteringsGraph03_4(String name, String requiredDirectory)
	{
		super(name);
		directory = requiredDirectory + "\\graph03_4.gml";
	}
	
	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
		inputGraph = null;
		inputVertexSet = null;
		orbitFinder = null;
		kMeanClusterer = null;
	}

	@Test
	public void testInputWithLoopG03_4() throws Exception
	{
		// test inputting a graph with a reflexive loop
		// -- exception (no reflexive loops allowed)
		try 
		{
			inputGraph = new GMLParser(directory).getGraph();
		} // try
		catch (Exception exception)
		{
			// succeed quietly
		} // catch
		
	  // test the orbits are as expected
		// -- exception (no graph has been input)
		try 
		{
		  orbitFinder = new OrbitFinder(inputGraph, "testOut.txt", 2);
		} // try
		catch (Exception exception)
		{
			// succeed quietly
		} // catch
		
	  // test the k-means clusterings are as expected
	  // -- exception (no graph has been input)
		try 
		{
		  kMeanClusterer = new KMeansClusterer(inputGraph, "testOut.txt", "testOut.csv", 0);
		} // try
		catch (Exception exception)
		{
			// succeed quietly
		} // catch
		
	} // testInputWithLoop

} // class TestClusteringsGraph03_4
