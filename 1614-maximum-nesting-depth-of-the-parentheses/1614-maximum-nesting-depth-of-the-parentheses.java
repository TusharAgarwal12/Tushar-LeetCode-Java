class Solution {
    public int maxDepth(String s) {
        int cnt=0;
        int max=0;

        for(char ch : s.toCharArray()){
            if(ch=='('){
                cnt++;
                if(max<cnt){
                    max=cnt;
                }
            }else if(ch==')'){
                cnt--;
            }
        }
        return max;
    }
}