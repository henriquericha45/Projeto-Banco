import java.time.LocalDate;

public class Operacao {
    
    private double valor;
    private String tipoOperacao;
    private LocalDate date;

    public Operacao(double valor, String tipoOperacao) {
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
        this.date = LocalDate.now();
    }

    public void imprimirExtrato(){
        System.out.println("Data: " + this.date);
        System.out.println("Tipo Operaca: " + this.tipoOperacao);
        System.out.println("Valor: " + this.valor);
    }
}
