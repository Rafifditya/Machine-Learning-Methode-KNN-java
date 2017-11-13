/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INN;

import java.util.Scanner;
import java.lang.Math.*;

/**
 *
 * @author Rafif
 */
public class INN {
    
    static Data dataINN;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
    dataINN = new Data();
         String menu = "y";
         Scanner inputdata = new Scanner(System.in);
         Scanner inputmenu = new Scanner(System.in);
         Scanner inputpilihan = new Scanner(System.in);
         Scanner indeks = new Scanner(System.in);
         int pil = 0;
         DoDataTraining();
         do {
             System.out.println("Menu Kedekatan tetangga");
             System.out.println("1. lihat data fakta");
             System.out.println("2. input data ujian");
             System.out.println("3. keluar program");
             System.out.print("pilihan[1/2/3]:");
             pil = inputpilihan.nextInt();
             
             switch(pil){
                 case 1:
                     tampildata();
                     break;
                 case 2:
                        int no = 0;
                        String input[] = new String[2];
                        float min=0;
                        float jarak;
                        int posisieucldianX = 0;
                        float posisidata[][] = new float[10][2];
                        float umur,kegemukan;
                        for (int i = 0; i < dataINN.getData().length; i++) {
                            if (dataINN.getDatabyid(i, 0) == null) {
                                no = i;
                                break;
                            }
                        }
                        for (int i = 0; i < no; i++) {
                            for (int j = 0; j < 2; j++) {
                                if (dataINN.getDatabyid(i,j).equals("muda") || dataINN.getDatabyid(i,j).equals("gemuk")) {
                                    posisidata[i][j]=10;
                                } else if (dataINN.getDatabyid(i,j).equals("paruhbaya") || dataINN.getDatabyid(i,j).equals("sangatgemuk")){
                                    posisidata[i][j]=20;

                                } else {
                                    posisidata[i][j]=30;
                                }
                            }
                     }
//                        for (int i = 0; i < no; i++) {
//                            System.out.println(posisidata[i][0]+"|"+posisidata[i][1]);
//                     }
                        
                        System.out.println("uji data");
                        System.out.print("umur seseorang [muda/paruhbaya/tua]:");
                        input[0] = inputdata.next().trim();
                        if (input[0].equals("muda")) {
                            umur = 10;
                        }
                        else if(input[0].equals("paruhbaya")){
                            umur = 20;
                        }
                        else if(input[0].equals("tua")){
                           umur = 30;
                        } 
                        else {
                            System.out.println("input salah default ke muda");
                            umur = 10;
                        }
                        System.out.print("kegemukan seseorang [gemuk/sangatgemuk/terlalugemuk]:");
                        input[1] = inputdata.next().trim();
                        if (input[1].equals("gemuk")) {
                            kegemukan = 10;
                        }
                        else if(input[1].equals("sangatgemuk")){
                            kegemukan = 20;
                        }
                        else if(input[1].equals("terlalugemuk")){
                           kegemukan = 30;
                        } 
                        else {
                            System.out.println("inpu salah default ke muda");
                            kegemukan = 10;
                        }
                        
                        for (int i = 0; i < no; i++) {
                                    jarak = (float) (Math.pow(umur-posisidata[i][0],2) + Math.pow(kegemukan-posisidata[i][1],2));
                                    jarak = (float) Math.sqrt(jarak);
                                    System.out.println(jarak);
                                    if (min ==0) {
                                        min = jarak;
                                    }
                                    if (min > jarak) {
                                        min = jarak;
                                        posisieucldianX = i;
                                    }
                     }
                        System.out.println("jarak terdekat = " + min + " sdengan data terdekat table ke-"+posisieucldianX);
                        System.out.println("orang tersebut hipertensi :  " + dataINN.getDatabyid(posisieucldianX, 2));
                        
                     break;
                 case 3:
                     System.exit(0);
                     break;
                 default:
                     System.out.println("menu tidak ada");
                     break;
             }
             System.out.print("kembali kemenu utama[y/t]:");
             menu = inputmenu.next().trim();
        } while (menu.equals("y"));
        
    
    }
    
    private static void DoDataTraining(){
        
         dataINN.setDatabyid(0, 0, "muda");
         dataINN.setDatabyid(0, 1, "gemuk");
         dataINN.setDatabyid(0, 2, "tidak");
         
         dataINN.setDatabyid(1, 0, "muda");
         dataINN.setDatabyid(1, 1, "sangatgemuk");
         dataINN.setDatabyid(1, 2, "tidak");
         
         dataINN.setDatabyid(2, 0, "paruhbaya");
         dataINN.setDatabyid(2, 1, "gemuk");
         dataINN.setDatabyid(2, 2, "tidak");

         dataINN.setDatabyid(3, 0, "paruhbaya");
         dataINN.setDatabyid(3, 1, "terlalugemuk");
         dataINN.setDatabyid(3, 2, "ya");
        
         dataINN.setDatabyid(4, 0, "tua");
         dataINN.setDatabyid(4, 1, "terlalugemuk");
         dataINN.setDatabyid(4, 2, "ya");
    }
    
    private static void tampildata(){
    
        int no = 0;
        for (int i = 0; i < dataINN.getData().length; i++) {
            if (dataINN.getDatabyid(i, 0) == null) {
                no = i;
                break;
            }
        }
        for (int i = 0; i < no; i++) {
            System.out.println(
                    dataINN.getDatabyid(i, 0) + " | " +
                    dataINN.getDatabyid(i, 1) + " | " +
                    dataINN.getDatabyid(i, 2)
            );
        }
    
    }
}
