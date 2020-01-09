// class Solution {
//     public List<List<String>> findDuplicate(String[] paths) {
//         HashMap<String,String> myMap = new HashMap();
//         for (String p: paths){
//             String[] l = p.split(" ");
//             String pathName = l[0];
//             for (int i = 1; i < l.length;i++){
//                 String content = l[i].split("\\(")[1].replace(")", "");
//                 String fileName = l[i].split("\\(")[0];
//                 String filePath = pathName + "/" + fileName;
//                 myMap.put(filePath,content);
//             }    
//         }
//         HashMap<String,List<String>> newMap = new HashMap();
//         HashMap<String,Integer> numMap = new HashMap();
        
//         for (String k:myMap.keySet()){
//             String key = myMap.get(k);
//             numMap.put(key,numMap.getOrDefault(key, 0)+1);
//             if (!newMap.containsKey(myMap.get(k))){
//                 List<String> pathList = new ArrayList<>();
//                 pathList.add(k);
//                 newMap.put(myMap.get(k),pathList);

//             } else {
//                 List<String> newList = newMap.get(myMap.get(k));
//                 newList.add(k);
//                 newMap.put(myMap.get(k),newList);
//             } 
//         }
        
//         List<List<String>> resList = new ArrayList<>();
//         for (String key:newMap.keySet()){
//             if (numMap.get(key)>1){
//                 resList.add(newMap.get(key));
//             }
//         }
//         return resList;
//     }
// }

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> myMap = new HashMap();
        List<List<String>> resList = new ArrayList<>();
        for (String p: paths){
            String[] l = p.split(" ");
            String pathName = l[0];

            for (int i = 1; i < l.length;i++){
                String content = l[i].split("\\(")[1].replace(")", "");
                String fileName = l[i].split("\\(")[0];
                String filePath = pathName + "/" + fileName;

                List<String> pathList = new ArrayList<>();
                if(!myMap.containsKey(content)){
                    pathList.add(filePath);
                    myMap.put(content,pathList);
                } else {
                    pathList = myMap.get(content);
                    pathList.add(filePath);
                    myMap.put(content,pathList);
                }  
            }

        }
        for (String key:myMap.keySet()){
            if(myMap.get(key).size()>1){
                resList.add(myMap.get(key));
            }
            
        }
        return resList;
    }
}    