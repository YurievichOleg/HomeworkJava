public class Design_parking_System {
    int[] slots;

    public Design_parking_System(int big, int medium, int small) {
        slots = new int[3];
        slots[0] = big;
        slots[1] = medium;
        slots[2] = small;

    }

    public boolean addCar(int carType) {
        if (slots[carType - 1] > 0) {
            slots[carType - 1]--;
            return true;
        }
        return false;

    }
}
