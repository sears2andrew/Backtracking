/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;


/**
 *
 * @author andy
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Select a file that contains inheritance data");
            
        //prompt the user to pick a file with data that they wish to check
        
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION){
            System.out.println("No file selected.");
            return;
        }
        
        Scanner scan = new Scanner(chooser.getSelectedFile());
        int data = scan.nextInt();
        
        for(int i=0; i<data;i++){
            
            //create the requred data members for the rest of the program
            
            LinkedList<Integer> part1 = new LinkedList<>();
            LinkedList<Integer> part2 = new LinkedList<>();
            int next = scan.nextInt();
            int [] inputs = new int[next];
            
            //print out the original data in the correct format
            
            System.out.print("Original input is [");
            
            for(int j=0; j<next; j++){
                inputs[j]=scan.nextInt();
                if(j<next-1)
                    System.out.print(inputs[j] + ", ");
                else
                    System.out.print(inputs[j]);
            }
            
            System.out.println("]");
            
            //call to solve the data that is given and print the result formated
            
            if (!EstateSplit.solve(inputs, part1, part2)){
                System.out.println("A Fair split is not possible, Donate estate to charity.");
            }
            else{
                System.out.println("A fair split is " + part1.toString() + " and " + part2.toString() + ".");
            }
        }
    }
    
}
