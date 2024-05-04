package com.java.practice.dsalgo.ik;

public class DutchNationalFlagProblem {

public static void main(String[] args) {
// TODO Auto-generated method stub
char[] balls = {'G','B','G','G','R','B','R','G'};
dutch_flag_sort(balls);
}

public static void dutch_flag_sort(char[] balls) {
       
        int mid = 0;
        int redBallIndex = 0;
        int blueBallIndex = balls.length - 1;
        char temp;
        while(mid <= blueBallIndex){
//            if( balls[i] == 'R'){
//                char temp = balls[redBallIndex];
//                balls[redBallIndex++] = balls[i];
//                balls[i] = temp;
//                
//            }
//            else if(balls[i] == 'B'){
//                char temp = balls[blueBallIndex];
//                balls[blueBallIndex--] = balls[i];
//                balls[i] = temp;
//            }
//            else if(balls[i] == 'G'){
//                i++;
//            }
            switch(balls[mid]) {
           
            case 'R':
            temp = balls[redBallIndex];
            balls[redBallIndex++] = balls[mid];
            balls[mid] = temp;
            mid++;
            break;
           
            case 'G':
        mid++;
        break;
       
       case 'B':
        temp = balls[blueBallIndex];
        balls[blueBallIndex--] = balls[mid];
        balls[mid] = temp;
        break;
           
           
            }
        }
       
        System.out.println("something....");

    }

}