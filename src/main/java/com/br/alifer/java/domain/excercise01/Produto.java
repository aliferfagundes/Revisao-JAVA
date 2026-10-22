package com.br.alifer.java.domain.excercise01;

public class Produto {
    public enum TypeProduct{
        ELETRONICO(0.9)
        ,
        VESTUARIO(0.85),
        ALIMENTO(1);

        private final double discount;
        public double afterDiscountValue(double value){
            return discount*value;
        }
        TypeProduct(double discount){
            this.discount = discount;
        }

        public double getDiscount() {
            return discount;
        }
    }


    private String name;
    private double price;
    private long quantityInStock;
    private TypeProduct typeProduct;


    public boolean stockReduce(int boughtQuantity){
        if(quantityInStock <= 0|| quantityInStock<boughtQuantity){
            System.out.println("Estoque Insuficiente para compra!");
            return false;
        }else if (boughtQuantity == 0){
            System.out.println("Compra não realizado pois o valor é nulo!");
            return false;
        }
        quantityInStock -= boughtQuantity;
        return true;
    }

    public Produto(String name, double price, long quantityInStock, TypeProduct typeProduct) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.typeProduct = typeProduct;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
