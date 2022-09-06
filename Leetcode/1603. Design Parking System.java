// Time Complexity: O(1)
// Space Complexity: O(1)
class ParkingSystem {
    int[] numSlots;
    
    public ParkingSystem(int big, int medium, int small) {
        numSlots = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if(numSlots[carType - 1] > 0) {
            numSlots[carType - 1]--;
            return true;
        }
        return false;
    }
}