package Util;

public class SuanFaTest {
    public static void main(String[] args) {
        String test = "Test/aaa/aaaa/aaaaa/aaaad/aawdasd";
        String[] test1 = test.split("/");
        String[] before = new String[test1.length - 1];
        for (int index = 0;index < test1.length;index++){
            String last = test1[index];
            for (int j = 0; j < index;j++){
                before[j] = test1[j];
            }
            System.out.println((getStrings(before)+"/"+last).substring(1));
        }
    }

    public static String getStrings(String[] strings){
        StringBuilder string = new StringBuilder();
        for (String s:strings
             ) {
            if (s == null) continue;
            string.append("/");
            string.append(s);
        }
        return string.toString();
    }
}
