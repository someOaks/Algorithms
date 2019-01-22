import org.junit.Test;

import static junit.framework.TestCase.*;


public class MyTwoStackQueueTest {
	
	@Test
	public void TestEmptySize() {
		MyTwoStackQueue instance = new MyTwoStackQueue();
		assertEquals(0, instance.size() );
	}
	
	@Test
	public void TestNonEmptySize() {
		MyTwoStackQueue<Integer> instance = new MyTwoStackQueue<>();
		instance.add(1);
		instance.add(2);
		instance.add(3);
		instance.add(4);
		assertEquals(4, instance.size() );
	}
	
	@Test
	public void TestSizeAfterPoll() {
		MyTwoStackQueue<String> instance = new MyTwoStackQueue<>();
		instance.add("a");
		instance.add("b");
		instance.add("c");
		instance.add("d");
		
		assertEquals("a", instance.poll());
		assertEquals(3, instance.size() );
	}
	
	@Test
	public void TestIsEmpty() {
		MyTwoStackQueue<Integer> instance = new MyTwoStackQueue<>();
		assertTrue(instance.isEmpty());
		instance.add(25);
		assertFalse(instance.isEmpty());
	}
	
	@Test
	public void TestAdd() {
		MyTwoStackQueue<Integer> instance = new MyTwoStackQueue<>();
		
		assertTrue(instance.add(1));
		assertTrue(instance.add(2));
		assertTrue(instance.add(3));
		assertTrue(instance.add(4));
		assertTrue(instance.add(5));
	}
	
	@Test
	public void TestPoll() {
		MyTwoStackQueue<Integer> instance = new MyTwoStackQueue<>();
		
		assertTrue(instance.add(1));
		assertTrue(instance.add(2));
		assertTrue(instance.add(3));
		assertTrue(instance.add(4));
		assertTrue(instance.add(5));
		
		assertEquals(5, instance.size());
		
		assertEquals(1, instance.poll());
		assertEquals(2, instance.poll());
		assertEquals(3, instance.poll());
		assertEquals(4, instance.poll());
		assertEquals(5, instance.poll());
		
		assertTrue(instance.isEmpty());
	}
	
	@Test
	public void TestPeek() {
		MyTwoStackQueue<Integer> instance = new MyTwoStackQueue<>();
		
		assertTrue(instance.add(1));
		assertTrue(instance.add(2));
		assertTrue(instance.add(3));
		assertTrue(instance.add(4));
		assertTrue(instance.add(5));
		
		assertEquals(5, instance.size());
		
		assertEquals(1, instance.peek());
	}
}