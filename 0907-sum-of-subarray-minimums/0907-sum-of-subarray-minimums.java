class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=findNSE(arr);
        int[] pse=findPSE(arr);

        int mod=(int)(1e9+7);
        int sum=0;

        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;

            long ans = right*left*1L;
            int val = (int)((ans*arr[i])%mod);

            sum=(sum+val)%mod;
        }
        return sum;
    }
    private int[] findNSE(int arr[]){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();

            st.push(i);
        }
        return ans;
    }
    private int[] findPSE(int arr[]){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();

            st.push(i);
        }
        return ans;
    }
}