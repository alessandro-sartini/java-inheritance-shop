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

    // This method seems to be redundant with the one below, consider removing one.
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
        return inputCard.equalsIgnoreCase("si");
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
            BigDecimal totalSumWithIva = new BigDecimal(0); // New variable for total sum with IVA
            BigDecimal totalSumWithDiscountAndIva = new BigDecimal(0); // New variable for total sum with discount and IVA

            System.out.println("--- Dettaglio Prodotti ---");
            for (Product product : cartProduct) {
                System.out.println(getProductDescriptionWithDiscount(product, hasLoyaltyCard));
                // Add price with IVA to the total sum with IVA
                totalSumWithIva = totalSumWithIva.add(product.getPriceWithIva());
                // Add discounted price with IVA to the total sum with discount and IVA
                BigDecimal discountedPriceWithIva = product.getDiscountedPrice(hasLoyaltyCard)
                        .multiply(BigDecimal.ONE.add(new BigDecimal(product.getIva())));
                totalSumWithDiscountAndIva = totalSumWithDiscountAndIva.add(discountedPriceWithIva);
            }
             System.out.println("--------------------------");


            // Display the total sums
            System.out.println(
               "Totale Carrello (senza sconto, con IVA): " + totalSumWithIva.setScale(2, RoundingMode.HALF_UP).toPlainString()
            );

            // Only show the discounted total if there's a loyalty card or if any product has a specific discount
             if (hasLoyaltyCard || totalSumWithIva.compareTo(totalSumWithDiscountAndIva) != 0) {
                 System.out.println(
                    "Totale Carrello (con sconto tessera fedeltà, con IVA): " + totalSumWithDiscountAndIva.setScale(2, RoundingMode.HALF_UP).toPlainString()
                 );
             }


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
                    System.out.print("Inserisci il prezzo base del Televisore: ");
                    BigDecimal prezzoTv = new BigDecimal(sc.nextLine());
                    System.out.print("Inserisci l'IVA del Televisore (es. 0.22 per 22%): ");
                    float ivaTv = Float.parseFloat(sc.nextLine());
                    System.out.print("Inserisci le dimensioni in pollici del Televisore: ");
                    int dimensioniTv = Integer.parseInt(sc.nextLine());
                    System.out.print("Il televisore è smart? (si/no): ");
                    String smart = sc.nextLine();
                    boolean isSmartTv = smart.equalsIgnoreCase("si");
                    cart.addToCart(new Television(nomeTv, marcaTv, prezzoTv, ivaTv, dimensioniTv, isSmartTv));
                    System.out.println("Televisore aggiunto al carrello.");
                    break;
                case "2":
                    System.out.print("Inserisci il nome dello Smartphone: ");
                    String nomeSm = sc.nextLine();
                    System.out.print("Inserisci la marca dello Smartphone: ");
                    String marcaSm = sc.nextLine();
                    System.out.print("Inserisci il prezzo base dello Smartphone: ");
                    BigDecimal prezzoSm = new BigDecimal(sc.nextLine());
                     System.out.print("Inserisci l'IVA dello Smartphone (es. 0.22 per 22%): ");
                    float ivaSm = Float.parseFloat(sc.nextLine());
                    System.out.print("Inserisci la memoria dello Smartphone (GB): ");
                    int memoriaSm = Integer.parseInt(sc.nextLine());
                    cart.addToCart(new Smartphone(nomeSm, marcaSm, prezzoSm, ivaSm, memoriaSm));
                    System.out.println("Smartphone aggiunto al carrello.");
                    break;
                case "3":
                    System.out.print("Inserisci il nome delle Cuffie: ");
                    String nomeHp = sc.nextLine();
                    System.out.print("Inserisci la marca delle Cuffie: ");
                    String marcaHp = sc.nextLine();
                    System.out.print("Inserisci il prezzo base delle Cuffie: ");
                    BigDecimal prezzoHp = new BigDecimal(sc.nextLine());
                    System.out.print("Inserisci l'IVA delle Cuffie (es. 0.22 per 22%): ");
                    float ivaHp = Float.parseFloat(sc.nextLine());
                    System.out.print("Inserisci il colore delle Cuffie: ");
                    String coloreHp = sc.nextLine();
                    System.out.print("Le cuffie sono wireless? (si/no): ");
                    String wirelessString = sc.nextLine();
                    boolean isWireless = wirelessString.equalsIgnoreCase("si");
                    cart.addToCart(new Headphones(nomeHp, marcaHp, prezzoHp, ivaHp, coloreHp, isWireless));
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