class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for(int i=1;i<arr.length;i++){
            arr[i] = nums[i]+arr[i-1];
        }
        int val = 0;
        int[] ans = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            val += nums[i];
            ans[i] = Math.abs(arr[i]-val);
        }
        return ans;
    }
}