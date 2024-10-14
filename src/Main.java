import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        while (true) {
            System.out.println("1. Reservar vaga");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Listar reservas");
            System.out.println("4. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (choice) {
                case 1:
                    System.out.print("Nome do morador: ");
                    String name = scanner.nextLine();
                    System.out.print("Placa do veículo: ");
                    String plate = scanner.nextLine();
                    if (parkingLot.reserveSlot(name, plate)) {
                        System.out.println("Vaga reservada com sucesso!");
                    } else {
                        System.out.println("Todas as vagas estão ocupadas.");
                    }
                    break;

                case 2:
                    System.out.print("Informe o número da vaga para cancelar: ");
                    int slotIndex = scanner.nextInt() - 1;
                    if (parkingLot.cancelReservation(slotIndex)) {
                        System.out.println("Reserva cancelada com sucesso!");
                    } else {
                        System.out.println("Vaga inválida ou já desocupada.");
                    }
                    break;

                case 3:
                    parkingLot.listReservations();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
