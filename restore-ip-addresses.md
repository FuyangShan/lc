```java
// Input: "25525511135"
// Output: ["255.255.11.135", "255.255.111.35"]

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null|| s.length() == 0) return res;
        dfs(res, s, "", 0);
        return res;
    }
    private void dfs(List<String> res, String s, String path, int k){
        if (k == 4 || s.isEmpty()){
            if (k == 4 && s.isEmpty()){
                res.add(path.substring(1));
            }
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++){
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                dfs(res, s.substring(i), path + "." + part, k + 1);
        }
    }
}
```
