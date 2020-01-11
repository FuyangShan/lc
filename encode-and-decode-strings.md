# Encode and Decode Strings
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

 

Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.

```java
public class Codec {

    public String intToString(String s) {
        int len = s.length();
        char[] bytes = new char[4];
        
        for (int i = 3; i >= 0; i--) {
            bytes[3 - i] = (char)(len >> (i * 8) & 0xff);
        }
        return new String(bytes);
    }
    
    public int stringToInt(String str) {
        int result = 0;
        
        for (char c : str.toCharArray()) {
            result += (result << 8) + (int)c;
        }
        return result;
    }
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(intToString(str));
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < s.length();) {
            int len = stringToInt(s.substring(i, i + 4));
            i += 4;
            res.add(s.substring(i, i + len));
            i += len;
        }
        return res;
    }
}
```
