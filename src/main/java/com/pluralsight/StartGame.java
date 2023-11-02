package com.pluralsight;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players will be joining the table? ");
        int numberOfPlayers = scan.nextInt();

        GameLogic gameInstance = new GameLogic(scan);
        gameInstance.startUp(numberOfPlayers);
        scan.close();
    }
}
