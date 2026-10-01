class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int count[] = new int[26];
        int freq[] = new int[26];

        for(char c : s1.toCharArray()){
            count[c-'a']++;
        }

        int l=0;
        for(int r=0; r<s2.length();r++){
            freq[s2.charAt(r)-'a']++;
            while(r-l+1>s1.length()){
                freq[s2.charAt(l)-'a']--;
                l++;
            }

            if(Arrays.equals(count,freq)) return true;
        }

        return false;
    }
}
