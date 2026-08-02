class Solution {
    public void moveZeroes(int[] nums) {
        int cnt=0;
        int k=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) cnt++;
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }
}