class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length;

        // find the break point
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        // if there is no break point
        if(ind==-1){
            reverse(nums,0,n-1);
            return;
        }
        // find the element which is just greater by ind
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[ind]){
                swap(nums,i,ind);
                break;
            }
        }
        // revrse part after ind
        reverse(nums,ind+1,n-1);
    }
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}