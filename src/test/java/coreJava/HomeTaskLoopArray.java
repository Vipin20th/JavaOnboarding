package coreJava;

public class HomeTaskLoopArray {

    public static int maxSpan(int[] nums) {
        int span = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    tmp = j - i + 1;
                    span = Math.max(tmp, span);
                }
            }
        }
        return span;
    }

    public static boolean canBalance(int[] nums) {
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    public static int countClumps(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] &&
                    (i == 0 || nums[i - 1] != nums[i])) {
                count++;
            }
        }
        return count;
    }

    public static int maxMirror(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i)
            for (int j = max + 1; j < nums.length - i + 1; ++j)
                for (int k = i; k < nums.length - j + 1; ++k) {
                    Boolean mir = true;
                    for (int m = 0; mir && m < j; ++m)
                        mir = nums[i + m] == nums[k + j - m - 1];
                    if (mir) max = j;
                }
        return max;
    }

    public static boolean linearIn(int[] outer, int[] inner) {
        int count = 0;
        for (int i = 0; i < inner.length; i++) {
            for (int j = 0; j < outer.length; j++) {
                if (inner[i] == outer[j]) {
                    count++;
                    break;
                }
            }
        }
        if (count == (inner.length)) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(HomeTaskLoopArray.maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}));
        System.out.println(HomeTaskLoopArray.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
        System.out.println(HomeTaskLoopArray.linearIn(new int[]{1, 2, 4, 6}, new int[]{2, 3, 4}));
        System.out.println( HomeTaskLoopArray.canBalance(new int[]{10, 10}));
        System.out.println(HomeTaskLoopArray.countClumps(new int[]{1, 1, 2, 1, 1}));
    }
    //1. Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
    //
    //maxSpan([1, 2, 1, 1, 3]) â†’ 4
    //maxSpan([1, 4, 2, 1, 4, 1, 4]) â†’ 6
    //maxSpan([1, 4, 2, 1, 4, 4, 4]) â†’ 6
    //
    //Test your code at : http://codingbat.com/prob/p189576
    //
    //
    //2. Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
    //
    //canBalance([1, 1, 1, 2, 1]) â†’ true
    //canBalance([2, 1, 1, 2, 1]) â†’ false
    //canBalance([10, 10]) â†’ true
    //
    //Test your code at :http://codingbat.com/prob/p158767
    //
    //
    //3. Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.
    //
    //countClumps([1, 2, 2, 3, 4, 4]) â†’ 2
    //countClumps([1, 1, 2, 1, 1]) â†’ 2
    //countClumps([1, 1, 1, 1, 1]) â†’ 1
    //
    //Test your code at : http://codingbat.com/prob/p193817
    //
    //4. We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
    //
    //maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) â†’ 3
    //maxMirror([1, 2, 1, 4]) â†’ 3
    //maxMirror([7, 1, 2, 9, 7, 2, 1]) â†’ 2
    //
    //Test your code at : http://codingbat.com/prob/p196409
    //
    //5. Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.
    //
    //linearIn([1, 2, 4, 6], [2, 4]) â†’ true
    //linearIn([1, 2, 4, 6], [2, 3, 4]) â†’ false
    //linearIn([1, 2, 4, 4, 6], [2, 4]) â†’ true
    //
    //Test your code at :http://codingbat.com/prob/p134022
}
