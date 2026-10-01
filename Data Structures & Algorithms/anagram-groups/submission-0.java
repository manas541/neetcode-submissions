class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> ans = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            ans.putIfAbsent(sorted,new ArrayList<>());
            ans.get(sorted).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}
