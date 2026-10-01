
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> ans = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for (int num : nums) {
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }

        for(int freq : ans.keySet()){
            int frequency = ans.get(freq);
            if(bucket[frequency]==null){
                bucket[frequency]= new ArrayList<>();
            }
            bucket[frequency].add(freq);
        }

        int[] res = new int[k];
        int cnt =0;

        for(int p = bucket.length - 1; p >=0 && cnt<k;p--){
            if(bucket[p]!= null){
                for(int i : bucket[p]){
                    res[cnt++]=i;
                }
            }
        }

        return res;
        
    }
}
