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
    public void testSortAsc() {
        System.out.println("SORT ASC TEST");
        int [] unsortedArr = new int [] {8, 3, 2, 6};
        int [] result = func.sortAsc(unsortedArr);
        int [] sortedArr = new int [] {2, 3, 6, 8};
        assertArrayEquals(sortedArr, result);
    }


}