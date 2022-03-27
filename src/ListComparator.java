import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ListComparator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> firstList = null;
            List<String> secondList = null;
            for (int i = 0; i < 2; i++) {
                System.out.println("Введите число:");
                int n = Integer.parseInt(reader.readLine());
                if (i == 0) {
                    firstList = fillList(reader, n);
                }
                else {
                    secondList = fillList(reader, n);
                }
            }
            Map<String, String> map = compareLists(firstList, secondList);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.printf("%s:%s\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    private static List<String> fillList(BufferedReader reader, int n) throws IOException {
        List<String> list = new ArrayList<>();
        System.out.printf("Введите %d строк(и)\n", n);
        for (int i = 0; i < n; i++) {
            list.add(reader.readLine());
        }
        return list;
    }
    public static Map<String, String> compareLists(List<String> first, List<String> second) {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < first.size(); i++) {
            if (!second.contains(first.get(i))) {
                map.put(first.get(i), "?");
            }
            for (int j = 0; j < second.size(); j++) {
                if (second.get(j).contains(first.get(i))) {
                    map.put(first.get(i), second.get(j));
                }
            }
        }
        return map;
    }
}