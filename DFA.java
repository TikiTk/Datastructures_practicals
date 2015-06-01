/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author administrator
 */
public class DFA {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("myDFA.text"));
        String mainArr[][] = new String[5][4];
        int rowIndx = 0;
        int indxHolder = 1;
        int tmp = 0;

        while (br.ready()) {

            String tmpData = br.readLine();
            if (tmpData.length() > 0) {

                if (tmpData.charAt(0) != '#') {
                    if (tmpData.charAt(tmpData.length() - 1) == '.') {
                        String arrData[] = tmpData.split(";");
                        for (int i = 0; i < arrData.length; i++) {
                            mainArr[rowIndx][i] = arrData[i].trim().replace(".", "");
                        }
                        rowIndx++;

                    } else {

                        for (int i = 0; i < tmpData.length(); i++) {
                            tmp = getIndexOf(mainArr[0], "" + tmpData.charAt(i));
                            String tmpI = "" + mainArr[indxHolder][tmp].charAt(1);
                            indxHolder = Integer.parseInt(tmpI);
                        }
                        if (mainArr[indxHolder][mainArr[0].length - 1].equals("*")) {
                            System.out.println("accept: " + tmpData);
                        } else {
                            System.out.println("reject: " + tmpData);
                        }
                        indxHolder = 1;
                        tmp = 0;
                        rowIndx = 0;

                    }
                }

            }

        }

    }

    public static int getIndexOf(String tmp[], String val) {
        for (int i = 0; i < tmp.length; i++) {
            if (val.equals(tmp[i])) {
                return i;
            }
        }
        return -1;
    }

}
