package Zad1;

public class func {

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
        int temp = 0;

        //Displaying elements of original array
        System.out.println("Elements of original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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

}
