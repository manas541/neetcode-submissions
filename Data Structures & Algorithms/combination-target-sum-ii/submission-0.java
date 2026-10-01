class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result= new ArrayList<>();
         Arrays.sort(nums);
        backTrack(0,nums,target,new ArrayList(),result);
        return result;
    }
    void backTrack(int index, int[] combination, int target, List<Integer> current, List<List<Integer>> result){
       
        if(target==0){

            result.add(new ArrayList<>(current));
            return;
        }

        if(target<0) return;

        for(int i=index;i<combination.length;i++){

            if (i > index && combination[i] == combination[i - 1]) continue;
            current.add(combination[i]);
            backTrack(i+1,combination,target-combination[i],current,result);
            current.remove(current.size()-1);
        }
    }
}
