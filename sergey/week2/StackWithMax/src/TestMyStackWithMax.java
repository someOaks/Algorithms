import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestMyStackWithMax {
	
	
	@Test
	public void testEmptyConstructor() {
		MyStackWithMax myStackWithMax = new MyStackWithMax();
		
		assertTrue(myStackWithMax.isEmpty());
		
		for(int i = 0; i < 10; i++) {
			myStackWithMax.push(i);
		}
		
		assertEquals(10, myStackWithMax.size());
		assertEquals(10, myStackWithMax.getStackArrayLength());
		
		assertFalse(myStackWithMax.isEmpty());
	}
	
	@Test
	public void testConstructorWithArguments() {
		int SIZE = 4;
		MyStackWithMax myStackWithMax = new MyStackWithMax(SIZE);
		
		assertTrue(myStackWithMax.isEmpty());
		
		for(int i = 0; i < SIZE + 1; i++) {
			myStackWithMax.push(i);
		}
		
		assertEquals(SIZE + 1, myStackWithMax.size());
		assertEquals(SIZE * 2, myStackWithMax.getStackArrayLength());
		
		assertFalse(myStackWithMax.isEmpty());
	}
	
	@Test
	public void testPop() {
		MyStackWithMax myStackWithMax = new MyStackWithMax(2);
		assertEquals(0, myStackWithMax.size());
		
		myStackWithMax.push(25); // 1
		myStackWithMax.push(215);// 2
		myStackWithMax.push(0); // 3
		
		assertEquals(3, myStackWithMax.size());
		
		assertEquals((Integer)0, myStackWithMax.pop()); // 1
		assertEquals(2, myStackWithMax.size());
		
		assertEquals(215, (int) myStackWithMax.pop()); // 2
		assertEquals(1, myStackWithMax.size());
		
		assertEquals(25, (int) myStackWithMax.pop()); // 3
		assertEquals(0, myStackWithMax.size());
	}
	
	@Test
	public void testGetMaxElement() {
		MyStackWithMax myStackWithMax = new MyStackWithMax(2);
		Integer[] testArray = new Integer[12];
		Integer max = 0;
		
		for (int i = 0; i < 12; i++) {
			int temp = new Random().nextInt(100);
			testArray[i] = temp;
			myStackWithMax.push(temp);
		}
		
		for (Integer integer : testArray) {
			if (integer > max) max = integer;
		}
		assertEquals(12, myStackWithMax.size());
		assertEquals(max, myStackWithMax.getMaxElement());
	}
	
	@Test
	public void testGetMaxElementAfterPOP() {
		MyStackWithMax myStackWithMax = new MyStackWithMax(2);
		
		myStackWithMax.push(0);  // 1
		myStackWithMax.push(25); // 2
		myStackWithMax.push(19); // 3
		myStackWithMax.push(16); // 4
		myStackWithMax.push(24); // 5
		myStackWithMax.push(35); // 6
		
		assertEquals(6, myStackWithMax.size());
		assertEquals(35, (int)myStackWithMax.getMaxElement());
		
		assertEquals(35, (int)myStackWithMax.pop()); // 1
		assertEquals(25, (int)myStackWithMax.getMaxElement());
		assertEquals(5, myStackWithMax.size());
		
		assertEquals(8, myStackWithMax.getStackArrayLength());
		
		assertEquals(24, (int)myStackWithMax.pop()); // 2
		assertEquals(16, (int)myStackWithMax.pop()); // 3
		assertEquals(19, (int)myStackWithMax.pop()); // 4
		
		assertEquals(2, myStackWithMax.size());
		assertEquals(8, myStackWithMax.getStackArrayLength());
		assertEquals(25, (int)myStackWithMax.getMaxElement());
		
		assertEquals(25, (int)myStackWithMax.pop()); // 5
		
		assertEquals(1, myStackWithMax.size());
		assertEquals(2, myStackWithMax.getStackArrayLength());
		assertEquals(0, (int)myStackWithMax.getMaxElement());
		
		
		
	}
}