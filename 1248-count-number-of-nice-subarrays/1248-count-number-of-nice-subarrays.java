class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int[] arr,int k){
        int n=arr.length;
        int l=0,r=0,cnt=0;
        int cntOdd=0;

        while(r<n){
            if(arr[r]%2!=0){
                cntOdd++;
            }
            while(cntOdd>k){
                if(arr[l]%2!=0){
                    cntOdd--;
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}