import java.util.HashMap;
import java.util.Optional;

public class PhoneDirectory {

    public static void main(String[] args) {

        String[] A = {"21234", "543543", "87123"};
        String[] B = {"savy", "savu", "avy"};
        String p = "123";
        System.out.println("sol: " + solution(A, B, p));

    }

    public static String solution(String[] A, String[] B, String P) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length || P == null || P.length() == 0) {
            return "NO CONTACT";
        }
        HashMap<String, String> contactMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            contactMap.put(A[i], B[i]);
        }
        Optional<String> name = contactMap.entrySet().stream()
                .filter(e -> e.getValue().contains(P))
                .map(e -> e.getKey())
                .sorted()
                .findFirst();

        return name.isPresent() ? name.get() : "NO CONTACT";
    }
}
