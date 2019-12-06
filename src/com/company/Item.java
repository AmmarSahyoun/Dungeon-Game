package com.company;

    public abstract class Item{
        private int score ;

        public Item(int score) {
            this.score = score;
        }

        public int getScore(){
            return score;
        }
        public abstract void showDescription();
    }
