import java.util.ArrayList;

public class Poupanca extends Conta implements Remunerada {

    public Poupanca(int numConta, String nomeCorrentista, int cpf) {
        super(numConta, nomeCorrentista, cpf);
    }

    protected void depositar(double valor){
        this.saldo += valor;
    }

    protected void sacar(double valor){
        this.saldo -= valor;
    }

    public void aplicaCorrecao(){
        this.saldo = this.saldo * 0.015;
    }
    
}
