import java.util.ArrayList;

public abstract class Conta {
    protected String numConta;
    protected String nomeCorrentista;
    protected int cpf;
    protected ArrayList<Operacao> historico;
    protected double saldo;

    public Conta (String numConta, String nomeCorrentista, int cpf) {
        this.numConta = numConta;
        this.nomeCorrentista = nomeCorrentista;
        this.cpf = cpf;
        this.historico = new ArrayList<Operacao>();
        this.saldo = 0;
    }

    protected abstract void depositar(double valor);

    protected abstract void sacar(double valor);

    public abstract String getNumConta();

    public abstract void imprimirConta();

    public abstract void imprimirExtrato();
}
