public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String sent = String.join(" ", sentence) + " ";
        int start = 0;
        int l = sent.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (sent.charAt(start % l) == ' ') start++;
            else {
                while (start > 0 && sent.charAt((start - 1) % l) != ' ')
                    start--;
            }
        }
        return start / l;
    }
}

// a little bit optimized

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, len = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            int end = start % len;
            if (end == 0) continue;
            if (s.charAt(end) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }
}

// another way
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), start = 0;
        while (rows-- > 0) {
            start += cols/len*len + cols%len-1;
            if (s.charAt(start%len) == ' ') {
                start++;
            } else if (s.charAt((start + 1)%len) == ' ') {
                start += 2;
            } else {
                while (start > 0 && s.charAt((start - 1)%len) != ' ') start--;
            }
        }
        return start/len;
    }
}
