import java.util.BitSet;

public class BloomFilter {
    public int filter_len;
    int filter;
/*    public int[] ma;*/

    public BloomFilter(int f_len) {
        filter_len = f_len;
/*        ma = new int[filter_len];*/
        filter = 0;
    }

    public int hash(String str1, int num) {
        int  rand = num;

        int pref = 0;
        int rez = 0;

        for (int i = 1; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);

            rez =  (pref * rand + code) % this.filter_len;

            pref = rez;
        }

        return rez;
    }
    public int hash1(String str1) {
        int mask = 0;
        return mask |= 1 << hash(str1, 17);

/*        return hash(str1, 17);*/
    }

    public int hash2(String str1) {
        int mask = 0;
        return mask |= 1 << hash(str1, 223);

/*        return hash(str1, 223);*/
    }

    public void add(String str1) {
        filter |= hash1(str1);
        filter |= 1 << hash2(str1);

/*        ma[hash1(str1)] = 1;
        ma[hash2(str1)] = 1;*/
    }

    public boolean isValue(String str1) {
        return (filter >> hash1(str1) & 1) == 1 && (filter >> hash2(str1) & 1) == 1;
        // return ma[hash1(str1)] == 1 && ma[hash2(str1)] == 1;
    }
}
