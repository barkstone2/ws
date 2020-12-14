package com.study.self;

public class SutdaDeck {
	
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	public SutdaDeck() {
		for(int i=0; i<cards.length; i++) {
			if(i<10) {
				if(i==0 || i==2 || i==7) {
					cards[i] = new SutdaCard(i+1, true);
				} else {
					cards[i] = new SutdaCard(i+1, false);
				}
			} else {
				cards[i] = new SutdaCard(i+1-10, false);
			} // if end
			
		} // for end
	} // SutdaDeck Method end
	
	public void shuffle() {
		for(int i=0; i<cards.length; i++) {
			int randomIndex = (int)(Math.random()*cards.length);
			SutdaCard tmp = cards[i];
			cards[i] = cards[randomIndex];
			cards[randomIndex] = tmp;
		}
		
	} // shuffle Method end
	
	
	public SutdaCard pick(int index) {
		return cards[index];
	}
	
	public SutdaCard pick() {
		int r = (int)(Math.random()*cards.length);
		return cards[r];
	}
	
	
	
	
	
}
