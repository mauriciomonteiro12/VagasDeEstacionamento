public class ReservationEntry {
    private final String residentName;
    private final String vehiclePlate;

    public ReservationEntry(String residentName, String vehiclePlate) {
        this.residentName = residentName;
        this.vehiclePlate = vehiclePlate;
    }

    @Override
    public String toString() {
        return "Nome: " + residentName + ", Placa: " + vehiclePlate;
    }
}
