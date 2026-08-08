class MinStack {
    private Stack<Long> st;
    private long min;

    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            min=value;
            st.push((long) value);
            return;
        }
        else{
            if(value > min) st.push((long) value);
            else{
                st.push(2L*value - min);
                min=value;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long x=st.pop();

        if(x<min){
            min = 2*min - x;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        long x = st.peek();

        if(min<x) return (int) x;

        return (int) min;
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;

        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */