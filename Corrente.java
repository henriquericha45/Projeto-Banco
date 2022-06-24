import java.util.ArrayList;

public class Corrente extends Conta implements Pix {

    public Corrente(int numConta, String nomeCorrentista, int cpf) {
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
    }

    protected void sacar(double valor){
        this.saldo -= valor;
    }

    // i
    public void cadastraPix(ArrayList<Integer> listaPix) {
        listaPix.add(this.cpf);
    }

    // ii
    public void efetuaPix(Corrente destinatario, double valor) {
        // checa se o donatario possui o valor da transferencia
        if(this.saldo >= valor){
            if(valor > 0){
                this.saldo -= valor;
                destinatario.recebePix(this.cpf, valor);
            } else {
                System.out.println("Você não pode realizar uma transacão com este valor!");
            }
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void recebePix(int cpfDonatario, double valor){
        this.saldo += valor;
        System.out.println("Pix recebido da pessoa de CPF " + cpfDonatario + " de valor R$" + valor);
    }
    
}
