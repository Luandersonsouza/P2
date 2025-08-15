public abstract class Contribuinte {
    private String nome;
    private double rendaAnual;

    public Contribuinte(String nome, double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public abstract double calcularImposto();

    @Override
    public String toString() {
        return nome + ": R$ " + String.format("%.2f", calcularImposto());
    }
}