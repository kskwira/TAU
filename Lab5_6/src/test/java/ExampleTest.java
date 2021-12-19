import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
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
    public void testCheckPalindrome() {
        System.out.println("PALINDROME TEST");
        boolean result = Example.checkPalindrome("kayak");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindrome2() {
        System.out.println("PALINDROME TEST");
        boolean result = Example.checkPalindrome("boat");
        assertFalse(result);
    }

    @Test
    public void testGetMonthNameInJapanese() {
        System.out.println("GET MONTH NAME IN JAPANESE TEST");
        String result = Example.getMonthNameInJapanese(LocalDate.parse("2021-12-19"));
        System.out.println("Month name in Japanese: " + result);
        assertEquals("12月", result);
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

}
