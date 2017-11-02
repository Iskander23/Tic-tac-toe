package com.company;
import java.util.*;
public class Main {
    static int i,j;
    static int n =3;
    static char field1[][] = new char[n+1][n+1];
    static boolean gameIsOver=false;
    static byte player=1;
    static boolean turnIsCorrect=false;
    public static void writeNew(char[][]field) {
        System.out.print("         ");
        for (int i=1;i<=n;i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i=1;i<=n;i++){
            System.out.print("      " +(char) (1039 + i) + "  ");
            for (int j=1;j<=n;j++){
                System.out.print(field[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void createField(char [][]field) {
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                field[i][j]='.';
            }
        }
    }
    public static void Turn(String pos) {
        if(pos.contains("А")){
            i=1;
            if (pos.contains("1")){
                j=1;
            }
            if (pos.contains("2")){
                j=2;
            }
            if (pos.contains("3")){
                j=3;
            }
        }
        if(pos.contains("Б")){
            i=2;
            if (pos.contains("1")){
                j=1;
            }
            if (pos.contains("2")){
                j=2;
            }
            if (pos.contains("3")){
                j=3;
            }
        }
        if(pos.contains("В")){
            i=3;
            if (pos.contains("1")){
                j=1;
            }
            if (pos.contains("2")){
                j=2;
            }
            if (pos.contains("3")){
                j=3;
            }
        }
        if(field1[i][j]=='.') {
            field1[i][j] = 'X';
            turnIsCorrect=true;
        }
        else{
            turnIsCorrect=false;
            System.out.println("Введите другую клетку");
        }
    }
    static int count;
    public static void ProofPlayer1() {
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++)
                if (field1[i][j]=='X'){
                    count=count+1;
                }
            if (count==3){
                gameIsOver=true;
                return;
            }
            count=0;
        }
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++)
                if (field1[j][i]=='X'){
                    count=count+1;
                }
            if (count==3){
                gameIsOver=true;
                return;
            }
            count=0;
        }
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++)
                if (field1[i][j]=='X'){
                    count=count+1;
                }
            if (count==3){
                gameIsOver=true;
                return;
            }
            count=0;
        }
        if (field1[1][1]=='X'&&field1[2][2]=='X'&&field1[3][3]=='X'){
            gameIsOver=true;
            return;
        }
        if (field1[1][3]=='X'&&field1[2][2]=='X'&&field1[3][1]=='X'){
            gameIsOver=true;
            return;
        }
    }
    public static void ProofPlayer2() {
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++)
                if (field1[i][j]=='O'){
                    count=count+1;
                }
            if (count==3){
                gameIsOver=true;
                return;
            }
            count=0;
        }
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++)
                if (field1[j][i]=='O'){
                    count=count+1;
                }
            if (count==3){
                gameIsOver=true;
                return;
            }
            count=0;
        }
        for (int i=1;i<=3;i++){
            for (int j=1;j<=3;j++)
                if (field1[i][j]=='O'){
                    count=count+1;
                }
            if (count==3){
                gameIsOver=true;
                return;
            }
            count=0;
        }
        if (field1[1][1]=='O'&&field1[2][2]=='O'&&field1[3][3]=='O'){
            gameIsOver=true;
            return;
        }
        if (field1[1][3]=='O'&&field1[2][2]=='O'&&field1[3][1]=='O'){
            gameIsOver=true;
            return;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pos;
        createField(field1);
        while(gameIsOver!=true){
            writeNew(field1);
            if (player==1){
                System.out.println("Ваш ход, введите номер клетки");
                while(turnIsCorrect==false) {
                    pos=in.next();
                    Turn(pos);
                }
                turnIsCorrect=false;
                ProofPlayer1();
                if (gameIsOver==true){
                    break;
                }
                player=2;
            }
            //Player2 is bot
            if (player==2){
                while (turnIsCorrect!=true) {
                    i = 1 + (int) (Math.random() * 3);
                    j = 1 + (int) (Math.random() * 3);
                    if (field1[i][j]=='.') {
                        field1[i][j] = 'O';
                        turnIsCorrect=true;
                    }
                    else
                    {
                        turnIsCorrect=false;
                    }
                }
                turnIsCorrect=false;
                ProofPlayer2();
                if (gameIsOver==true){
                    break;
                }
                player=1;
            }
        }
        if(player==1){
            writeNew(field1);
            System.out.println("Вы выиграли");
        }
        if(player==2){
            writeNew(field1);
            System.out.println("Вы проиграли");
        }
    }
}
