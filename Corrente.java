import java.util.ArrayList;

public class Corrente extends Conta implements Pix {

    public Corrente(String numConta, String nomeCorrentista, int cpf) {
        super(numConta, nomeCorrentista, cpf);
    }

    public void imprimeDinheiro (){
        System.out.println("A pessoa " + this.nomeCorrentista + " possui " + this.saldo);
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    protected void depositar(double valor){
        this.saldo += valor;
        this.historico.add(new Operacao(valor, "deposito"));

    }

    protected void sacar(double valor){
        this.saldo -= valor;
        this.historico.add(new Operacao(valor, "saque"));
    }

    // i
    public void cadastraPix(ArrayList<Integer> listaPix) {
        listaPix.add(this.cpf);
        this.historico.add(new Operacao(0, "Cadastro PIX"));
    }

    // ii
    public void efetuaPix(Corrente destinatario, double valor) {
        // checa se o donatario possui o valor da transferencia
        if(this.saldo >= valor){
            if(valor > 0){
                this.saldo -= valor;
                destinatario.recebePix(this.cpf, valor);
                this.historico.add(new Operacao(valor, "PIX enviado"));
            } else {
                System.out.println("Você não pode realizar uma transacão com este valor!");
            }
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void recebePix(int cpfDonatario, double valor){
        this.saldo += valor;
        this.historico.add(new Operacao(valor, "PIX recebido"));
        System.out.println("Pix recebido da pessoa de CPF " + cpfDonatario + " de valor R$" + valor);
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
