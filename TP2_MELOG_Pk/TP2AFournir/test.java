import java.util.*;  
  
public class test {  
    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {  
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());  
  
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));  
  
        Map<String, Integer> sortedMap = new LinkedHashMap<>();  
        for (Map.Entry<String, Integer> entry : list) {  
            sortedMap.put(entry.getKey(), entry.getValue());  
        }  
        return sortedMap;  
    }  

    public static void main(String[] argv){
        Map<String, Integer> unsortedMap = new HashMap<>();  
        unsortedMap.put("A", 5);  
        unsortedMap.put("B", 2);  
        unsortedMap.put("C", 8);  
        unsortedMap.put("D", 1);  
        
        Map<String, Integer> sortedMap = test.sortByValue(unsortedMap);  
        System.out.println(sortedMap); // 输出：{D=1, B=2, A=5, C=8}
    }
}