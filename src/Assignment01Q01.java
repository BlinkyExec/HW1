public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String str : args) {
            if (str.length() > 0) {
                char firstChar = str.charAt(0);
                if (firstChar % 5 == 0) {
                    System.out.println(firstChar);
                }
            }
        }
    }
}
