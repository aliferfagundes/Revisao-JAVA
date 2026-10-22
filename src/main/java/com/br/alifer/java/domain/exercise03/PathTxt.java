package com.br.alifer.java.domain.exercise03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class PathTxt {
    private List<String> lines = new ArrayList<>();
    private List<Double> values = new ArrayList<>();
    private List<LocalDate> dates = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    public void readTxt(File file){
        try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
            for(String r: br.readAllLines()) {
                lines.add(r);
            }
        }catch (IOException io){
            System.out.println(io.getMessage());
        }

        for(String r: lines){
            String[] helperValue = r.split(";");
            LocalDate date = LocalDate.parse(helperValue[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dates.add(date);
            Double d = Double.parseDouble(helperValue[2]);
            values.add(d);
            names.add(helperValue[1]);
        }
    }
    public void gerateReport(){
        StringBuilder stringBuilder = new StringBuilder();
        double finalValue = 0.0;
        int index = 0;
        int i = 0;
        double compare = values.getFirst();
        String mostSpender;
        for(Double d: values){

            finalValue += d.doubleValue();
            if(compare<d.doubleValue()){
                compare = d.doubleValue();
                index = i;
            }
            i++;
        }

        List<String> lines = new ArrayList<>();
        lines.add("Valor total gerado: R$" + finalValue);
        lines.add("Cliente com maior valor de compra: "+ names.get(index) + ": R$"+ values.get(index) );
        for(int j=0; j<i;j++){
            lines.add("["+dates.get(j).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).replace("-", "/")+ "] - "+ names.get(j)+ ": " +(j+1)+ " |" + " valor: "+ "R$ " + values.get(j).doubleValue());
        }
        for (String s :lines) {
            stringBuilder.append(s+"\n");
        }

        System.out.println(stringBuilder);
    }
    public void readTxt(String path){
        File file = new File(path);
        readTxt(file);
    }

    public List<String> getLines() {
        return lines;
    }
}
