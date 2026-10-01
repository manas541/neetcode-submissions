class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Remove indices that are outside the window
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // 2. Remove smaller elements from the back
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {

                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(i);

            // 4. Store maximum once window size becomes k
            if (i >= k - 1) {

                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}