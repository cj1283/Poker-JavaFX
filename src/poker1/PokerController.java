/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker1;

import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author jones
 */
public class PokerController {
    @FXML private TextField cardNum1;
    @FXML private TextField cardNum2;
    @FXML private TextField cardNum3;
    @FXML private TextField cardNum4;
    @FXML private TextField cardNum5;
    
    @FXML private TextField suit1;
    @FXML private TextField suit2;
    @FXML private TextField suit3;
    @FXML private TextField suit4;
    @FXML private TextField suit5;
    
    @FXML private Label labelResult;
    @FXML
    private Label rank;
    @FXML
    private Label suit;
    @FXML
    private Button btn;
    
    @FXML
    public void displayHand(ActionEvent event){
        
        char comma = ',';
        
        String card1 = cardNum1.getText();
        String txtSuit1 = suit1.getText();
        
        String card2 = cardNum2.getText();
        String txtSuit2 = suit2.getText();
        
        String card3 = cardNum3.getText();
        String txtSuit3 = suit3.getText();
        
        String card4 = cardNum4.getText();
        String txtSuit4 = suit4.getText();
        
        String card5 = cardNum5.getText();
        String txtSuit5 = suit5.getText();
        
        String[] suits = new String[5];
        String[] cardVals = new String[5];
        
        cardVals[0] = card1;
        cardVals[1] = card2;
        cardVals[2] = card3;
        cardVals[3] = card4;
        cardVals[4] = card5;
        
        suits[0] = txtSuit1;
        suits[1] = txtSuit2;
        suits[2] = txtSuit3;
        suits[3] = txtSuit4;
        suits[4] = txtSuit5;
        int caseNum = 0;
        
        
        //Types of Hands
        //Straight Flush = Flush + Straight
        
        //Flush = All cards have same suit
        
        //Straight = consecutive ranks (Ace can come before 2 or after King)      
        /*if(checkArrayContainsConsecutiveElements(parseCards(cardVals),5))
        {    
            caseNum = 3;
        }
        if(AreAllSame(suits))
        {          
            caseNum = 2; 
            if(checkArrayContainsConsecutiveElements(parseCards(cardVals),5))
            {    
                    caseNum = 1;          
            }
        }
        else
        {
            caseNum = 0;
            
        }*/
        caseNum = (checkArrayContainsConsecutiveElements(parseCards(cardVals),5) + AreAllSame(suits));
        
        
        switch(caseNum)
        {
            case 3:
                labelResult.setText("The hand is a Straight Flush");
                break;
            case 2:
                labelResult.setText("The hand is a Flush");
                break;
            case 1:
                labelResult.setText("The hand is a Straight");
                break;
            default:
                labelResult.setText("None");
                break;
        
        }
        
        //Four of a kind = 4 cards with the same rank
        
        //Full House = Three of a kind and a pair
        
        //Three of a kind = Three cards have the same rank
        
        //Two pair = 2 different pairs of cards with same value
        
        //One pair = one pair of cards with the same value
        
        //None of the above
        
        //labelResult.setText("The hand is a " + card1 + " of " + txtSuit1 + comma);
    }
    
    
    
    public static int AreAllSame(String array[])
    {
        String[] suits = new String[5];
        for(int v = 0; v < array.length; v++)
        {
            suits[v] = array[v];
        }
         
        if(Arrays.equals(array, suits))
        {
            for(int v = 0; v < array.length; v++)
            {
                suits[v] = "";
            }
            return 2;
        }
        else
            return 0;
    }
    
    public static boolean aceCheck(String card)
    {
        if(card == "A" || card == "a")
        {
            return true;
        }
        return false;
    }
    
    public static int[] parseCards(String x[])
    {
        int[] cards = new int[5];
        boolean aceValThirteen = false;
        for(int i = 0; i < x.length; i++)
        {   
            if(x[i] == "k" || x[i] == "K")// Eauals 13
            {
                cards[i] = 13;
                aceValThirteen = true;
            }
            if(x[i] == "q" || x[i] == "Q")// Equals 12
            {
                cards[i] = 12;
            }
            if(x[i] == "j" || x[i] == "J")// Equals 11
            {
                cards[i] = 11;
            }
            cards[i] = Integer.parseInt(x[i]);
        }
        
        for(int i = 0; i < x.length; i++)
        {
            if(x[i] == "a" || x[i] == "A")// Can be a 1 or 13
            {   if(aceValThirteen == false)
                {
                    cards[i] = 1;
                }
                else
                {
                    cards[i] = 13;
                }
            }
        }   
        return cards;
    }
    
    /* Method return minimum value*/
	private int getMinimum(int arr[], int n)
	{
		int min = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}
 
	/* Method return maximum value*/
	private int getMaximum(int arr[], int n)
	{
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}
 
	/* This method checks if array elements are consecutive */
	public int checkArrayContainsConsecutiveElements(int arr[], int n)
	{
		if ( n <  1 )
			return 0;
 
		int min = getMinimum(arr, n);
		int max = getMaximum(arr, n);
 
		if (max - min  + 1 == n)
		{
			boolean[] visited=new boolean[arr.length];
			for (int i = 0; i < n; i++)
			{
				if ( visited[arr[i] - min] != false )
					return 0;
 
				visited[arr[i] - min] = true;
			}
 
			return 1;
		}
		return 0; 
	}
}

