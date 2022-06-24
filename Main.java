import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listaPix = new ArrayList<Integer>();
        ArrayList<Conta> contas = new ArrayList<Conta>();
        
        Corrente alex = new Corrente(1, "Alex", 41241412);
        Corrente richa = new Corrente(2, "Henrique", 32131131);
        Corrente mataca = new Corrente(3, "Mataca", 9424242);
        contas.add(alex);
        contas.add(richa);

        richa.setSaldo(50);
        richa.efetuaPix(alex, 30);

        richa.cadastraPix(listaPix);
        alex.cadastraPix(listaPix);
        System.out.println("lista: " + listaPix);
        richa.imprimeDinheiro();
        alex.imprimeDinheiro();
        mataca.imprimeDinheiro();
        richa.recebePix(8203131, 50);
        richa.imprimeDinheiro();
        
    }
}