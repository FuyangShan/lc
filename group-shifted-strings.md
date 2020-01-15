class Solution {
	public List<List<String>> groupStrings(String[] strings){
		List<List<String>> res = new ArrayList<>();
		if(strings.length < 1 || strings == null ) return res;
		HashMap<String, List<String>> m = new HashMap<>();
		
		for(String s: strings) {
			char[] ch = s.toCharArray();
			char start = ch[0];
			int gap = start - 'a';
			for(int i =0 ;i < ch.length; i++) {
				ch[i] -= gap;
				if(ch[i] < 'a') {
					ch[i] += 26;
				}
			}
			String key = String.valueOf(ch);
			if(!m.containsKey(key)) m.put(key, new ArrayList<String>());
			m.get(key).add(s);
		}
		
		return new ArrayList<List<String>>(m.values());	
		
	}   
}

