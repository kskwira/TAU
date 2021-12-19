import com.google.gson.Gson;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

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

    public String getMonthNameInJapanese(LocalDate date) {
        return date.monthOfYear().getAsText(Locale.JAPANESE);
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

}
