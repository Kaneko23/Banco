/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kaue_brito
 */
public class Application {

    public List<Account> listAccount;

    public void init() {
        System.out.println("Iniciando app...");
        listAccount = new ArrayList<>();

        {
            Account acc = new Account("Kauê", 123, 2000.0);

            listAccount.add(acc);
        }
        {
            Account acc = new Account("Lucas", 234, 2300.0);
            listAccount.add(acc);

        }
        {
            Account acc = new Account("Erik", 334, 4000.0);
            listAccount.add(acc);
        }

    }

    public void run() {

        boolean answer = true;
        do {
            String option = JOptionPane.showInputDialog("Bem vindo ao Banco do Kauê " + "\n digite:" + "\n 1 - Cadastrar Conta" + "\n 2 - Consultar" + "\n 3- Saque" + "\n 4 - Deposito");
            switch (option) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    lookAccount();
                    
                case "3":
                    withDraw();
                    break;
                case "4":
                    deposit();
                    break;
                default:
                    answer = false;
                    break;
            }
        } while (answer == false);

    }

    private void showMessage(String message) {

        JOptionPane.showMessageDialog(null, message);

    }

    private void deposit() {

        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta"));

        Account acc = null;

        for (int i = 0; i < listAccount.size(); i++) {

            if (listAccount.get(i).getAccountNumber().equals(accountNumber)) {

                acc = listAccount.get(i);

            }

        }

        if (acc != null) {

            Double value = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor que você deseja depositar?"));

            acc.deposit(value);

        } else {

            showMessage("Erro: Conta não encontrada! Operação cancelada.");

        }

    }

    private void withDraw() {

        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta"));
        String accountOwner = JOptionPane.showInputDialog("Digite o nome do titular da conta");

        Account acc = null;

        for (int i = 0; i < listAccount.size(); i++) {

            if (listAccount.get(i).getAccountNumber().equals(accountNumber) && listAccount.get(i).getOwnerName().equals(accountOwner)) {

                acc = listAccount.get(i);

            }

        }

        if (acc != null) {

            Double value = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor que você deseja sacar?"));

            Double newBalance = acc.withDraw(value);

            if (newBalance == -1.0) {

                showMessage("Valor indisponível para saque!");

            } else {

                showMessage("Você ainda tem disponível o valor de: R$ " + newBalance);

            }

        } else {

            showMessage("Erro: Conta não encontrada! Operação cancelada.");

        }

    }

    private void createAccount() {
        String ownerName = JOptionPane.showInputDialog("Digite o seu nome: ");

        int maxAccountNumber = listAccount.stream().mapToInt(Account::getAccountNumber).max().orElse(0);

        int nextAccountNumber = maxAccountNumber + 1;

        listAccount.add(new Account(ownerName, nextAccountNumber, 0.0));

        JOptionPane.showMessageDialog(null, "Nova conta criada para " + ownerName + " o seu número de conta " + nextAccountNumber);

    }

    private void lookAccount() {
        boolean serch = false;
        String consProduct = JOptionPane.showInputDialog("Insira o nome da conta que deseja consultar consultar");

        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getOwnerName().equals(consProduct)) {
                JOptionPane.showMessageDialog(null, listAccount.get(i));
                serch = true;

            }
        }
        if (!serch) {
            JOptionPane.showMessageDialog(null, "erro");
        }

    }

}

//            for (int i = 0; i < listAccount.size(); i++) {
//
//                if (listAccount.get(i).getOwnerName().equals("Erik")) {
//                    Double newBalance = listAccount.get(i).deposit(10000.00);
//                    newBalance = listAccount.get(i).withDraw(10002.00);
//
//                    System.out.println(listAccount.get(i).getNumberAccount() + " " + listAccount.get(i).getOwnerName() + " " + newBalance);
//
//                }
