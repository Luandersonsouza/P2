import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaHotel {
    private int numeroQuarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    
    // Construtor
    public ReservaHotel(int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        if (dataEntrada.isAfter(dataSaida)) {
            throw new IllegalArgumentException("Data de saída deve ser posterior à data de entrada");
        }
        
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
    
    // Getters
    public int getNumeroQuarto() {
        return numeroQuarto;
    }
    
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    
    public int duracaoEmDias() {
        return (int) ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }
    
    
    public void atualizarDatas(LocalDate novaEntrada, LocalDate novaSaida) {
        if (novaEntrada.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Erro: Alterações só podem ser feitas para datas futuras");
        }
        
        if (novaEntrada.isAfter(novaSaida)) {
            throw new IllegalArgumentException("Erro: Data de saída deve ser posterior à data de entrada");
        }
        
        this.dataEntrada = novaEntrada;
        this.dataSaida = novaSaida;
    }
    
    @Override
    public String toString() {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Quarto: " + numeroQuarto + 
               "\nEntrada: " + dataEntrada.format(formatter) + 
               "\nSaída: " + dataSaida.format(formatter) + 
               "\nDuração: " + duracaoEmDias() + " dias";
    }
}