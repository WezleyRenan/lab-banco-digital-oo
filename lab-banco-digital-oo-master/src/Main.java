import java.util.Scanner;

public static void main(String[] args) {
    Cliente cliente = new Cliente();
    Scanner input = new Scanner(System.in);


    System.out.println("--------  seja bem vindo(a) ------");
    System.out.println("por favor informe seu nome");
    String nome = input.next();
    cliente.setNome(nome);
    Conta cc = new ContaCorrente(cliente);
    Conta poupanca = new ContaPoupanca(cliente);


    int operacao = 0; //responsavel por definir a operaçao utilizada
    int escolha; //utilizado pra definir a escolha no switch case
    do {
        System.out.println("Digite um dos seguintes comandos: \n conta corrente = 1 \n conta poupança = 2 \n sair = 3");
        escolha = input.nextInt();
        switch (escolha) {
            case 1:

                while (operacao != 4) {
                    System.out.println("você esta na conta corrente!!! \n escolha uma das operações \n sacar = 1 \n depositar = 2 \n transferir = 3 \n sair = 4");
                    operacao = input.nextInt();
                    if (operacao == 1) {
                        System.out.println("digite a quantidade que você quer sacar");
                        double saque = input.nextDouble();
                        cc.sacar(saque);
                    } else if (operacao == 2) {
                        System.out.println("digite a quantidade que você quer depositar");
                        double deposito = input.nextDouble();
                        cc.depositar(deposito);
                    } else if (operacao == 3) {
                        System.out.println("digite a quantidade que você quer transferir para a poupança");
                        double transferir = input.nextDouble();
                        cc.transferir(transferir, poupanca);
                    } else if (operacao == 4) {
                        System.out.println("saindo da conta corrente");
                    } else {
                        System.out.println("comando invalido");
                    }

                }
                break;
            case 2:
                operacao = 0;
                while (operacao != 4) {
                    System.out.println("você esta na conta poupança!!! \n escolha uma das operações \n sacar = 1 \n depositar = 2 \n transferir = 3 \n sair = 4");
                    operacao = input.nextInt();
                    if (operacao == 1) {
                        System.out.println("digite a quantidade que você quer sacar");
                        double saque = input.nextDouble();
                        poupanca.sacar(saque);
                    } else if (operacao == 2) {
                        System.out.println("digite a quantidade que você quer depositar");
                        double deposito = input.nextDouble();
                        poupanca.depositar(deposito);
                    } else if (operacao == 3) {
                        System.out.println("digite a quantidade que você quer transferir para a conta corrente");
                        double transferir = input.nextDouble();
                        poupanca.transferir(transferir, cc);
                    } else if (operacao == 4) {
                        System.out.println("saindo da conta poupança");
                    } else {
                        System.out.println("comando invalido");
                    }

                }
				break;
			case 3:
				System.out.println("saindo...");
                break;
            default:
                System.out.println("comando invalido");
        }
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
		System.out.println("==========================================");
    } while (escolha != 3);
	System.out.println("volte sempre");
}




