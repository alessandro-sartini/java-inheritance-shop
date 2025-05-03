package org.lesson.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {

    private Product[] cartProduct;

    public Carrello() {
        this.cartProduct = new Product[0];
    }

    public void addToCart(Product addProduct) {

        Product[] updatedCart = new Product[cartProduct.length + 1];

        for (int i = 0; i < cartProduct.length; i++) {
            updatedCart[i] = cartProduct[i];
        }
        updatedCart[updatedCart.length - 1] = addProduct;

        cartProduct = updatedCart;

    }

    public void getCartProduct() {

        if (cartProduct != null) {

            for (Product product : cartProduct) {
                System.out.println(product);
            }

        } else {
            System.out.println("Il carrello è vuoto.");
        }

    }

    public static void main(String[] args) {

        Carrello cart = new Carrello();
        Scanner sc = new Scanner(System.in);
        boolean isChoice = true;

        System.out.println("Benvenuto nel carrello!");

        while (isChoice) {
            System.out.println("\nChe cosa stai inserendo?");
            System.out.println();
            System.out.println("tv per aggiungere un televisore");
            System.out.println("smartphone per aggiungere un smartphone");
            System.out.println("headphone per aggiungere un headphone");
            System.out.println("show per vedere il carrello");
            System.out.println("x per chiudere");
            System.out.println();

            String inputUtente = sc.nextLine();

            switch (inputUtente.toLowerCase()) {
                case "smartphone":
                    System.out.print("Inserisci il nome dello Smartphone: ");
                    String nomeSm = sc.nextLine();
                    System.out.print("Inserisci la marca dello Smartphone: ");
                    String marcaSm = sc.nextLine();
                    System.out.print("Inserisci il prezzo dello Smartphone: ");
                    BigDecimal prezzoSm = new BigDecimal(sc.nextLine());
                    System.out.print("Inserisci l'IVA dello Smartphone: ");
                    float ivaSm = Float.parseFloat(sc.nextLine());
                    System.out.print("Inserisci la memoria dello Smartphone (GB): ");
                    int memoriaSm = Integer.parseInt(sc.nextLine());
                    cart.addToCart(new Smartphone(nomeSm, marcaSm, prezzoSm, ivaSm/100, memoriaSm));
                    System.out.println("Smartphone aggiunto al carrello.");
                    break;
                case "tv":
                    System.out.print("Inserisci il nome del Televisore: ");
                    String nomeTv = sc.nextLine();
                    System.out.print("Inserisci la marca del Televisore: ");
                    String marcaTv = sc.nextLine();
                    System.out.print("Inserisci il prezzo del Televisore: ");
                    BigDecimal prezzoTv = new BigDecimal(sc.nextLine());
                    System.out.print("Inserisci l'IVA del Televisore: ");
                    float ivaTv = Float.parseFloat(sc.nextLine());
                    System.out.print("Inserisci le dimensioni in pollici del Televisore: ");
                    int dimensioniTv = Integer.parseInt(sc.nextLine());
                    System.out.print("Il televisore è smart? (si/no): ");
                    String smart=sc.nextLine();
                    boolean isSmartTv = false;
                    if (smart.toLowerCase().equals("si")) {
                        isSmartTv=true;
                    }else{
                        isSmartTv=false;
                    }
                    cart.addToCart(new Television(nomeTv, marcaTv, prezzoTv, ivaTv/100, dimensioniTv, isSmartTv));
                    System.out.println("Televisore aggiunto al carrello.");
                    break;
                case "headphone":
                    System.out.print("Inserisci il nome delle Cuffie: ");
                    String nomeHp = sc.nextLine();
                    System.out.print("Inserisci la marca delle Cuffie: ");
                    String marcaHp = sc.nextLine();
                    System.out.print("Inserisci il prezzo delle Cuffie: ");
                    BigDecimal prezzoHp = new BigDecimal(sc.nextLine());
                    System.out.print("Inserisci l'IVA delle Cuffie: ");
                    float ivaHp = Float.parseFloat(sc.nextLine());
                    System.out.print("Inserisci il colore delle Cuffie: ");
                    String coloreHp = sc.nextLine();
                    System.out.print("Le cuffie sono wireless? (si/no): ");
                    boolean isWireless = false;
                    String wirlessString = sc.nextLine();
                    if (wirlessString.toLowerCase().equals("si")) {
                        isWireless=true;
                    }else{
                        isWireless=false;
                    }
                    cart.addToCart(new Headphones(nomeHp, marcaHp, prezzoHp, ivaHp/100, coloreHp, isWireless));
                    System.out.println("Cuffie aggiunte al carrello.");
                    break;
                case "show":
                    System.out.println("\n--- Carrello ---");
                    cart.getCartProduct();
                    System.out.println("----------------");
                    break;
                case "x":
                    isChoice = false;
                    System.out.println("Grazie per aver fatto acquisti!");
                    sc.close();
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}