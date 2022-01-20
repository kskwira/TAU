import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import org.junit.*;
import org.joda.time.LocalDate;


public class ExampleTest {

    private Example Example;

    @Before
    public void setUp() throws Exception {
        Example = new Example();
    }

    @After
    public void tearDown() throws Exception {
        Example = null;
    }

    @Test
    public void testAdd() {
        System.out.println("ADD TEST");
        int result = Example.add(2, 2);
        assertEquals(4, result);
    }

    @Test
    public void testSubtract() {
        System.out.println("SUBTRACT TEST");
        int result = Example.subtract(4, 4);
        assertEquals(0, result);
    }

    @Test
    public void testMultiply() {
        System.out.println("SUBTRACT TEST");
        int result = Example.multiply(4, 8);
        assertEquals(32, result);
    }

    @Test
    public void testDivide() {
        System.out.println("DIVIDE TEST");
        int result = Example.divide(24, 4);
        assertEquals(6, result);
    }

    @Test
    public void testDivideByZero() {
        System.out.println("DIVIDE BY ZERO TEST");
        assertThrows(ArithmeticException.class, () -> Example.divide(4, 0));
    }

    @Test
    public void testMultipleFunctions() {
        System.out.println("ADD + DIVIDE TEST");
        int addResult = Example.add(5, 3);
        int divideResult = Example.divide(40, addResult);
        assertEquals(5, divideResult);
    }

    @Test
    public void testMultipleFunctions2() {
        System.out.println("SUBTRACT + MULTIPLY TEST");
        int subtractResult = Example.subtract(5, 3);
        int multiplyResult = Example.multiply(40, subtractResult);
        assertEquals(80, multiplyResult);
    }

    @Test
    public void testSortAsc() {
        System.out.println("SORT ASC TEST");
        int [] unsortedArr = new int [] {8, 3, 2, 6};
        int [] result = Example.sortAsc(unsortedArr);
        int [] sortedArr = new int [] {2, 3, 6, 8};
        assertArrayEquals(sortedArr, result);
    }

    @Test
    public void testCheckPalindromeTrue() {
        System.out.println("PALINDROME TRUE TEST");
        boolean result = Example.checkPalindrome("kayak");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindromeFalse() {
        System.out.println("PALINDROME FALSE TEST");
        boolean result = Example.checkPalindrome("boat");
        assertFalse(result);
    }

    @Test
    public void testLogarithm() {
        System.out.println("LOGARITHM TEST");
        double result = Example.logarithm(10);
        assertEquals(2.302585092994046, result, 1e-15);
    }

    @Test
    public void testSquareRoot() {
        System.out.println("SQUARE ROOT TEST");
        double result = Example.squareRoot(25);
        assertEquals(5, result, 1e-15);
    }

    @Test
    public void testPowerOfTwoNumbers() {
        System.out.println("POWER OF 2 NUMBERS TEST");
        double result = Example.powerOfTwoNumbers(4, 3);
        assertEquals(64, result, 1e-15);
    }

    @Test
    public void testFibonacci() {
        System.out.println("FIBONACCI 1 TEST");
        int eight_element = 13;
        ArrayList<Integer> result = Example.fibonacci(8);
        assertEquals(eight_element, result.get(7).intValue());
    }

    @Test
    public void testFibonacci2() {
        System.out.println("FIBONACCI 2 TEST");
        int tenth_element = 34;
        ArrayList<Integer> result = Example.fibonacci(10);
        assertEquals(tenth_element, result.get(9).intValue());
    }

    @Test
    public void testSortDesc() {
        System.out.println("SORT DESC TEST");
        int [] unsortedArr = new int [] {8, 3, 2, 6};
        int [] result = Example.sortDesc(unsortedArr);
        int [] sortedArr = new int [] {8, 6, 3, 2};
        assertArrayEquals(sortedArr, result);
    }

    @Test
    public void testCheckPrimeNumberTrue() {
        System.out.println("PRIME NUMBER TRUE TEST");
        boolean result = Example.checkPrimeNumber(47);
        assertTrue(result);
    }

    @Test
    public void testCheckPrimeNumberFalse() {
        System.out.println("PRIME NUMBER FALSE TEST");
        boolean result = Example.checkPrimeNumber(84);
        assertFalse(result);
    }

    @Test
    public void testGetMonthNameInGerman() {
        System.out.println("GET MONTH NAME IN GERMAN TEST");
        String result = Example.getMonthNameInGerman(LocalDate.parse("2021-12-19"));
        System.out.println("Month name in German: " + result);
        assertEquals("Dezember", result);
    }

    @Test
    public void testFormatDate() {
        System.out.println("FORMAT DATE TEST");
        String result = Example.formatDate(LocalDate.parse("2021-12-19"));
        System.out.println("Formatted date: " + result);
        assertEquals("19 grudnia, 2021", result);
    }

    @Test
    public void testSerializeStudentObject() {
        System.out.println("SERIALIZE STUDENT OBJECT TEST");
        Example.Student student = new Example.Student("Jan Kowalski", 4.3);
        String result = Example.serializeStudentObject(student);
        String expectedResult = "{\"studentName\":\"Jan Kowalski\",\"studentGradeAverage\":4.3}";
        System.out.println("Serialized object: \n " + result);
        assertEquals(expectedResult, result);

    }

    @Test
    public void testMockDivide() {
        System.out.println("TESTING MOCK DIVIDE TO RETURN 4");
        Example example = mock(Example.class);
        when(example.mockDivide(20, 5)).thenReturn(4);
        int result = example.mockDivide(20, 5);
        assertEquals(4, result);
    }

    @Test
    public void testMockDivide2() {
        System.out.println("TESTING MOCK DIVIDE TO RETURN 2");
        Example example = mock(Example.class);
        given(example.mockDivide(4, 2)).willReturn(2);
        int result = example.mockDivide(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMockDivide3() {
        System.out.println("TESTING MOCK DIVIDE TO THROW ARITHMETIC EXCEPTION");
        Example example = mock(Example.class);
        given(example.mockDivide(8, 0)).willThrow(ArithmeticException.class);
        assertThrows(ArithmeticException.class, () -> example.mockDivide(8, 0));
    }

    @Test
    public void testMockCheckPalindromeTrue() {
        System.out.println("MOCK PALINDROME TRUE TEST");
        Example example = mock(Example.class);
        given(example.mockCheckPalindrome("kayak")).willReturn(true);
        boolean result = example.mockCheckPalindrome("kayak");
        assertTrue(result);
    }

    @Test
    public void testMockCheckPalindromeFalse() {
        System.out.println("MOCK PALINDROME FALSE TEST");
        Example example = mock(Example.class);
        when(example.mockCheckPalindrome("boat")).thenReturn(false);
        boolean result = example.mockCheckPalindrome("boat");
        assertFalse(result);
    }

}
