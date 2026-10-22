package com.br.alifer.java.test;


import com.br.alifer.java.domain.excercise01.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProductTest01 {
    public static void runArrayList(List<Produto> produtos, int buyQuantity){
        produtos.forEach(produto -> {


            boolean bought = produto.stockReduce(buyQuantity);
            if(bought) {
                System.out.println(produto.getName() + " tem o valor original de " + produto.getPrice() + ", teve um desconto de " + String.format("%.2f", ((1 - produto.getTypeProduct().getDiscount()) * 100)) + "%" + " e após o desconto ficou por " + String.format("%.2f", produto.getTypeProduct().afterDiscountValue(produto.getPrice())) + " foram compradas pelo cliente " + buyQuantity + " unidades assim o valor total será de " + (produto.getTypeProduct().afterDiscountValue(produto.getPrice()) * buyQuantity) + " e o estoque do produto agora é de " + produto.getQuantityInStock());
            }
        });

    }
    public static void main(String[] args) {
        Produto produto01 = new Produto("Carne", 29.99,30, Produto.TypeProduct.ALIMENTO);
        Produto produto02 = new Produto("Blusa de Frio", 199.98, 20, Produto.TypeProduct.VESTUARIO);
        Produto produto03 = new Produto("Fogão quatro bocas", 599.98, 5, Produto.TypeProduct.ELETRONICO);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto01);
        produtos.add(produto02);
        produtos.add(produto03);
        runArrayList(produtos, 6);

    }

}
