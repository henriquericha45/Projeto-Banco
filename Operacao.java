public class Operacao {
    private int dia;
    private int mes;
    private int ano;
    private double valor;
    private String tipoOperacao;

    public Operacao(int dia, int mes, int ano, double valor, String tipoOperacao) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.valor = valor;
        this.tipoOperacao = tipoOperacao;
    }
}
