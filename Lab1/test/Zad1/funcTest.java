package Zad1;

import org.junit.*;

import static org.junit.Assert.*;

public class funcTest {
    private func func;

    @Before
    public void setUp() throws Exception {
        func = new func();
    }

    @After
    public void tearDown() throws Exception {
        func = null;
    }

    @Test
    public void testAdd() {
        System.out.println("ADD TEST");
        int result = func.add(2, 2);
        assertEquals(4, result);
    }

    @Test
    public void testSubtract() {
        System.out.println("SUBTRACT TEST");
        int result = func.subtract(4, 4);
        assertEquals(0, result);
    }

    @Test
    public void testMultiply() {
        System.out.println("SUBTRACT TEST");
        int result = func.multiply(4, 8);
        assertEquals(32, result);
    }

    @Test
    public void testDivide() {
        System.out.println("DIVIDE TEST");
        int result = func.divide(24, 4);
        assertEquals(6, result);
    }

    @Test
    public void testDivideByZero() {
        System.out.println("DIVIDE BY ZERO TEST");
        assertThrows(ArithmeticException.class, () -> {
            func.divide(4, 0);
        });
    }

    @Test
    public void testMultipleFunctions() {
        System.out.println("ADD + DIVIDE TEST");
        int addResult = func.add(5, 3);
        int divideResult = func.divide(40, addResult);
        assertEquals(5, divideResult);
    }

    @Test
    public void testMultipleFunctions2() {
        System.out.println("SUBTRACT + MULTIPLY TEST");
        int subtractResult = func.subtract(5, 3);
        int multiplyResult = func.multiply(40, subtractResult);
        assertEquals(80, multiplyResult);
    }

    @Test
    public void testSortAsc() {
        System.out.println("SORT ASC TEST");
        int [] unsortedArr = new int [] {8, 3, 2, 6};
        int [] result = func.sortAsc(unsortedArr);
        int [] sortedArr = new int [] {2, 3, 6, 8};
        assertArrayEquals(sortedArr, result);
    }

    @Test
    public void testCheckPalindrome() {
        System.out.println("PALINDROME TEST");
        boolean result = func.checkPalindrome("kayak");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindrome2() {
        System.out.println("PALINDROME TEST");
        boolean result = func.checkPalindrome("boat");
        assertFalse(result);
    }

}