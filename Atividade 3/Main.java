import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try {
        
            System.out.println("=== DADOS DA RESERVA ===");
            System.out.print("Número do quarto: ");
            int numeroQuarto = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Data de entrada (dd/MM/yyyy): ");
            LocalDate entrada = LocalDate.parse(scanner.nextLine(), formatter);
            
            System.out.print("Data de saída (dd/MM/yyyy): ");
            LocalDate saida = LocalDate.parse(scanner.nextLine(), formatter);
            
            
            ReservaHotel reserva = new ReservaHotel(numeroQuarto, entrada, saida);
            
            
            System.out.println("\n=== RESERVA CONFIRMADA ===");
            System.out.println(reserva);
            
            
            System.out.println("\n=== ATUALIZAÇÃO DA RESERVA ===");
            System.out.print("Nova data de entrada (dd/MM/yyyy): ");
            LocalDate novaEntrada = LocalDate.parse(scanner.nextLine(), formatter);
            
            System.out.print("Nova data de saída (dd/MM/yyyy): ");
            LocalDate novaSaida = LocalDate.parse(scanner.nextLine(), formatter);
            
            
            reserva.atualizarDatas(novaEntrada, novaSaida);
            
            System.out.println("\n=== RESERVA ATUALIZADA ===");
            System.out.println(reserva);
            
        } 
        catch (DateTimeParseException e) 
        {
            System.out.println("Erro: Formato de data inválido. Use o formato dd/MM/yyyy.");
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally {
            scanner.close();
        }
    }
}