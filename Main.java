import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (up to 9 digits): "); // CONSTRAINT: -2³¹ < number < 2³¹ - 1
        int number = sc.nextInt(); // get input

        int[] nums = String.valueOf(number).chars().map(Character::getNumericValue).toArray(); // for largestNumber method, get nums into java list first

        // calling methods largestNumber & reverseInteger
        String largestNum = largestNumber(nums);
        int largestNumAsInt = Integer.parseInt(largestNum);
        int reversedNum = reverseInteger(largestNumAsInt);
        final int result = largestNumAsInt - reversedNum; // main logic: subtract largest and reversed

        // print final results
        System.out.println("Given Number: " + number);
        System.out.println("Largest Number: " + largestNumAsInt);
        System.out.println("Smallest Number: " + reversedNum);
        System.out.println("Difference: " + result);

        sc.close(); // close input object
    }

    // first method, get the largest number from the input number
    public static String largestNumber(int[] nums) {
        ArrayList<String> strArr = new ArrayList<>(); // arraylist for nums, we need this for list manipulation

        for (int num : nums) {
            strArr.add(String.valueOf(num)); // append numbers to arraylist from java list
        }

        Collections.sort(strArr, (a, b) -> (b + a).compareTo(a + b)); // sorting method: using lambda & the comparator object
        
        if (strArr.get(0).equals("0")) {
            return "0"; // edge case
        }

        StringBuilder result = new StringBuilder();
        for (String str : strArr) {
            result.append(str); // append to string
        }

        return result.toString();
    }

    // second method get the reversed number from the input number
    public static int reverseInteger(int number) {
        int reversedNum = 0;

        // seperate each digit by float and shift it up till number == 0
        while (number != 0) {
            int digit = number % 10;
            reversedNum = reversedNum * 10 + digit;
            number = number / 10;
        }

        return reversedNum;
    }
}
