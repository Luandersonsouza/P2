import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraImpostos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contribuinte> contribuintes = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nDados do contribuinte #" + i);
            System.out.print("Pessoa física ou jurídica (f/j)? ");
            char tipo = scanner.nextLine().charAt(0);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Renda anual: ");
            double rendaAnual = scanner.nextDouble();

            if (tipo == 'f') {
                System.out.print("Gastos com saúde: ");
                double gastosSaude = scanner.nextDouble();
                contribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else {
                System.out.print("Número de funcionários: ");
                int numeroFuncionarios = scanner.nextInt();
                contribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
            scanner.nextLine();
        }

        System.out.println("\nImpostos pagos:");
        double totalImpostos = 0.0;
        for (Contribuinte contribuinte : contribuintes) {
            System.out.println(contribuinte);
            totalImpostos += contribuinte.calcularImposto();
        }

        System.out.println("\nTOTAL DE IMPOSTOS ARRECADADOS: R$ " + String.format("%.2f", totalImpostos));
        scanner.close();
    }
}