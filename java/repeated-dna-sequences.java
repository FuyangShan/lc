class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashSet<Integer> firstSeen = new HashSet<>();
        HashSet<Integer> secondSeen = new HashSet<>();

        int dna = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dna <<= 2;                      // shift 2 digits for next char
            if (c == 'C') dna |= 1;         // mapping char to int [A, C, G, T] -> [0, 1, 2, 3]
            else if (c == 'G') dna |= 2;
            else if (c == 'T') dna |= 3;
            dna &= 0xfffff;                 // remove leading DNA beyond 20 digits
            if (i < 9) continue;
            if (!firstSeen.add(dna) && secondSeen.add(dna)) // 1st.add(dna), then if already added, 2nd.add(dna)
                res.add(s.substring(i - 9, i + 1));
        }
        return res;
    }
}