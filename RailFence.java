
/**
 * Write a description of class RailFence here.
 * 
 * @Student (مودة عبدالرازق كركره إبراهيم) 
 * @ID (4759)
 * @Algorithm (RailFence Algorithm)
 * @Date (20/4/2023)
 */
import java.util.Scanner;
public class RailFence
{
 public static void main(String [] args){
   Scanner sc = new Scanner(System.in);
   //input key "depth"
   System.out.print("Enter key => ");
   int key= sc.nextInt();
   //input message 
   System.out.print("Enter Message => ");
   String message = sc.next();
   //encryption process
   String c =encryption(key,message);
   System.out.println("Ciphertext is => " + c);
   //decryption process
   String p =decryption(key,c);
   System.out.println("Plaintext is => " + p);
}

public static String encryption(int key , String message){
  String ciphertext="";
  boolean check= false;
  int j=0;
  int row = key ; int col = message.length();
  char [][]matrix = new char[row][col];
  //filling matrix 
   for(int i=0;i<col;i++){
      if(j==0 || j==key-1){
       check= !check;
      }
     
     matrix[j][i]=message.charAt(i);
     
     if(check)
      j++;
     else
      j--;
   }
   //reading ciphertext from matrix
   for(int i=0; i<row; i++){
     for(int k=0;k<col;k++){
      if (matrix[i][k]!=0)
       ciphertext += matrix[i][k];
      }
   }
   //print matrix
   for(int i=0; i<row; i++){
     for(int k=0;k<col;k++){
      System.out.print(matrix[i][k] + " ");
     }
     System.out.println();
   }
    
  return ciphertext;
}

public static String decryption(int key , String ciphertext){
 String plaintext=" ";
  boolean check= false;
  int j=0;
  int row = key ; int col = ciphertext.length();
  char [][]matrix = new char[row][col];
   //deciding places for ciphertext
   for(int i=0;i<col;i++){
      if(j==0 || j==key-1){
       check= !check;
      }
     
     matrix[j][i]='*';
     
     if(check)
      j++;
     else
      j--;
    }
   int index =0;
   check= false;
   //filling matrix
    for(int i=0;i<row;i++){
      for(int k=0;k<col;k++){
        if(matrix[i][k] =='*' && index<col){
          matrix[i][k]= ciphertext.charAt(index++);
        }
      }
    }
    
    //print matrix
   for(int i=0; i<row; i++){
     for(int k=0;k<col;k++){
      System.out.print(matrix[i][k] + " ");
     }
     System.out.println();
   }
   j=0;
   //decryption 
   for(int i=0;i<col;i++){
      if(j==0 || j==key-1){
       check= !check;
      }
     
     plaintext += matrix[j][i];
     
     if(check)
      j++;
     else
      j--;
    }
 return plaintext;
}

}
   
