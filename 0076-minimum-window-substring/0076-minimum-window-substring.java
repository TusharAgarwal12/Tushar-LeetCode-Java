class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int n1=t.length();

        int l=0,r=0;
        int minlen=Integer.MAX_VALUE;
        int sIndex=-1;
        int cnt=0;

        HashMap<Character,Integer> mpp = new HashMap<>();

        for(int i=0;i<n1;i++){
            mpp.put(t.charAt(i),mpp.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<n){
            char ch=s.charAt(r);
            if(mpp.containsKey(ch) && mpp.get(ch)>0){
                cnt++;
            }
            mpp.put(ch,mpp.getOrDefault(ch,0)-1);

            while(cnt==n1){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sIndex=l;
                }
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))+1);
                if(mpp.get(s.charAt(l))>0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return sIndex==-1?"":s.substring(sIndex,sIndex+minlen);
    }
}