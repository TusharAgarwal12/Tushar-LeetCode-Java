class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int ele = st.pop();

                int nse=i;
                int pse = st.isEmpty()?-1:st.peek();

                maxArea=Math.max(maxArea,(nse-pse-1)*heights[ele]);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=n;
            int ele=st.pop();
            int pse=st.isEmpty()?-1:st.peek();
            
            maxArea=Math.max(maxArea,heights[ele]*(nse-pse-1));
        }
        return maxArea;
    }
}