package src;
import java.util.Scanner;

public class GerenciamentoEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto(); 

        System.out.println("=== SISTEMA DE GERENCIAMENTO DE ESTOQUE ===");
        
        System.out.println("\nCADASTRO DO PRODUTO");
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        
        System.out.print("Preço unitário: R$ ");
        double preco = scanner.nextDouble();
        
        System.out.print("Quantidade inicial em estoque: ");
        int quantidade = scanner.nextInt();
        
        produto.cadastrar(nome, preco, quantidade); 
        produto.mostrarDados(); 

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Alterar preço");
            System.out.println("2 - Adicionar ao estoque");
            System.out.println("3 - Remover do estoque");
            System.out.println("4 - Ver dados do produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nNovo preço: R$ ");
                    double novoPreco = scanner.nextDouble();
                    produto.alterarPreco(novoPreco);
                    break;
                case 2:
                    System.out.print("\nQuantidade a adicionar: ");
                    int qtdAdicionar = scanner.nextInt();
                    produto.adicionarEstoque(qtdAdicionar);
                    break;
                case 3:
                    System.out.print("\nQuantidade a remover: ");
                    int qtdRemover = scanner.nextInt();
                    produto.removerEstoque(qtdRemover);
                    break;
                case 4:
                    produto.mostrarDados();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();


        
    }
}