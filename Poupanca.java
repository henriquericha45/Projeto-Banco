public class Poupanca extends Conta implements Remunerada {

    public Poupanca(String numConta, String nomeCorrentista, int cpf) {
        super(numConta, nomeCorrentista, cpf);
    }

    protected void depositar(double valor){
        this.saldo += valor;
        this.historico.add(new Operacao(valor, "deposito"));
        
    }

    protected void sacar(double valor){
        this.saldo -= valor;
        this.historico.add(new Operacao(valor, "saque"));

    }

    public void aplicaCorrecao(){
        this.saldo += this.saldo * 0.015;
        this.historico.add(new Operacao(this.saldo * 0.015, "correcao (+)"));

    }

    public String getNumConta() {
		return this.numConta;
	}

    public void imprimirConta() {
        System.out.println("Numero conta: " + this.numConta);
        System.out.println("Nome correntista: " + this.nomeCorrentista);
        System.out.println("CPF correntista: " + this.cpf);
        System.out.println("Saldo: " + this.saldo);
    }
    
}
