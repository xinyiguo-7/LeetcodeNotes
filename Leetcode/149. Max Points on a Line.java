class Solution {
    public int maxPoints(int[][] points) {
        HashMap<int[], List<int[]>> map = new HashMap<>();
        int m = 0, b = 0;
        int y1 = points[0][1];
        int y2 = points[1][1];
        int x1 = points[0][0];
        int x2 = points[1][0];
        m = (y2 - y1) / (x2 - x1);
        b = y1 - m * x1;
        List<int[]> newList = new ArrayList<>(Arrays.asList(points[0], points[1]));
        map.put(new int[]{m, b}, newList);
        
        for(int i = 2; i < points.length; i++) {
            y1 = points[i][1];
            x1 = points[i][0];
            for(int[] line : map.keySet()) {
                m = line[0];
                b = line[1];
                if(y1 == m * x1 + b) {
                    map.get(line).add(points[i]);
                } else {
                    for(int[] point : map.get(line)) {
                        y2 = point[1];
                        x2 = point[0];
                        m = (y2 - y1) / (x2 - x1);
                        b = y1 - m * x1;
                        int[] newLine = new int[]{m, b};
                        if(!map.containsKey(newLine)) {
                            newList = new ArrayList<>(Arrays.asList(points[i], point));
                            map.put(newLine, newList);
                        } else {
                            map.get(newLine).add(points[i]);
                        }
                    }
                }
            }
        }
        int maxNum = 0;
        for(List<int[]> linePoints : map.values()) {
            maxNum = Math.max(maxNum, linePoints.size());
        }
        return maxNum;
    }
}