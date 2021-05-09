import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScotiaTest {

    public static void main(String[] args) {

        // System.out.println( solution("aaBabcDaA"));
        System.out.println(solution3("SMS messages are really short", 12));
    }

    public static String solution(String S) {
        // write your code in Java SE 8

      /*  TreeSet<Character> sortedChars = new TreeSet<>();
        HashSet<Character> hs = new HashSet<>();
        char[] charr = S.toCharArray();
        for(char ch: charr){
            if((Character.isLowerCase(ch) && hs.contains(Character.toUpperCase(ch))) || (Character.isUpperCase(ch) && hs.contains(Character.toLowerCase(ch)))){
                sortedChars.add(ch);
            }
            hs.add(ch);
        }
        return sortedChars.isEmpty()? "NO": String.valueOf(sortedChars.descendingSet().iterator().next()).toUpperCase();
*/
        return "";
    }

    public static int solution3(String S, int K) {

        String message = S;
        List<String> result = new ArrayList<String>();
        int start = 0;
        while (start + K < message.length()) {
            int end = start + 16;
            while (!Character.isWhitespace(message.charAt(end--))) ;
            result.add(message.substring(start, end + 1));
            start = end + 2;
        }
        result.add(message.substring(start));
        System.out.println(result);
        return result.size();
    }


    public static int solution2(String S, int K) {


        if(S==null || S.isEmpty()){
            return 0;
        }

        List<String> words = Arrays.asList(S.split(" "));
        int totMsgs = 0;
        boolean isMiddleWord = false;
        int len = K;
        for (int i = 0; i < words.size(); i++) {
            int wlength = words.get(i).length();
            if (isMiddleWord) {
                wlength++;
            }
            if(wlength > K){
                return 0;
            }
            len -= wlength;
            if (len <= 1) {
                if(len<0){
                    i--;
                }
                totMsgs++;
                len = K;
                isMiddleWord = false;
                continue;
            }
            if(i == words.size()-1){
                totMsgs++;
            }
            isMiddleWord = true;
        }

        return totMsgs;
    }

}
