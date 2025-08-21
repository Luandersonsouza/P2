package src;
public class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;
    private double limiteSaque;
    
    public ContaBancaria(int numero, String titular, double saldo, double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }
    
    public void sacar(double valor) {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                "Erro ao sacar: Saldo insuficiente. Saldo atual: R$ " + String.format("%.2f", saldo)
            );
        }
        
        if (valor > limiteSaque) {
            throw new LimiteSaqueExcedidoException(
                "Erro ao sacar: Valor excede o limite de saque de R$ " + String.format("%.2f", limiteSaque)
            );
        }
        
        saldo -= valor;
    }
    
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        saldo += valor;
    }
    
   
    public int getNumero() {
        return numero;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public double getLimiteSaque() {
        return limiteSaque;
    }
    
    @Override
    public String toString() {
        return "Conta " + numero +
               "\nTitular: " + titular +
               "\nSaldo: R$ " + String.format("%.2f", saldo) +
               "\nLimite de saque: R$ " + String.format("%.2f", limiteSaque);
    }
}