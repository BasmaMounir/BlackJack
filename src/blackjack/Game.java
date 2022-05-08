/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Basma
 */
public class Game {
    Player [] player = new Player [4];
    Card [] deck = new Card [52];
    Scanner input = new  Scanner (System.in);
    public int high_score [] = new int [4];
    
    public void Generate_Cards()
    {
       int value = 0 , count = 0;
        for(int i = 0 ; i < 4 ; i ++ ) // Number of suit 0 : 3
        {
            for (int j = 0 ; j < 13 ; j ++ ) // Number of Cards for eche suit 0 : 12
            {
                if (j >= 9)
                    value = 10;
                else  
                    value = j+1;
              Card card = new Card (i , j , value);
              deck [count] = card;
              count ++;
            }
        }
    }
    
    public Card Draw_Card()
    {
        Random rand = new Random();
        while(true)
        { 
            int r = rand.nextInt(51);
           Card c = deck[r];
           if(c != null)
           {
            deck[r]=null;
            return c;
           }
        }
    }
    
    public void set_players_information ()
    {
        for (int i = 0 ; i < 3 ; i++)
          {
               System.out.println("Enter The Player " + (i+1) + " Name --> "); 
               player[i] = new Player();
               player[i].player_Name = input.next();
               // for each player hase 2 cardes 
               player[i].Add_Card(Draw_Card());
               player[i].Add_Card(Draw_Card());
               System.out.println("score of player " + player[i].player_Name+" = "+player[i].score);
               System.out.println("__________________________________________________________________");
          }
               // Dealer’s turn 
               player[3] = new Player();
               player[3].player_Name = "dealer";
               //Dealer hase 2 cardes 
               player[3].Add_Card(Draw_Card());
               player[3].Add_Card(Draw_Card());
                        
    }
    
    public void Update_Score()
    {
        for (int i = 0 ; i < high_score.length  ; i ++)
        {
            if( player[i].score <= 21 )
                high_score[i] = player[i].score;
        }
    }
  
    
}
