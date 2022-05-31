package JavaCore1_Lesson4;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static final char DOT_EMPTY = '-';

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static char[][] field;

    public static char dotHuman;
    public static char dotAi;
    public static int fieldSizeX;
    public static int fieldSizeY;
    public static int scoreHuman;
    public static int scoreAi;
    public static int roundCounter;
    public static int winLength;

    public static void main(String[] args) {
        startNewGame();
    }

    public static void initField(){
        System.out.println("Какого размера должно быть игровое поле?");
        System.out.println("Введите количество клеток по горизонтали:");
        fieldSizeX = scanner.nextInt();
        System.out.println("Введите количество клеток по вертикали:");
        fieldSizeY = scanner.nextInt();
        System.out.println("Какой длины должна быть выигрышная последовательность:");
        winLength = scanner.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    public static void printField(){
        System.out.print("+");

        for (int i = 0; i < fieldSizeX*2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i/2 + 1);
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeX*2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void humanTurn(){
        int x;
        int y;
        do {
            System.out.print("Введите координаты по X:");
            x = scanner.nextInt() - 1;
            System.out.print("Введите координаты по Y:");
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        field[y][x] = dotHuman;
    }

    public static void aiTurn(){
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX) ;
            y = random.nextInt(fieldSizeY) ;
        } while (!isCellValid(y, x));
        field[y][x] = dotAi;
    }

    public static boolean isCellValid(int y, int x){
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
    }

    public static boolean checkDraw(){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == DOT_EMPTY){
                    return false;
                }
            }
        }
        System.out.println("Ничья!");
        return true;
    }

    public static boolean checkWin(char dot){
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if(field[y][x] == dot){
                    int count = 1;
                    //horizontal
                    for (int i = 1; i < winLength; i++) {
                        if (x + i < field[y].length && field[y][x + i] == dot) count++;
                        else count = 1;
                        if(count == winLength) return true;
                        }
                    //vertical
                    for (int i = 1; i < winLength; i++) {
                        if (y + i < field.length && field[y + i][x] == dot) count++;
                        else count = 1;
                        if(count == winLength) return true;
                    }
                    //diagonal down
                    for (int i = 1; i < winLength; i++) {
                        if (y + i < field.length && x + i < field[y].length && field[y + i][x + i] == dot) count++;
                        else count = 1;
                        if(count == winLength) return true;
                    }
                    //diagonal up
                    for (int i = 1; i < winLength; i++) {
                        if (y - i >= 0  && x + i < field[y].length && field[y - i][x + i] == dot) count++;
                        else count = 1;
                        if(count == winLength) return true;
                    }
                }
            }
        }
        return false;
    }



    public static void startNewGame(){
       while (true){
            chooseDot();
            playRound();
            System.out.printf("СЧЁТ:    ИГРОК    КОМПЬЮТЕР\n" +
                    "           %d         %d   \n", scoreHuman, scoreAi);
            System.out.println("Хотите сыграть ещё раз? (Введите да или нет):");
            if(!scanner.next().equalsIgnoreCase("да")){
                System.out.println("До скорых встреч!");
                break;
            }
        }
    }

    private static void playRound(){
        System.out.printf("Round %d start\n", ++roundCounter);
        initField();
        printField();
        if(dotHuman == DOT_X){
            humanFirst();
        } else {
            aiFirst();
        }
    }

    public static void chooseDot(){
        System.out.println("Для игры за крестик введите анг. x, для игры за нолик любое другое значение:");
        if(scanner.next().toLowerCase(Locale.ROOT).equalsIgnoreCase("x")){
            dotHuman = DOT_X;
            dotAi = DOT_0;
        } else {
            dotHuman = DOT_0;
            dotAi = DOT_X;
        }
    }

    public static void aiFirst(){
        while (true){
            aiTurn();
            printField();
            if(gameCheck(dotAi)){
                break;
            }
            humanTurn();
            if(gameCheck(dotHuman)){
                break;
            }
            printField();
        }
    }

    public static void humanFirst(){
        while (true){
            humanTurn();
            printField();
            if(gameCheck(dotHuman)){
                break;
            }
            aiTurn();
            printField();
            if(gameCheck(dotAi)){
                break;
            }
        }
    }

    public static boolean gameCheck(char dot) {
        if (checkWin(dot) && dot == dotHuman) {
            System.out.println("Вы победили!");
            scoreHuman++;
            return true;
        }
        else if (checkWin(dot) && dot == dotAi){
            System.out.println("Компьютер выиграл!");
            scoreAi++;
            return true;
        }
        return checkDraw();
    }

}
