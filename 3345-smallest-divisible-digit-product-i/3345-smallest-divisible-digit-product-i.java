class Solution {
    public int smallestNumber(int n, int t) {
        while(productOfDigits(n)%t!=0){
            n++;
        }
        return n;
    }
    public int productOfDigits(int num){
        int pro=1;
        while(num!=0){
            pro*=num%10;
            num=num/10;
        }
        return pro;
    }
}