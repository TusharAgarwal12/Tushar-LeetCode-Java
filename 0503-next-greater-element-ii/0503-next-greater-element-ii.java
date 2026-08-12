class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st = new Stack<>();

        int[] ans =new int[n];

        for(int i=2*n-1;i>=0;i--){
            int ind=i%n;
            int curr=nums[ind];

            while(!st.isEmpty() && st.peek()<=curr){
                st.pop();
            }
            if(i<n){
                ans[i]=st.empty()?-1:st.peek();
            }
            st.push(curr);
        }
        return ans;
    }
}