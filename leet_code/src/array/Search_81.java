package array;

/**
 * @author: jianglei
 * @date: 2020/2/8 21:24
 * <p>
 * 题号：#81 搜索旋转排序数组II
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。
 * 若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * <p>
 * 进阶:
 * 这是 搜索旋转排序数组 的延伸题目，
 * 本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？
 * 会有怎样的影响，为什么？
 */
public class Search_81 {
    private static boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[mid] > nums[left]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};

        int target1 = 0;
        boolean search1 = search(nums, target1);
        System.out.println(search1);

        int target2 = 3;
        boolean search2 = search(nums, target2);
        System.out.println(search2);

        int[] nums1 = {1, 3, 5};
        boolean search = search(nums1, 1);
        System.out.println(search);

        int[] nums2 = {1, 1, 3, 1};
        boolean search3 = search(nums2, 3);
        System.out.println(search3);
    }
}
