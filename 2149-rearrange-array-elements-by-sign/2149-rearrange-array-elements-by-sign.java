class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        /*int[] arr=new int[n/2];
        int[] arr1=new int[n/2];

        int pos=0;
        int neg=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[pos]=nums[i];
                pos++;
            }else{
                arr1[neg]=nums[i];
                neg++;
            }
        }
        int ans[]=new int[n];
        int a=0,b=1;
        int i=0,j=0;
        for(int k=0;k<n;k++){
            if(k%2==0){
                ans[a]=arr[i];
                a=a+2;
                i++;
            }else{
                ans[b]=arr1[j];
                b=b+2;
                j++;
            }
        }
        return ans;
        */
        int[] ans=new int[n];
        int pos=0,neg=1;

        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ans[neg]=nums[i];
                neg+=2;
            }else{
                ans[pos]=nums[i];
                pos+=2;
            }
        }
        return ans;
    }
}