public class NumberExtractor {
    public static void main(String[] args) {
        System.out.println(extractNumber("abc123.4321"));
        System.out.println(extractNumber("abc1234.4321"));
        System.out.println(extractNumber("abc123456"));
        System.out.println(extractNumber("abc123456.1"));
        System.out.println(extractNumber("abc"));
        System.out.println(extractNumber("abc01234.56"));
    }

    private static String extractNumber(String in) {
        int len = in.length();
        int startIndex = -1;
        int endIndex = len;

        for(int i = 0; i < len; i++) {
            if (Character.isDigit(in.charAt(i))) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == -1) {
            return "";
        }
        for(int i = startIndex; i < len; i++) {
            char c = in.charAt(i);
            if(!Character.isDigit(c) && c != '.') {
                endIndex = i;
                break;
            }
        }

        String numberPart = in.substring(startIndex, endIndex);
        int dotIndex = numberPart.indexOf(".");
        if (dotIndex == -1) {
            return numberPart + ".00";
        }else if(dotIndex + 3 <= numberPart.length()){
            return numberPart.substring(0, dotIndex + 3);
        }else {
            return String.format("%-5s", numberPart).replace(" ", "0");
        }
    }
}
