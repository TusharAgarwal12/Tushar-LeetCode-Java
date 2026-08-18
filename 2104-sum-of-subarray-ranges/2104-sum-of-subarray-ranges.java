class Solution {
    public long subArrayRanges(int[] nums) {
        return subArrayMax(nums)-subArrayMin(nums);
    }
    private long subArrayMin(int[] arr){
        int n=arr.length;
        int[] findnse=NSE(arr);
        int[] findpse=PSE(arr);

        long sum=0;

        for(int i=0;i<n;i++){
            int left = i-findpse[i];
            int right = findnse[i]-i;

            sum += 1L*left * right * arr[i];
        }
        return sum;

    }
    private long subArrayMax(int[] arr){
        int n=arr.length;
        int[] findnge=NGE(arr);
        int[] findpge=PGE(arr);

        long sum=0;

        for(int i=0;i<n;i++){
            int left = i-findpge[i];
            int right = findnge[i]-i;

            sum += 1L*left * right * arr[i];
        }
        return sum;
    }
    private int[] NSE(int[] arr){
        int n=arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();

            st.push(i);
        }
        return ans;
    }
    private int[] NGE(int[] arr){
        int n=arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();

            st.push(i);
        }
        return ans;
    }
    private int[] PSE(int[] arr){
        int n=arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();

            st.push(i);
        }
        return ans;
    }
    private int[] PGE(int[] arr){
        int n=arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();

            st.push(i);
        }
        return ans;
    }
}