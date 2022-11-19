public class BloomFilter {
    public int filter_len;
    int filter;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        filter = 0;
    }

    public int hash(String str1, int rand) {
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
    }

    public int hash2(String str1) {
        int mask = 0;

        return mask |= 1 << hash(str1, 223);
    }

    public void add(String str1) {
        filter |= hash1(str1) | hash2(str1);
    }

    // don't work correctly
    public boolean isValue(String str1) {
        int t1 = hash1(str1);

        if ((filter >> 28 & 1) == 1) {
            System.out.println("!");
        }

        return (filter >> hash1(str1) & 1) == 1 && (filter >> hash2(str1) & 1) == 1;
    }
}

/*public class BloomFilter {
    public int filter_len;
    int filter;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        filter = 0;
    }

    public int hash(String str1, int rand) {
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
    }

    public int hash2(String str1) {
        int mask = 0;

        return mask |= 1 << hash(str1, 223);
    }

    public void add(String str1) {
        filter |= hash1(str1) | hash2(str1);
    }

    public boolean isValue(String str1) {
        return (filter >> hash1(str1) & 1) == 1 && (filter >> hash2(str1) & 1) == 1;
    }
}*/
