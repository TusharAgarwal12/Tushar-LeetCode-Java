class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;

        int n=matrix.length;
        int m=matrix[0].length;

        int[] height=new int[m];
        int maxArea=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            maxArea=Math.max(maxArea,largestRectangle(height));
        }
        return maxArea;
    }
    public int largestRectangle(int[] height){
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        int n=height.length;

        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:height[i];
            while(!st.isEmpty() && height[st.peek()]>currHeight){
                int ele = st.pop();

                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();

                maxArea=Math.max(maxArea,height[ele]*(nse-pse-1));
            }
            st.push(i);
        }
        return maxArea;
    }
}