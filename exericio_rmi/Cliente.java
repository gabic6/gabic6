// import java.rmi.Remote;
// import java.rmi.RemoteException;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);
        // operacoes
        System.out.println("Insira a operacao que deseja realizar:");
        System.out.println("\n Soma: s");
        System.out.println("\n Subtracao: sub");
        String operacao = object.nextLine();
        // dois numeros
        System.out.println("\n Insira dois número:");
        Long num1 = object.nextLong();
        System.out.println("\n Insira o segundo número:");
        Long num2 = object.nextLong();

        try {
            if (operacao.equals("s")) {

                AdicaoInterface a = (AdicaoInterface) Naming.lookup("//localhost:3000/AdicaoService");
                System.out.println("Adição : " + a.add(num1, num2));
            } else if (operacao.equals("sub")) {
                SubtracaoInterface a = (SubtracaoInterface) Naming.lookup("//localhost:3001/SubtracaoService");
                System.out.println("Subtração : " + a.subtracao(num1, num2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        object.close();
    }
}