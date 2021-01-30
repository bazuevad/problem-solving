public class compressString {
    public int compress(char[] chars) {
        int left = 0, curr = 0;
        while(curr<chars.length){
            char last = chars[curr];
            int count = 0;
            while(curr<chars.length&&chars[curr]==last){
                curr++;
                count++;
            }
            chars[left] = last;left++;
            
            if(count!=1){
                for(char ch: Integer.toString(count).toCharArray()){
                    chars[left] = ch;
                    left++;
                }
            }
        }
        return left;
    } 
}