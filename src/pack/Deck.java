package pack;

import java.util.Random;

public class Deck
{
	
	
	private Card[] mycards;
	//you can use arraylist or linkedlist
	
	private int numberCards;
	
	//constructor has the same name as the name of the class,not include a return type
	//Constructor is always called when object is created
	public Deck()
	{
		this(1,false);
	}
	
	//Through a constructor (with parameters), you can 'ask' the user of that class for required dependencies.
	public Deck(int numDeck,boolean shuffle)
	{
		//here intialze instance variable at the time of creation of object
		this.numberCards = numDeck*52;
		this.mycards = new Card[this.numberCards];
		
		int c = 0;
		
		for(int d= 0 ;d<numDeck;d++)
		{
			 for(int s=0;s<4;s++)
			 {
				 for(int n=1;n<=13;n++)
				 {
					 this.mycards[c] = new Card(Suit.values()[s], n);
					 c++;
				 }
			 }
		}
		
		if(shuffle)
		{
			this.Shuffle();
		}
		
	}
	
	public void Shuffle()
	{
		
		Random rand =new Random();
		
		Card temp;
		int j;
		
		for(int i=0;i<this.numberCards;i++)
		{
			j=rand.nextInt(this.numberCards);
			
			
			temp = this.mycards[i];
			this.mycards[i] = this.mycards[j];
			this.mycards[j] = temp;	
		}
		
	}
	
	
	public Card dealNextCard()
	{
		Card top = this.mycards[0];
		
		for(int c=1;c < this.numberCards;c++)
		{
			this.mycards[c-1] = this.mycards[c];
		}
		this.mycards[this.numberCards-1] = null;
		
		this.numberCards--;
		
		
		
		return top; 
	}
	
	
	public void printDeck(int numToPrint)
	{
		
		for(int c= 0 ;c<numToPrint;c++)
		{
			System.out.printf("% 3d/%d\n",c+1,this.numberCards,this.mycards[c].toString());
		}
		
		System.out.printf("\t [%d other]\n",this.numberCards-numToPrint);
	}

}
