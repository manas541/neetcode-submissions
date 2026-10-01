class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            int partition1 = left + (right - left) / 2;

            int partition2 = (m + n + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int minRight1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int maxLeft2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int minRight2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition
            if (maxLeft1 <= minRight2 &&
                maxLeft2 <= minRight1) {

                // Odd number of elements
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }

                // Even number of elements
                return (Math.max(maxLeft1, maxLeft2)
                        + Math.min(minRight1, minRight2)) / 2.0;
            }

            // Too many elements from nums1 on the left
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }

            // Too few elements from nums1 on the left
            else {
                left = partition1 + 1;
            }
        }

        return 0.0;
    }
}