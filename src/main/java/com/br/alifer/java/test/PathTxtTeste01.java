package com.br.alifer.java.test;

import com.br.alifer.java.domain.exercise03.PathTxt;

import java.awt.*;

public class PathTxtTeste01 {
    public static void main(String[] args) {


        PathTxt pathTxt = new PathTxt();
        pathTxt.readTxt("C:\\Users\\User\\IdeaProjects\\Review\\src\\vendas.txt");

        pathTxt.gerateReport();
    }
}
