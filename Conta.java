import java.util.ArrayList;

public abstract class Conta {
    protected int numConta;
    protected String nomeCorrentista;
    protected int cpf;
    protected ArrayList<Operacao> historico;
    protected double saldo;

    public Conta (int numConta, String nomeCorrentista, int cpf) {
        this.numConta = numConta;
        this.nomeCorrentista = nomeCorrentista;
        this.cpf = cpf;
        this.historico = null;
        this.saldo = 0;
    }

    protected abstract void depositar(double valor);

    protected abstract void sacar(double valor);
}
