public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            step += 1;
        }
        return m << step;
    }
}

// solution
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) n ^= (n & -n);
        return n;
    }
}
