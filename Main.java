package com.wallet;

import com.wallet.service.WalletService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WalletService walletService = new WalletService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Bienvenido a la Billetera Digital de Gatitos!");

        while (!exit) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Saldo actual: " + walletService.checkBalance());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double depositAmount = scanner.nextDouble();
                    walletService.addFunds(depositAmount);
                    System.out.println("Se han depositado " + depositAmount + " exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        walletService.spendFunds(withdrawAmount);
                        System.out.println("Se han retirado " + withdrawAmount + " exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Gracias por usar la Billetera Digital de Gatitos!");
    }
}
