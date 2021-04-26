import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Node {
    public int val;
    public Node left;
    public Node right;
}

class BinaryTree {


    boolean isEqual(Node mainT, Node sub) {

        if (mainT == null || sub == null) {
            return mainT == null && sub == null;
        }
        return mainT.val == sub.val && isEqual(mainT.left, sub.left) && isEqual(mainT.right, sub.right);
    }

    boolean isSubTree(Node mainT, Node sub) {

        // corner cases
        if (isEqual(mainT, sub)) {
            return true;
        }

        return isSubTree(mainT.left, sub) || isSubTree(mainT.right, sub);
    }


}


public class MSTest {

    private static


    class EventComp{

        private final String bandName;
        private final String venueName;
        private final String timeStr;

        public EventComp(String bandName, String venueName, String timeStr) {
            this.bandName = bandName;
            this.venueName = venueName;
            this.timeStr = timeStr;
        }

        public EventComp(String bandName, String venueName, String timeStr, String date) {
            this.bandName = bandName;
            this.venueName = venueName;
            this.timeStr = timeStr + " " + date;
        }


        public String getBandName() {
            return bandName;
        }

        public String getVenueName() {
            return venueName;
        }

        public String getTimeStr() {
            return timeStr;
        }

        public static String bandNameFormatter(String bn) {
            LinkedList<String> l = new LinkedList<>();
            String[] arr = new String[10];
            int len = arr.length;
            l.addLast("hello");
            if(bn.startsWith("The ")){
                return bn.substring(4);
            }
            return bn;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EventComp eventComp = (EventComp) o;
            return Objects.equals(bandNameFormatter(bandName), bandNameFormatter(eventComp.bandName)) &&
                    Objects.equals(venueName, eventComp.venueName) &&
                    Objects.equals(timeStr, eventComp.timeStr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(bandName, venueName, timeStr);
        }

    }

    public static void main(String[] args) {

        System.out.println(EventComp.bandNameFormatter("The game of The thrones"));
        List<String[]> sl = Arrays.asList(new String[]{"abc","def"},new String[]{"s12","s234"});
        sl.stream()
                .flatMap( Stream::of)
                .map(c -> {
                    //System.out.println(c);
                    return c;
                }).collect(Collectors.toList());


        Map<String, List<String>> myMap2 = new HashMap<String, List<String>>();
        String word1 = "The game of thrones";
        String word2 = "elloh";
        String word3 = "wassa";
        String word4 = "awssa";
        myMap2.computeIfAbsent(sorted(word1), v -> new ArrayList<>()).add(word1);
        myMap2.computeIfAbsent(sorted(word2), v -> new ArrayList<>()).add(word2);
        myMap2.computeIfAbsent(sorted(word3), v -> new ArrayList<>()).add(word3);
        myMap2.computeIfAbsent(sorted(word3), v -> new ArrayList<>()).add(word3);

        List<List<String>> anagramList = myMap2.entrySet()
                .stream()
                .map(e -> e.getValue())
                .filter(l -> l.size() > 1)
                .collect(Collectors.toList());


        myMap2.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ", value:  " + entry.getValue());
        });
    }

    private static String sorted(String word) {
        final char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    /**
     * @param l
     * @param num
     * @return
     */
    public static int[] findPair(List<Integer> l, int num) {

        final Set<Integer> ul = new HashSet<>(l);
        final Integer res = ul.stream()
                .filter(x -> ul.contains(num - x))
                .findAny()
                .orElse(null);

        return res == null ? null : new int[]{res, num - res};
    }




    public Map<String, List<String>> getSchema() {

        Map<String, String> myMap = new HashMap<String, String>() {{
            put("table1", "col1:val1,col2:val2,col3:val3");
            put("c", "d");
        }};
        Map<String, List<String>> myMap2 = new HashMap<String, List<String>>();

        String word = "";
        final char[] arr = word.toCharArray();
        Arrays.sort(arr);
        final String sorted = Arrays.toString(arr);

        myMap2.getOrDefault(sorted, new ArrayList<>()).add(word);

        return new HashMap<>();
    }

    public List<String> getColumnFromTableName(String tableName) {

        final Map<String, List<String>> schema = getSchema();
        final List<String> colValList = schema.get(tableName);
        return colValList.stream().map(el -> el.split(":")[0])
                .collect(Collectors.toList());


    }

    public List<String> getTableNameFromColumn(String column) {
        final Map<String, List<String>> schema = getSchema();
        if (schema == null || schema.isEmpty()) {
            return null;
        }
        schema.entrySet().stream()
                .filter(e -> e.getValue().contains(column))
                .map(e -> e.getKey())
                .collect(Collectors.toList());


        final Map<String, String> schema2 = new HashMap<>();

        schema2.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

        /*schema.entrySet().forEach(
                e->{
                    ArrayList<String> cols = e.getValue();
                    if(cols.contains(column)){
                        ret.add(e.getKey());
                    }
                }
        );

        return ret;
*/

        return null;


    }
}
