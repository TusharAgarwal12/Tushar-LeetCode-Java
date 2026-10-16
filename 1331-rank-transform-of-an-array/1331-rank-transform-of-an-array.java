class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);

        Map<Integer,Integer> mpp = new HashMap<>();
        int rank=1;

        for(int i=0;i<temp.length;i++){
            if(i>0 && temp[i]!=temp[i-1]){
                rank++;
            }
            mpp.put(temp[i],rank);
        }

        int[] ranks=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ranks[i]=mpp.get(arr[i]);
        }
        return ranks;
    }
}