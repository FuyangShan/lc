```java
//DFS
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer,Node> map = new HashMap<>();
        return dfs(node, map);
    }
    //DFS traverse Graph, recursively adding clone of each node to the hashmap<Integer, Node>, and return the clone itself
    public Node dfs(Node node, HashMap<Integer,Node> map){
        if (node == null) return node;
        if (map.containsKey(node.val)){
            return map.get(node.val);
        } else {
            Node clone = new Node(node.val,new ArrayList<Node>();
            map.put(clone.val,clone);
            for (Node neighbor: node.neighbors){
                clone.neighbors.add(dfs(neighbor,map));
            }
            return clone;
        }
    }
}

//BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node clone = new Node(node.val, new ArrayList<Node>());
        map.put(clone.val, clone);
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for (Node neighbor: curr.neighbors){
                if (!map.containsKey(neighbor.val)){
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.add(neighbor);
                }    
                map.get(curr.val).neighbors.add(map.get(neighbor.val));
            }
        }
        return clone;
    }
}
```
