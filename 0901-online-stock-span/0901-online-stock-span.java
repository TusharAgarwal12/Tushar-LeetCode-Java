class StockSpanner {
    Stack<int[]> st;  // it is same as Stack<Pair<int,int>> st
    int ind;
    public StockSpanner() {
        ind=-1;
        st=new Stack<>();
    }
    
    public int next(int price) {
        ind=ind+1;

        while(!st.isEmpty() && st.peek()[0]<=price){  // st.peek[0] is same as st.peek().first
            st.pop();
        }
        int ans=ind-(st.isEmpty()?-1:st.peek()[1]);
        st.push(new int[]{price,ind});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */