import java.util.*;

public class Main {

    // CONSTRAINT: -2³¹ < number < 2³¹ - 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (up to 9 digits): ");
        int number = sc.nextInt();

        int[] nums = String.valueOf(number).chars().map(Character::getNumericValue).toArray();

        String largestNum = largestNumber(nums);
        int largestNumAsInt = Integer.parseInt(largestNum);
        int reversedNum = reverseInteger(largestNumAsInt);

        int result = largestNumAsInt - reversedNum;
        System.out.println("Given Number: " + number);
        System.out.println("Largest Number: " + largestNumAsInt);
        System.out.println("Smallest Number: " + reversedNum);
        System.out.println("Difference: " + result);

        sc.close();
    }

    public static String largestNumber(int[] nums) {
        ArrayList<String> strArr = new ArrayList<>();

        for (int num : nums) {
            strArr.add(String.valueOf(num));
        }

        Collections.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
        if (strArr.get(0).equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String str : strArr) {
            result.append(str);
        }

        return result.toString();
    }

    public static int reverseInteger(int number) {
        int reversedNum = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNum = reversedNum * 10 + digit;
            number = number / 10;
        }

        return reversedNum;
    }
}