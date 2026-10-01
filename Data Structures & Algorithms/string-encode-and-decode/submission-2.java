class Solution {

    public String encode(List<String> strs) {
        StringBuilder str =new StringBuilder("");
        for(String s : strs){
            str.append(s.length());
            str.append("#");
            str.append(s);
           
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        //StringBuilder temp = new StringBuilder();
        int i =0;
        while(i<str.length()){
            int j =i;
            while(str.charAt(j)!='#') j++ ;
            int len = Integer.parseInt(str.substring(i, j));
            i=j+1;
            ans.add(str.substring(i,i+len));
            i=i+len;

        }

        return ans;
}}
