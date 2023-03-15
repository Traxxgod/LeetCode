class Solution {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        // write your code here
        char[] arr = str.toCharArray();
        int i = arr.length-1;
        int j = arr.length-1;
        while(i > 0 && arr[i-1] >= arr[i])i--;
        i--;
        // System.out.println(arr[i]);
        if(i < 0){
            return -1;
        }
        while(i < j && arr[j] <= arr[i])j--;
        
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        String s = "";
        for(int k=0;k<=i;k++){
            s += arr[k];
        }
        for(int k=arr.length-1;k>i;k--){
            s += arr[k];
        }
        if(Long.parseLong(s) > 2147483647){
            return -1;
        }
        return Integer.parseInt(s);
    }
}