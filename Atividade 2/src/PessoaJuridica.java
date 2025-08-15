public class PessoaJuridica extends Contribuinte {
    private int numeroFuncionarios;

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
        if (numeroFuncionarios > 10) {
            return getRendaAnual() * 0.14;
        } else {
            return getRendaAnual() * 0.16;
        }
    }

    @Override
    public String toString() {
        return super.getNome() + " (Pessoa Jurídica): R$ " + String.format("%.2f", calcularImposto());
    }
}