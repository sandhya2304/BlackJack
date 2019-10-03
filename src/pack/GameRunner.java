package pack;

import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args)
	{

		Scanner sc=new Scanner(System.in);
		Deck deck = new Deck(1,true);
		
		
		Player me=new Player("john");
		Player dealer = new Player("cena");
		
		
		me.addCard(deck.dealNextCard());
		dealer.addCard(deck.dealNextCard());
		
		me.addCard(deck.dealNextCard());
		dealer.addCard(deck.dealNextCard());
		
		
		System.out.println("cards are deal \n");
		me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");
        
        boolean meDone = false;
        boolean dealerDone = false;
		String ans;
        
		
		while(!meDone || !dealerDone)
		{
			
			if(!meDone)
			{
				System.out.print("Hit or Stay ? (Enter H or S)");
				ans = sc.next();
				System.out.println();
				
				
				if(ans.compareToIgnoreCase("H")==0)
				{
					meDone = !me.addCard(deck.dealNextCard());
					me.printHand(true);
				}else
				{
					meDone = true;
				}				
			}
			
			if(!dealerDone)
			{
				if(dealer.getHandSum() < 17)
				{
					System.out.println("the dealer hits \n");
					dealerDone = !dealer.addCard(deck.dealNextCard());
					dealer.printHand(false);
				}else
				{
					System.out.println("the dealer stays\n");
					dealerDone=true;
				}
			}
			
			System.out.println();
		}
        
		sc.close();
		me.printHand(true);
		dealer.printHand(true);
		
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if(mySum > dealerSum && mySum <=21 ||dealerSum > 21)
		{
			System.out.println("you win!!!");
		}else
		{
			System.out.println("dealer wins!!!");
		}
		
	}

}
