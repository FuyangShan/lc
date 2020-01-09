class FileSystem {

    class Dir {
        HashMap<String, Dir> dirs = new HashMap<>();
        HashMap<String, String> files = new HashMap<>();
    }
    Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir curr = root;
        List<String> res = new ArrayList<>();
        if (!path.equals("/")) {
            String[] paths = path.split("/");
            for (int i = 1; i < paths.length - 1; i++) curr = curr.dirs.get(paths[i]);
            if (curr.files.containsKey(paths[paths.length - 1])) {
                res.add(paths[paths.length - 1]);
                return res;
            } else {
                curr = curr.dirs.get(paths[paths.length - 1]);
            }
        }
        res.addAll(new ArrayList<>(curr.dirs.keySet()));
        res.addAll(new ArrayList<>(curr.files.keySet()));
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        Dir curr = root;
        String[] paths = path.split("/");
        for (int i = 1; i < paths.length; i++) {
            if (!curr.dirs.containsKey(paths[i])) 
                curr.dirs.put(paths[i], new Dir());
            curr = curr.dirs.get(paths[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir curr = root;
        String[] paths = filePath.split("/");
        for (int i = 1; i < paths.length - 1; i++) {
            curr = curr.dirs.get(paths[i]);
        }
        String fileName = paths[paths.length - 1];
        curr.files.put(fileName, curr.files.getOrDefault(fileName, "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        Dir curr = root;
        String[] paths = filePath.split("/");
        for (int i = 1; i < paths.length - 1; i++) {
            curr = curr.dirs.get(paths[i]);
        }
        String fileName = paths[paths.length - 1];
        return curr.files.get(fileName);
    }
}
