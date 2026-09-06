class Solution {
    public int numberOfSubstrings(String s) {
        int l=0,r=0,cnt=0;
        int n=s.length();
        int[] last={-1,-1,-1};

        while(r<n){
            last[s.charAt(r)-'a']=r;
            
            int mini=Math.min(last[0],Math.min(last[1],last[2]));

            cnt+=mini+1;
            r++;
        }
        return cnt;
    }

}