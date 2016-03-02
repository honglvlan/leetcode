package algorithm;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int max = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) { // should move i
				i++;
			} else { // should move j
				j--;
			}
		}
		return max;
    }
    
    public static void main(String[] args)
    {
    	int[] h = {2, 1, 100, 100, 1, 3};
    	
    	System.out.println(maxArea(h));
    }
    
}
