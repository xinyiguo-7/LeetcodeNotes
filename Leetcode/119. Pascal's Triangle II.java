// Time Complexity: O(k^2)
// Space Complexity: O(k)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            return new LinkedList<Integer>(Arrays.asList(1));
        }
        // When the row index is >= 1
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(1, 1);
        
        for(int i = 2; i < rowIndex + 1; i++) {
            LinkedList<Integer> arrCopy = (LinkedList)arr.clone();
            for(int j = 1; j < i; j++) {
                if(j == 1) {
                    arrCopy.add(j, arr.get(j) + arr.get(j - 1));
                } else {
                    arrCopy.set(j, arr.get(j) + arr.get(j - 1));
                }
            }
            arr = arrCopy;
        }
        return arr;
    }
}