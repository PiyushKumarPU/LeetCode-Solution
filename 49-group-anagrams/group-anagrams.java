class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = new String(sorted);
            if (anagramMap.containsKey(sortedStr)) anagramMap.get(sortedStr).add(str);
            else {
                List<String> row = new ArrayList<>();
                row.add(str);
                anagramMap.put(sortedStr, row);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : anagramMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}