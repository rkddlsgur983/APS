package jungol;

import java.util.Scanner;

public class JO_1169_주사위던지기 {
    private static final int[] dice = {1,2,3,4,5,6};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        switch (m) {
            case 1 -> game1(0, n, new int[n]);
            case 2 -> game2(0, n, new int[n]);
            case 3 -> game3(0, n, new int[n], new boolean[6]);
        }
        sc.close();
    }

    private static void game1(int cnt, int n, int[] temp) {

        if (cnt == n) {
            StringBuilder sb = new StringBuilder();
            for (int j : temp) {
                sb.append(j).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int die : dice) {
            temp[cnt] = die;
            game1(cnt + 1, n, temp);
        }
    }

    private static void game2(int cnt, int n, int[] temp) {

        if (cnt == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < dice.length; i++) {
            if (cnt > 0 && temp[cnt-1] > dice[i]) continue;
            temp[cnt] = dice[i];
            game2(cnt+1, n, temp);
        }
    }

    private static void game3(int cnt, int n, int[] temp, boolean[] visited) {

        if (cnt == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < dice.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[cnt] = dice[i];
                game3(cnt+1, n, temp, visited);
                visited[i] = false;
            }
        }
    }
}
