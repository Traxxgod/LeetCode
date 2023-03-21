class Solution {
    public int minDeletions(String s) {
        int[] fq = new int[26];
        for(int i=0;i<s.length();i++){
            fq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<fq.length;i++){
            System.out.print(fq[i]+" ");
        }
        System.out.println();
        Arrays.sort(fq);
        for(int i=0;i<fq.length;i++){
            System.out.print(fq[i]+" ");
        }
        int count = 0;
        System.out.println();
        for(int i=fq.length-1;i>0;i--){
            while(fq[i] != 0 && fq[i-1] != 0 && fq[i] <= fq[i-1]){
                fq[i-1]--;
                count++;
            }
            if(fq[i]==0){
                count += fq[i-1];
                fq[i-1] = 0;
            }
            System.out.print(fq[i]+" ");
        }
        while(fq[1] != 0 && fq[0] != 0 && fq[1] <= fq[0])count++;

        return count;
    }
}