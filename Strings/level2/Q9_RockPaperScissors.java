import java.util.Scanner;
public class Q9_RockPaperScissors {
 static String computer(){int n=(int)(Math.random()*3);return n==0?"Rock":n==1?"Paper":"Scissors";}
 static String winner(String u,String c){if(u.equals(c))return "Draw";if((u.equals("Rock")&&c.equals("Scissors"))||(u.equals("Paper")&&c.equals("Rock"))||(u.equals("Scissors")&&c.equals("Paper")))return "Player";return "Computer";}
 static String normalize(String s){if(s.equalsIgnoreCase("rock"))return "Rock";if(s.equalsIgnoreCase("paper"))return "Paper";if(s.equalsIgnoreCase("scissors"))return "Scissors";return "";}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter number of games: ");int n=sc.nextInt();sc.nextLine();if(n<=0)return;String[][] r=new String[n][3];int pw=0,cw=0;for(int i=0;i<n;i++){String u;do{System.out.print("Game "+(i+1)+" - Rock/Paper/Scissors: ");u=normalize(sc.nextLine().trim());}while(u.isEmpty());String c=computer(),w=winner(u,c);if(w.equals("Player"))pw++;if(w.equals("Computer"))cw++;r[i]=new String[]{u,c,w};}System.out.println("Game\tPlayer\tComputer\tWinner");for(int i=0;i<n;i++)System.out.println((i+1)+"\t"+r[i][0]+"\t"+r[i][1]+"\t\t"+r[i][2]);System.out.println("Player wins = "+pw);System.out.println("Computer wins = "+cw);System.out.printf("Player win %% = %.2f%%%n",pw*100.0/n);System.out.printf("Computer win %% = %.2f%%%n",cw*100.0/n);}
}
