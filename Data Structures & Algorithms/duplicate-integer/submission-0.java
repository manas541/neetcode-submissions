class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> map = new HashSet<>();
      for(int n : nums){
        if(map.contains(n)) return true;
        map.add(n);
      }
      return false;
    }
}
