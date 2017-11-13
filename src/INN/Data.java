/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INN;

/**
 *
 * @author Rafif
 */
public class Data {
    private String Data[][] = new String[10][3];

    public String[][] getData() {
        return Data;
    }

    public void setData(String[][] Data) {
        this.Data = Data;
    }
    
    public void setDatabyid(int x, int y,
            String Data){
        this.Data[x][y] = Data;
    }
    
    public String getDatabyid(int x, int y){
        return Data[x][y];
    }
    
    public int checkdatakosong(){
        int no = 0;
        for (int i = 0; i < Data.length; i++) {
            if (Data[i][0] == null) {
                no = i;
            }
        }
        return no;
    }

    @Override
    public String toString() {
        return "Data{" + "Data=" + Data + '}';
    }
}
