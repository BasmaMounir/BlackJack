/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Basma
 */
public class Player {
    public String player_Name ;
    public int score =0 ;
    Card [] card = new Card [11];
    private int index =0 ;
    

    public void Add_Card(Card c) {  
	if(index < 11)
        {
            card[index] = c ; 
            index++;
           score = score + c.getValue();
        }
    }
	
}
