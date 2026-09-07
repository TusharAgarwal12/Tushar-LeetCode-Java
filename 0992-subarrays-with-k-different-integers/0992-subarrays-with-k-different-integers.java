class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int[] arr,int k){
        if(k<=0) return 0;

        int n=arr.length;
        int l=0,r=0,cnt=0;

        HashMap<Integer,Integer> mpp = new HashMap<>();
        
        while(r<n){
            mpp.put(arr[r],mpp.getOrDefault(arr[r],0)+1);

            while(mpp.size()>k){
                mpp.put(arr[l],mpp.get(arr[l])-1);

                if(mpp.get(arr[l])==0){
                    mpp.remove(arr[l]);
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}