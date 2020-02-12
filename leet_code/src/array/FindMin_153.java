package array;

/**
 * @author: jianglei
 * @date: 2020/2/12 16:56
 * <p>
 * 题号：#153 寻找旋转排序数组中的最小值
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMin_153 {
    private static int findMin(int[] nums) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[left];
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int min1 = findMin(nums1);
        System.out.println(min1);

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int min2 = findMin(nums2);
        System.out.println(min2);
    }
}
