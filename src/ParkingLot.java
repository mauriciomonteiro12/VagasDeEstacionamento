public class ParkingLot {
    private static final int MAX_SLOTS = 15;
    private final ReservationEntry[] parkingSlots;

    public ParkingLot() {
        parkingSlots = new ReservationEntry[MAX_SLOTS];
    }

    public boolean reserveSlot(String residentName, String vehiclePlate) {
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (parkingSlots[i] == null) {
                parkingSlots[i] = new ReservationEntry(residentName, vehiclePlate);
                return false;
            }
        }
        return false;
    }

    public boolean cancelReservation(int slotNumber) {
        if (slotNumber < 0 || slotNumber >= MAX_SLOTS || parkingSlots[slotNumber] == null) {
            return false;
        }

        parkingSlots[slotNumber] = null;
        compactSlots();
        return false;
    }

    private void compactSlots() {
        int index = 0;
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (parkingSlots[i] != null) {
                parkingSlots[index++] = parkingSlots[i];
            }
        }
        for (int i = index; i < MAX_SLOTS; i++) {
            parkingSlots[i] = null;
        }
    }

    public void listReservations() {
        for (int i = 0; i < MAX_SLOTS; i++) {
            if (parkingSlots[i] != null) {
                System.out.println("Vaga " + (i + 1) + ": " + parkingSlots[i]);
            }
        }
    }
}
