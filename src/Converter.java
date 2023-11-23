import  java.util.TreeMap;
public class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeYMap = new TreeMap<>();
    public Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
                romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
                romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
                romanKeyMap.put('M', 1000);

                arabianKeYMap.put(1000, "M");
        arabianKeYMap.put(900, "CM");
        arabianKeYMap.put(500, "D");
        arabianKeYMap.put(400, "CD");
        arabianKeYMap.put(100, "C");
        arabianKeYMap.put(90, "XC");
        arabianKeYMap.put(50, "L");
        arabianKeYMap.put(40, "XL");
        arabianKeYMap.put(10, "X");
        arabianKeYMap.put(9, "IX");
        arabianKeYMap.put(5, "V");
        arabianKeYMap.put(4, "IV");
        arabianKeYMap.put(1, "I");

    }
    public boolean isRoman(String number) { return romanKeyMap.containsKey(number.charAt(0));}
    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeYMap.floorKey(number);
            roman += arabianKeYMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
        }
        public int romanToInt(String s) {
            int end = s.length() - 1;
            char[] arr = s.toCharArray();
            int arabian;
            int result = romanKeyMap.get(arr[end]);
            for (int i = end - 1; i >= 0; i--) {
                arabian = romanKeyMap.get(arr[i]);
                if (arabian < romanKeyMap.get(arr[i + 1])) {
                    result -= arabian;
                } else {
                    result += arabian;
                }
            }
            return result;
        }
}