import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listaPix = new ArrayList<Integer>();
        ArrayList<Conta> contas = new ArrayList<Conta>();
        
        int opcao = -1;
        Scanner leitor = new Scanner(System.in);
        String numConta;
        String nomeCorrentista;
        int cpf;
        Double valor;
        Conta conta;


        do {



            System.out.println("*******************************");
            System.out.println("*            BANCO            *");
            System.out.println("*******************************");
            System.out.println("");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar conta corrente");
            System.out.println("2 - Cadastrar conta poupanca");
            System.out.println("3 - Efetuar deposito");
            System.out.println("4 - Efetuar saque");
            System.out.println("5 - Aplica correcao");
            System.out.println("6 - Cadastra PIX");
            System.out.println("7 - Efetua PIX");
            System.out.println("8 - Consulta Extrato");
            System.out.println("8 - Listar Contas Cadastradas");

            System.out.println("Insira a opcao que deseja: ");
            opcao = leitor.nextInt();



            switch (opcao) {
                case 1:
                    //cria uma conta corrente
                    System.out.println("Insira o numero da conta: ");
                    numConta = leitor.next();
                    
                    numConta = "001" + numConta;
                    System.out.println("Insira o nome do correntista: ");
                    nomeCorrentista = leitor.next();
                    System.out.println("Insira o CPF do correntista: ");
                    cpf = leitor.nextInt();
                    
                    conta = new Corrente(numConta, nomeCorrentista, cpf);
                    contas.add(conta);
                    System.out.println("Conta corrente criada!");
                    
                    break;
                    
                case 2:
                    // cria uma conta poupanca
                    System.out.println("Insira o numero da conta: ");
                    numConta = leitor.next();
                    numConta = "013" + numConta;
                    System.out.println("Insira o nome do correntista: ");
                    nomeCorrentista = leitor.next();
                    System.out.println("Insira o CPF do correntista: ");
                    cpf = leitor.nextInt();

                    conta = new Poupanca(numConta, nomeCorrentista, cpf);
                    contas.add(conta);
                    System.out.println("Conta corrente poupanca!");
                    break;

                case 3: 
                    // efetua um deposito
                    System.out.println("Insira a conta que deseja depositar: ");
                    numConta = leitor.next();
                    System.out.println("Insira o valor do deposito: ");
                    valor = leitor.nextDouble();
                    
                    
                    for (int i=0; i<contas.size(); i++) {
                        if(contas.get(i).numConta.equals(numConta)){
                            contas.get(i).depositar(valor);
                        }
                    }
                    
                    /* 
                    for (Conta c : contas) {
                        if(c.getNumConta().equals(numConta)) {
                            c.depositar(valor);
                        }
                    }
                    */
                    break;

                case 4:
                    // efetua um saque
                    System.out.println("Insira a conta que deseja sacar: ");
                    numConta = leitor.next();
                    System.out.println("Insira o valor do saque: ");
                    valor = leitor.nextDouble();
                    
                    for (Conta c : contas) {
                        if(c.getNumConta().equals(numConta)) {
                            c.sacar(valor);
                            break;
                        }
                    }

                    break;
                case 5:
                    // aplica correcao (poupanca)

                    System.out.println("Insira a conta poupança que deseja aplicar correção: ");
                    numConta = leitor.next();
                    
                    for (Conta c : contas) {
                        if(c.getNumConta().equals(numConta)) {
                            if(c instanceof Poupanca) {
                                ((Poupanca) c).aplicaCorrecao();
                            } else {
                                System.out.println("Não é uma conta poupança");
                            }

                            break;
                        }
                    }

                    break;
                case 6:
                    // cadastra PIX

                    System.out.println("Insira a conta que deseja cadastrar PIX: ");
                    numConta = leitor.next();

                    for (Conta c : contas) {
                        if(c.getNumConta().equals(numConta)) {
                            if(c instanceof Corrente) {
                                ((Corrente) c).cadastraPix(listaPix);
                            } else {
                                System.out.println("Não é uma conta corrente");
                            }

                            break;
                        }
                    }


                    break;
                case 7:
                    // efetua PIX

                    System.out.println("Insira a conta de ORIGEM do PIX: ");
                    numConta = leitor.next();
                    System.out.println("Insira a chave PIX da pessoa que deseja enviar: ");
                    cpf = leitor.nextInt();
                    System.out.println("Insira o valor a ser transferido: ");
                    valor = leitor.nextDouble();
                    for(Conta c : contas){
                        if(c.cpf == cpf){
                        for (Conta co : contas) {
                            if(co.getNumConta().equals(numConta)) {
                                if(co instanceof Corrente) {

                                    ((Corrente) co).efetuaPix((Corrente) c , valor);

                                } else {
                                    System.out.println("Não é uma conta corrente");
                                }

                                break;
                            }
                            
                            }
                                                        
                        }
                    }



                    break;
                case 8:
                    // consulta extrato
                    

                    break;

                case 9:
                    //imprimir contas cadastradas

                    System.out.println("Contas cadastradas: ");                
                    for (Conta c : contas) {
                        c.imprimirConta();
                    }
                        
                    break;


                default:
                    break;
            }


        } while(opcao!=0);

    }
}