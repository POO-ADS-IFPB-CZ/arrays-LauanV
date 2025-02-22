package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] descricoes = new String[100];
        double[] precos = new double[100];
        double[] quantidades = new double[100];
        int totalItens = 0;

        boolean continuar = true;

        while (continuar) {
            System.out.print("\nDeseja continuar com a venda? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (!resposta.equals("S")) {
                double total = 0;
                for (int i = 0; i < totalItens; i++) {
                    total += precos[i] * quantidades[i];
                }
                System.out.printf("Venda finalizada. Total: R$%.2f%n", total);
                break;
            }

            System.out.println("\n=== Menu de Vendas ===");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Exibir Total");
            System.out.println("3. Exibir Itens");
            System.out.println("4. Finalizar");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do produto: ");
                    descricoes[totalItens] = scanner.nextLine();

                    System.out.print("Preço unitário: ");
                    precos[totalItens] = Double.parseDouble(scanner.nextLine());

                    System.out.print("Quantidade: ");
                    quantidades[totalItens] = Double.parseDouble(scanner.nextLine());

                    totalItens++;
                    System.out.println("Item adicionado!");
                    break;

                case 2:
                    double totalExibir = 0;
                    for (int i = 0; i < totalItens; i++) {
                        totalExibir += precos[i] * quantidades[i];
                    }
                    System.out.printf("Total da venda: R$%.2f%n", totalExibir);
                    break;

                case 3:
                    if (totalItens == 0) {
                        System.out.println("Nenhum item adicionado.");
                    } else {
                        System.out.println("\nItens da venda:");
                        for (int i = 0; i < totalItens; i++) {
                            System.out.printf("%s | Preço: R$%.2f | Qtd: %.2f | Subtotal: R$%.2f%n",
                                    descricoes[i], precos[i], quantidades[i], precos[i] * quantidades[i]);
                        }
                    }
                    break;

                case 4:
                    double totalFinal = 0;
                    for (int i = 0; i < totalItens; i++) {
                        totalFinal += precos[i] * quantidades[i];
                    }
                    System.out.printf("Venda finalizada. Total: R$%.2f%n", totalFinal);
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}