package org.lesson.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Carrello {

    private Product[] cartProduct;

    public Carrello() {
        this.cartProduct = new Product[0];
    }

    public void addToCart(Product addProduct) {
        Product[] updatedCart = new Product[cartProduct.length + 1];
        System.arraycopy(cartProduct, 0, updatedCart, 0, cartProduct.length);
        updatedCart[updatedCart.length - 1] = addProduct;
        cartProduct = updatedCart;
    }

    public void getCartProduct() {
        if (cartProduct.length != 0) {
            for (Product product : cartProduct) {
                System.out.println(product);
            }
        } else {
            System.out.println("Il carrello è vuoto.");
        }
    }

    public static boolean isDiscountCard(String inputCard) {
        if (inputCard.equalsIgnoreCase("si")) {
            return true;
        }
        return false;

        // return inputCard.equalsIgnoreCase("si");
    }

    public String getProductDescriptionWithDiscount(Product product, boolean hasLoyaltyCard) {
        // Calcola il prezzo scontato CON IVA e formattalo a 2 decimali
        BigDecimal discountedPriceWithIva = product.getDiscountedPrice(hasLoyaltyCard)
                .multiply(BigDecimal.ONE.add(new BigDecimal(product.getIva())))
                .setScale(2, RoundingMode.HALF_UP
        );

        BigDecimal basePriceWithIva = product.getPriceWithIva().setScale(2, RoundingMode.HALF_UP);

        String formattedBasePriceWithIvaStr = basePriceWithIva.toPlainString();
        String formattedDiscountedPriceWithIvaStr = discountedPriceWithIva.toPlainString();

        String description = product.toString();

        description += String.format(" | Prezzo con IVA (base): %s ", formattedBasePriceWithIvaStr);

        if (basePriceWithIva.compareTo(discountedPriceWithIva) != 0) {
            description += String.format(" | Prezzo con IVA (scontato): %s ", formattedDiscountedPriceWithIvaStr);
        }

        return description;
    }

    public void getCartProduct(boolean hasLoyaltyCard) {
        if (cartProduct.length != 0) {
            for (Product product : cartProduct) {
                System.out.println(getProductDescriptionWithDiscount(product, hasLoyaltyCard));
            }
            for (Product product : cartProduct) {
                System.out.println(
                    getProductDescriptionWithDiscount(product, hasLoyaltyCard)+
                    "prezzo scontato a: "
                    +product.getDiscountedPrice(hasLoyaltyCard)
                );
            }
            BigDecimal somma= new BigDecimal(0);
            for (Product product : cartProduct) {
                somma=somma.add(product.getPriceWithIva());
            }
            System.out.println(
               "Somma senza sconto con iva: "+somma
            );
        } else {
            System.out.println("Il carrello è vuoto.");
        }
    }

    public static void main(String[] args) {

        Carrello cart = new Carrello();
        Scanner sc = new Scanner(System.in);
        boolean isChoice = true;

        System.out.println("Sei in possesso della nostra tessera sconto? (si/no)");
        String discountMethod = sc.nextLine();
        boolean hasLoyaltyCard = isDiscountCard(discountMethod);
        System.out.println("Hai la tessera sconto: " + hasLoyaltyCard);

        while (isChoice) {

            System.out.println("\nChe cosa vuoi fare?");
            System.out.println("1 - Aggiungere un televisore");
            System.out.println("2 - Aggiungere uno smartphone");
            System.out.println("3 - Aggiungere delle cuffie");
            System.out.println("4 - Vedere il carrello");
            System.out.println("0 - Chiudere");
            System.out.println();
            System.out.print("Scelta: ");

            String inputUtente = sc.nextLine();

            switch (inputUtente) {
                case "1":
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
                    String smart = sc.nextLine();
                    boolean isSmartTv = smart.equalsIgnoreCase("si");
                    cart.addToCart(new Television(nomeTv, marcaTv, prezzoTv, ivaTv / 100, dimensioniTv, isSmartTv));
                    System.out.println("Televisore aggiunto al carrello.");
                    break;
                case "2":
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
                    cart.addToCart(new Smartphone(nomeSm, marcaSm, prezzoSm, ivaSm / 100, memoriaSm));
                    System.out.println("Smartphone aggiunto al carrello.");
                    break;
                case "3":
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
                    String wirelessString = sc.nextLine();
                    boolean isWireless = wirelessString.equalsIgnoreCase("si");
                    cart.addToCart(new Headphones(nomeHp, marcaHp, prezzoHp, ivaHp / 100, coloreHp, isWireless));
                    System.out.println("Cuffie aggiunte al carrello.");
                    break;
                case "4":
                    System.out.println("\n--- Carrello ---");
                    cart.getCartProduct(hasLoyaltyCard);
                    System.out.println("----------------");
                    break;
                case "0":
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