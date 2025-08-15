package src;
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto() {
    }

    public void cadastrar(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void alterarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Erro: Quantidade insuficiente em estoque.");
        }
    }

    public void mostrarDados() {
        System.out.println("\n--- Dados do Produto ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Quantidade: " + this.quantidade + " unidades");
        System.out.println("Valor total em estoque: R$ " + (this.preco * this.quantidade));
    }
}