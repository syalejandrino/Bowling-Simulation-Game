/**
 * Write a description of class Bowling here.
 *
 * @author (Simon Alejandrino)
 * @version (October 07, 2021)
 */

import java.util.Random;

public class Bowling
{
    private int firstBall, secondBall, extraBall, frame, score;
    Random r = new Random();
    int[] gameResults = new int[1000];
    private int sum, games;
    
    public Bowling(){
        firstBall = 0;
        secondBall = 0;
        extraBall = 0;
        frame = 0;
        score = 0;
        sum = 0;
        games = 0;
        r = new Random();
    }
    
    public void displayFrame(){
        if(frame != 10){
        System.out.println("Results for frame #" + frame);
        System.out.println("First ball: " + firstBall);
        System.out.println("Second ball: " + secondBall);
        System.out.println("Total score: " + score);
    } else if (frame == 10){
        System.out.println("*** The game is over - final score ***");
        System.out.println("Results for frame #" + frame);
        System.out.println("First ball: " + firstBall);
        System.out.println("Second ball: " + secondBall);
        System.out.println("Extra ball: " + extraBall);
        System.out.println("Total score: " + score);
        }
    }
    
    public void updateScore(){
        score += firstBall + secondBall + extraBall;
    }
    
    public void bowlFrame(){
        if (frame == 10){
        } else {
            frame++;
            firstBall = r.nextInt(11);
            if (firstBall < 10) {
                secondBall = r.nextInt(10 - firstBall + 1);
            } else if ((firstBall + secondBall) == 10 && frame == 10) {
                extraBall = r.nextInt(11);
            }
        } updateScore();
    }
    
    public void reset(){
        firstBall = 0;
        secondBall = 0;
        extraBall = 0;
        frame = 0;
        score = 0;
    }
    
    public int playGame() {
        reset();
        for (int i = 0; i<10; i++){
        bowlFrame();
        }
        return score;
    }
    
    public void playAllGames(int numGames){
        for(int i = 0; i != numGames; i++){
            int a = playGame();
            gameResults[numGames] = a;
            sum += a;
            games = games + 1;
        } displayResults();
    }
    
    public void displayResults(){
        System.out.println("The number of games played: " + games);
        System.out.println("The sum of the scores: " + sum);
        System.out.println("The average of scores: " + (sum/games));
    }
}

