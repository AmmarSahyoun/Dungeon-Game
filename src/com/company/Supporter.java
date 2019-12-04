package com.company;

public class Supporter extends Item{

        private String title;

        public Supporter(int score , String title){
            super(score);
            this.title = title;
        }
        public void showDescription() {
            System.out.printf("supporter title: %s, weight: %f \n" , title , getScore());
        }
    }


