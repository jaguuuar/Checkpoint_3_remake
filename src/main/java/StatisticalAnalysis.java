import java.util.*;

public class StatisticalAnalysis {

    private Iterator<String> iterator;
    private Map<String, Integer> elementsMap = new TreeMap<>();

    public StatisticalAnalysis(Iterator<String> iterator) {

        this.iterator = iterator;
        this.setMap();
    }

    private void setMap() {

        while (iterator.hasNext()) {
            String element = iterator.next();
            int index = 1;

            if (elementsMap.containsKey(element))
                index = elementsMap.get(element) + 1;
            elementsMap.put(element, index);
        }
    }

    public int countOf(String... element) {

        int countSum = 0;

        for (int i = 0; i < element.length; ++i) {
            if (this.elementsMap.containsKey(element[i])) {
                int elementCount = this.elementsMap.get(element[i]);
                countSum += elementCount;
            }
        }
        return countSum;
    }

    public int dictionarySize() {

        int dictionarySize = this.elementsMap.size();

        return dictionarySize;
    }

    public int size() {

        int size = 0;
        for (int value : this.elementsMap.values()) {
            size += value;
        }
        return size;
    }

    public Set<String> occurMoreThan(Integer n) {

        Set<String> occurMoreThan = new TreeSet<>();

        for (String key : this.elementsMap.keySet()) {
            if (this.elementsMap.get(key) > n)
                occurMoreThan.add(key);
        }
        return occurMoreThan;
    }
}
