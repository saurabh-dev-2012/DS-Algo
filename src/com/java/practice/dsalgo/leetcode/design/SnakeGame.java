package com.java.practice.dsalgo.leetcode.design;

import java.util.LinkedHashSet;
import java.util.Objects;

public class SnakeGame {

    // class Pair {
    //     int x;
    //     int y;

    //     public Pair(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }

    //     @Override
    //     public boolean equals(Object o) {
    //         if(this == o) {
    //             return true;
    //         }
    //         if(o == null || getClass() != o.getClass()) {
    //             return false;
    //         }
    //         Pair pair = (Pair) o;
    //         return pair.x == this.x && pair.y == this.y;
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(this.x, this.y);
    //     }


        class Pair{
            int x;
            int y;
            Pair(int x,int y){
                this.x=x;
                this.y=y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return x == pair.x && y == pair.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        private boolean validate(int x,int y){
            if(snake.contains(new Pair(x,y)))return true;

            if(x<0 || x>=height)return true;
            if(y<0 || y>=width)return true;

            return false;
        }

        void changeSnakeSize(int x,int y){
            if(foods.stream().findFirst().isPresent()) {
            	Pair food=foods.stream().findFirst().get();
                if(food.equals(new Pair(x,y))){
                    snake.add(new Pair(x,y));
                    foods.remove(food);
                }
                else{
                    snake.add(new Pair(x,y));
                    //Remove the last element from the linkedHashSet
                    Pair p=snake.stream().findFirst().get();
                    snake.remove(p);

                }
            }
        	else{
                snake.add(new Pair(x,y));
                //Remove the last element from the linkedHashSet
                Pair p=snake.stream().findFirst().get();
                snake.remove(p);

            }
        }
        int width;
        int height;
        int x;
        int y;
        LinkedHashSet<Pair> snake;
        LinkedHashSet<Pair> foods;

    // }
    // int width;
    // int height;
    // int x;
    // int y;
    // Set<Pair> snake;
    // Set<Pair> foodChain;

    public SnakeGame(int width, int height, int[][] food) {
        // this.width = width;
        // this.height = height;
        // snake = new LinkedHashSet<>();
        // foodChain = new LinkedHashSet<>();

        // for(int i=0; i<food.length; i++) {
        //     foodChain.add(new Pair(food[i][0], food[i][1]));
        // }
        // // first position of snake
        // snake.add(new Pair(0,0));
        // this.x=0;
        // this.y=0;
        this.width=width;
            this.height=height;
            this.snake=new LinkedHashSet<>();
            this.foods=new LinkedHashSet<>();
            for(int i=0;i<food.length;i++){
                this.foods.add(new Pair(food[i][0],food[i][1]));
            }
            snake.add(new Pair(0,0));
            this.x=0;
            this.y=0;
    }

    // private boolean isNotValid(int x, int y) {
    //     if(snake.contains(new Pair(x,y))) {
    //         return true;
    //     }
    //     if(x < 0 || x >= this.width) {
    //         return false;
    //     }
    //     if(y < 0 || y >= this.height) {
    //         return false;
    //     }
    //     return true;
    // }

    // private void changeSnakeLength(int x, int y) {
    //     Pair food = foodChain.stream().findFirst().get();
    //     if(food.equals(new Pair(x,y))) {
    //         snake.add(new Pair(x,y));
    //         foodChain.remove(food);
    //     }
    //     else {
    //         // remove last element from snake
    //         Pair p = snake.stream().findFirst().get();
    //         snake.add(new Pair(x,y));
    //         snake.remove(p);
    //     }
    // }
    
    public int move(String direction) {
        
        // if(direction.equals("U")) {
        //     if(isNotValid(--this.x, this.y)) {
        //         changeSnakeLength(this.x, this.y);
        //     }
        // }
        // else if(direction.equals("D")) {
        //     if(isNotValid(++this.x, this.y)) {
        //         changeSnakeLength(this.x, this.y);
        //     }
        // }
        // else if(direction.equals("L")) {
        //     if(isNotValid(this.x, --this.y)) {
        //         changeSnakeLength(this.x, this.y);
        //     }
        // }
        // else if(direction.equals("R")) {
        //     if(isNotValid(this.x, ++this.y)) {
        //         changeSnakeLength(this.x, this.y);
        //     }
        // }
        // return snake.size() - 1;
        if(direction.equals("U")){
                if(validate(x-1,y))return -1;
                x--;
                changeSnakeSize(x,y);
            }else if(direction.equals("D")){
                if(validate(x+1,y))return -1;
                x++;
                changeSnakeSize(x,y);
            }else if(direction.equals("L")){
                if(validate(x,y-1))return -1;
                y--;
                changeSnakeSize(x,y);
            }else if(direction.equals("R")){
                if(validate(x,y+1))return -1;
                y++;
                changeSnakeSize(x,y);
            }else{
                System.out.println("Invalid input");
                return -1;
            }
            // if(false){
            //     for(Pair p:snake){
            //         System.out.println(p.x + "  " + p.y);
            //     }
            // }
            return snake.size()-1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeGame snake=new SnakeGame(2, 2, new int[][]{{1,0}});
		System.out.println(snake.move("R")); //-> Returns 0
        System.out.println(snake.move("D")); //-> Returns 0
        System.out.println(snake.move("L")); //-> Returns 1
        System.out.println(snake.move("U")); //-> Returns 1
        System.out.println(snake.move("R")); //-> Returns 1
	}
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */