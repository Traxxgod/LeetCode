class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            int idx = index[i];
            list.add(idx, val);
        }
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}