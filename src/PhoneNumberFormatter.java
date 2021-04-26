import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumberFormatter {

    public static void main(String[] args) {
        System.out.println("sol: " + solution("-0 2-1  ----3"));
    }

    public static String solution(String S) {
        List<List<Integer>> formattedNumList = new ArrayList<>();
        List<Integer> numArrList = new ArrayList<>();
        char[] sArr = S.toCharArray();
        for(int i=0;i<sArr.length;i++){
            try {
                int num = Integer.parseInt(String.valueOf(sArr[i]));
                numArrList.add(num);
                if(numArrList.size()==3){
                    formattedNumList.add(numArrList);
                    numArrList = new ArrayList<>();
                }
            }catch (NumberFormatException e){

            }
        }
        if(!numArrList.isEmpty()) {
            if(numArrList.size()==2 || formattedNumList.size()==0) {
                formattedNumList.add(numArrList);
            }else {
                List<Integer> penultimate = formattedNumList.get(formattedNumList.size()-1);
                int penultimateWithin = penultimate.get(2);
                penultimate.remove(2);
                numArrList.add(0,penultimateWithin);
                formattedNumList.add(numArrList);
            }
        }

        return formattedNumList.stream()
                .map(l -> l.stream().map(String::valueOf).collect(Collectors.joining("")))
                .collect(Collectors.joining("-"));

    }
}
