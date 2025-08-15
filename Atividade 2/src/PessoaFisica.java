public class PessoaFisica extends Contribuinte {
    private double gastosSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    @Override
    public double calcularImposto() {
        double imposto;
        if (getRendaAnual() < 20000.0) {
            imposto = getRendaAnual() * 0.15;
        } else {
            imposto = getRendaAnual() * 0.25;
        }

        imposto -= gastosSaude * 0.5;
        return Math.max(imposto, 0.0);
    }

    @Override
    public String toString() {
        return super.getNome() + " (Pessoa Física): R$ " + String.format("%.2f", calcularImposto());
    }
}