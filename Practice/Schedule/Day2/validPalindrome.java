package Schedule.Day2;

public class validPalindrome {
    public static boolean find(String str) {
        char[] arr = str.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(arr[i])) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(arr[j])) {
                j--;
            }

            if (Character.toLowerCase(arr[i]) !=
                Character.toLowerCase(arr[j])) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(find("A man, a plan, a canal:Panama"));
        System.out.println(find(" "));
        System.out.println(find("race a Car"));
    }
}