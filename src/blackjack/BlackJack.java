/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Basma
 */

public class BlackJack {

    /**
     * @param args the command line arguments
     */
   
    static Game game = new Game(); //game object declared outside the main function.
      //Hit ---> 1    STAND ---> 2
     public static void Hit_or_Stand()
    {
        GUI gui = new GUI();
        Scanner input = new Scanner(System.in);
        int choise;
        for (int i = 0; i < 3 ; i++)
        {
            System.out.println("it is  " + game.player[i].player_Name + " turn ");
    do
    {
       System.out.println("(1) Hit or (2)Stand ");
          choise = input.nextInt();
          if (choise == 1 )
          {
             game.player[i].Add_Card(game.Draw_Card());
            gui.updatePlayerHand(game.Draw_Card(),i);
            System.out.println( game.player[i].player_Name + "’s Scor is  " +game.player[i].score);
          } 
          else 
          {
              break;
          }
    }while(choise != 2 && game.player[i].score <= 21);
    }  
    }
  
  public static void dealar_turn()
  {
      GUI gui = new GUI();
      boolean win = true;
      int h_score = 0;
       for (int i = 0; i < 3; i++) {
           if(game.high_score[i] >= game.player[3].score)
               win =false;
            if(game.high_score[i] > h_score)
                h_score = game.high_score[i];
       }
    if(win == false)
    {
        while(game.player[3].score < h_score)
        {
            Card c = game.Draw_Card();
            game.player[3].Add_Card(c);
           gui.updateDealerHand(c , game.deck);
        }
                
    }
    else 
        return ;
  }
     public static void Play()
    {
        for (int i = 0; i < 4; i++) {
            {
                if(game.player[i].score  == 21)
                {
                    System.out.println( game.player[i].player_Name +" is WON and is a BLACKJAK \n");
                }
               else if(game.player[i].score  > 21)
                {
                    System.out.println( game.player[i].player_Name +" is BUSTED \n");
                }
               else if( game.player[i].score == game.high_score[i])
                {
                    System.out.println( game.player[i].player_Name +" is PUSH \n");
                }  
                else
                {
                    System.out.println(  game.player[i].player_Name +" is WON \n");
                }  
         }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        game.Generate_Cards();
        game.set_players_information();
        gui.runGUI( game.deck, game.player[0].card, game.player[1].card, game.player[2].card, game.player[3].card );
        Hit_or_Stand();
        game.Update_Score();
        dealar_turn();
        game.Update_Score();
        Play();
}
}

