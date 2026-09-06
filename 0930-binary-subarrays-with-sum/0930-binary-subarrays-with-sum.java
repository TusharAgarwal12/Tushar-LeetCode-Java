class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sub(nums,goal)-sub(nums,goal-1);
    }
    private int sub(int[] arr,int k){
        if(k<0) return 0;

        int l=0,r=0,sum=0,count=0;
        int n=arr.length;

        while(r<n){
            sum=sum+arr[r];

            while(sum>k){
                sum=sum-arr[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}