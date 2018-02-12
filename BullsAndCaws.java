
package bullsandcaws;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCaws {

    
   
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
    Scanner console = new Scanner(System.in);
    Random r= new Random();
    int target= 0;
    while(isTheNum(target= (r.nextInt(9000) + 1000)));
    String targetStr = target +"";
    boolean guessed = false;
    int guesses = 1;
    int trynum = 0;


  
   System.out.println("Bulls and Caws");
   System.out.println("1-Single player");
   System.out.println("2-Multiplayer");
   System.out.println("3-Scores");
   int choice = Integer.parseInt(console.nextLine());
   ///single player
   
if(choice==1){
    do{
int bulls = 0;
int cows = 0;

System.out.print("Guess  number: ");
int guess=Integer.parseInt(console.nextLine());
if (isTheNum(guess)  || guess < 1000) continue;
 trynum++;
 String guessStr = guess + "";




for(int i= 0;i < 4;i++){
if(guessStr.charAt(i) == targetStr.charAt(i)){
bulls++;
}else if(targetStr.contains(guessStr.charAt(i)+"")){
cows++;
}
}
if(bulls == 4){
guessed = true;
}else{
System.out.println(cows+" Cows and "+bulls+" Bulls.");
guesses++;
}
}while(!guessed);
System.out.println("You won after "+guesses+" guesses!");

///save score in txt file
System.out.println("Enter Your Name");
String name=(console.nextLine());
File file = new File("C:/Users/scores.txt");
FileWriter fw = new FileWriter(file,true);
BufferedWriter bw = new BufferedWriter(fw);
bw.write(guesses);
bw.newLine();
bw.close();
}
 
///Multipleyar
if(choice==2){
System.out.println("Playar 1: Enter your number");
String plr1 = console.nextLine();


do{
int bulls = 0;
int cows = 0;

System.out.println("Playar 2: Enter your guess");
int plr2 = Integer.parseInt(console.nextLine());

String plr1Str = plr1 + "";
String plr2Str = plr2 + "";
 for (int i = 0; i < 4; i++) {
if(plr1Str.charAt(i) == plr2Str.charAt(i)){
bulls++;
}else if(plr2Str.contains(plr1Str.charAt(i)+"")){
cows++;
}}

if(bulls == 4){
guessed = true;
}else{
System.out.println(cows+" Cows and "+bulls+" Bulls.");
guesses++;
}
}while(!guessed);
System.out.println("You won after "+guesses+" guesses!");

}
}

public static boolean isTheNum(int num){
		boolean[] digs = new boolean[10];
                
		while(num > 0){
			if(digs[num%10]) return true;
			digs[num%10] = true;
			num/= 10;
		}
		return false;
	}
                
    }
    

