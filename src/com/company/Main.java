package com.company;

import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Random random = new Random();
        int[][] arr = new int[10][10];

        int x = 0, y = 0,s=0;
        for (int l = 0; l < 20; l++) {
            x = random.nextInt(9) + 1;
            y = random.nextInt(9) + 1;
            arr[x][y] = 1;
        }
        for (int k = 0; k < 10; k++) {
            arr[0][k] = 1;
            arr[k][0] = 1;
            arr[9][k] = 1;
            arr[k][9] = 1;
        }
        arr[1][1] = 3;
        arr[8][8] = 4;
        int r = 1, c = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(arr[i][j] + "  ");
            System.out.println();
        }
        Thread.sleep(1000);
        while (true) {
            if (arr[r][c+1]==1)
                if (arr[r+1][c]==1)
                    if (arr[r][c-1]==1)
                        if (arr[r-1][c]==1){
                            s=1;
                            break;
                        }

            if (r==8 && c==8)
                break;
            if (arr[r][c + 1] != 1) {
                arr[r][c + 1] = 3;
                arr[r][c] = 0;
                c++;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++)
                        System.out.print(arr[i][j] + "  ");
                    System.out.println();
                }
                Thread.sleep(1000);
                continue;
            }
            if (arr[r + 1][c] != 1) {
                arr[r + 1][c] = 3;
                arr[r][c] = 0;
                r++;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++)
                        System.out.print(arr[i][j] + "  ");
                    System.out.println();
                }
                Thread.sleep(1000);
                continue;
            }
            if (arr[r][c - 1] != 1) {
                arr[r][c - 1] = 3;
                arr[r][c] = 1;
                c--;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++)
                        System.out.print(arr[i][j] + "  ");
                    System.out.println();
                }
                Thread.sleep(1000);
                continue;
            }
            if (arr[r - 1][c] != 1) {
                arr[r - 1][c] = 3;
                arr[r][c] = 1;
                r--;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++)
                        System.out.print(arr[i][j] + "  ");
                    System.out.println();
                }
                Thread.sleep(1000);
                continue;
            }
            System.out.flush();


        }
        if (s==1)
            System.out.println("stucked");
        else System.out.println("achieved the cheese");

    }
}
