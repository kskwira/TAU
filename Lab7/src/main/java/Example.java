import com.google.gson.Gson;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.*;


public class Example {

    public int add(int a, int b){
        int result = a + b;
        System.out.println(a + " + " + b + " = " + result);
        return result;
    }

    public int subtract(int a, int b){
        int result = a - b;
        System.out.println(a + " - " + b + " = " + result);
        return result;
    }

    public int multiply(int a, int b){
        int result = a * b;
        System.out.println(a + " * " + b + " = " + result);
        return result;
    }

    public int divide(int a, int b){
        int result = a / b;
        System.out.println(a + " : " + b + " = " + result);
        return result;
    }

    public int[] sortAsc(int [] arr) {
        //Initialize array
        int temp;

        //Displaying elements of original array
        System.out.println("Elements of original array: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }

        //Sort the array in ascending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println();

        //Displaying elements of array after sorting
        System.out.println("Elements of array sorted in ascending order: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();

        return arr;
    }

    public boolean checkPalindrome(String word) {
        //Assuming result to be true
        boolean result = true;
        int length = word.length();

        //dividing the length of the string by 2 and comparing it.
        for(int i=0; i<= length/2; i++) {
            if(word.charAt(i) != word.charAt(length-i-1)) {
                result = false;
                break;
            }
        }

        System.out.println(word + " is palindrome = " + result);
        return result;
    }

    public double logarithm(int a){
        double result = Math.log(a);
        System.out.println("Natural logarithm of " + a + " equals: " + result);
        return result;
    }

    public double squareRoot(int a){
        double result = Math.sqrt(a);
        System.out.println("Square root of " + a + " equals: " + result);
        return result;
    }

    public double powerOfTwoNumbers(int a, int b){
        double result = Math.pow(a, b);
        System.out.println(a + " to the power of " + b + " equals: " + result);
        return result;
    }

    public ArrayList<Integer> fibonacci(int N)
    {
        int num1 = 0, num2 = 1;
        int counter = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        // Iterate till counter is N
        while (counter < N) {
            // Print the number
            arr.add(num1);
            System.out.print(num1 + " ");

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
        System.out.println();
        return arr;
    }

    public int[] sortDesc(int [] arr) {
        //Initialize array
        int temp;

        //Displaying elements of original array
        System.out.println("Elements of original array: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }

        //Sort the array in ascending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println();

        //Displaying elements of array after sorting
        System.out.println("Elements of array sorted in descending order: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();

        return arr;
    }

    public boolean checkPrimeNumber(int a) {
        boolean flag = true;
        if (a == 0 || a == 1)
            flag = false;
        for (int i = 2; i <= a / 2; ++i) {
            // condition for nonprime number
            if (a % i == 0) {
                flag = false;
                break;
            }
        }
        System.out.println(a + " is a prime number = " + flag);
        return flag;
    }

    public String getMonthNameInGerman(LocalDate date) {
        return date.monthOfYear().getAsText(Locale.GERMAN);
    }

    public String formatDate(LocalDate date) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MMMM, yyyy");
        return date.toString(fmt);
    }

    static class Student {
        private String studentName;
        private double studentGradeAverage;

        public Student(String studentName, double studentGradeAverage) {
            this.studentName = studentName;
            this.studentGradeAverage = studentGradeAverage;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public double getStudentGradeAverage() {
            return studentGradeAverage;
        }

        public void setStudentGradeAverage(int studentGradeAverage) {
            this.studentGradeAverage = studentGradeAverage;
        }
    }

    public String serializeStudentObject(Student student) {
        Gson gson = new Gson();
        return gson.toJson(student);
    }

    public int mockDivide(int a, int b){
        // Dividing a and b = not implemented yet
        System.out.println("6 : 2 = 3");
        return 3;
    }

    public boolean mockCheckPalindrome(String word) {
        //Assuming result to be true
        boolean result = true;

        //checking palindrome - not implemented yet

        System.out.println(word + " is palindrome = " + result);
        return result;
    }

}
