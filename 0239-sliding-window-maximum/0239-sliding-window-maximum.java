class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;

        List<Integer> list=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1) list.add(nums[dq.peekFirst()]);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}