package leetcodejava;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		var smallest = 100000; //out of range
		
		var len = nums.length;
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					var res = nums[i] + nums[j] + nums[k];
					if (Math.abs(res - target) < Math.abs(smallest - target)) {
						smallest = res;
					}
					if (smallest == target) return smallest;
				}
			}
		}
		return smallest;
	}
	
	
	public static void main(String[] args) {
		int[] nums = { -30, -30, 11, 10,3,6};
		int target = 0;
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
	}
}
