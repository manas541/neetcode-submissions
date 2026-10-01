class Solution {
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int oldMax = maxProduct;
            int oldMin = minProduct;

            maxProduct = Math.max(
                nums[i],
                Math.max(
                    nums[i] * oldMax,
                    nums[i] * oldMin
                )
            );

            minProduct = Math.min(
                nums[i],
                Math.min(
                    nums[i] * oldMax,
                    nums[i] * oldMin
                )
            );

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}