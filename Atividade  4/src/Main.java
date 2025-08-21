package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            
            System.out.println("=== DADOS DA CONTA BANCÁRIA ===");
            System.out.print("Número da conta: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); 
            
            System.out.print("Titular: ");
            String titular = scanner.nextLine();
            
            System.out.print("Saldo inicial: R$ ");
            double saldo = scanner.nextDouble();
            
            System.out.print("Limite de saque: R$ ");
            double limiteSaque = scanner.nextDouble();
            
            
            ContaBancaria conta = new ContaBancaria(numero, titular, saldo, limiteSaque);
            
          
            System.out.println("\n=== CONTA CRIADA COM SUCESSO ===");
            System.out.println(conta);
            
         
            System.out.println("\n=== OPERAÇÃO DE SAQUE ===");
            System.out.print("Valor do saque: R$ ");
            double valorSaque = scanner.nextDouble();
            
            conta.sacar(valorSaque);
            
            System.out.println("\n=== SAQUE REALIZADO COM SUCESSO ===");
            System.out.println("Novo saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (LimiteSaqueExcedidoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}