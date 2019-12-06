package com.company;
import java.util.ArrayList;

  class Backpack extends Item {
        private ArrayList<Item> items = new ArrayList<>() ;

        public Backpack(int score) {
            super(score);
        }

        public void addItem(Item newItem){
            items.add(newItem);

        }
        public int getScore(){
            return super.getScore()+getTotalScore();
        }

       private int getTotalScore() {
            int totalScore = 0;
            for (Item item : items) {
                totalScore += item.getScore();
            }
            return totalScore;
        }

        @Override
        public void showDescription() {
            System.out.println("you have earn the following:");
            for ( Item item : items){
                item.showDescription();
            }

        }
}
