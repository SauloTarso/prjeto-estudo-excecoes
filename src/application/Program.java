package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int num = sc.nextInt();
            System.out.print("Data de entrada (DD/MM/AAAA): ");
            Date entrada = sdf.parse(sc.next());
            System.out.print("Data de saída (DD/MM/AAAA): ");
            Date saida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(num, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");
            System.out.print("Data de entrada (DD/MM/AAAA): ");
            entrada = sdf.parse(sc.next());
            System.out.print("Data de saída (DD/MM/AAAA): ");
            saida = sdf.parse(sc.next());

            reserva.atualizarDatas(entrada, saida);
            System.out.println("Reserva: " + reserva);
        } catch (ParseException e) {
            System.out.println("Formato de data invalida");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Número errado: o número do quarto deve ser números inteiros");
        }
        sc.close();
    }
}
