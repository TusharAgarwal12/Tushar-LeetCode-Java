class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n=nums1.length;
        int n2=nums2.length;

        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()) mpp.put(nums2[i],-1);
            else mpp.put(nums2[i],st.peek());
            st.push(nums2[i]);
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=mpp.get(nums1[i]);
        }
        return res;
    }
}