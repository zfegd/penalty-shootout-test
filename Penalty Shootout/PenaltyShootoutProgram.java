public class PenaltyShootoutProgram {

    public static void main(String[] args){
        PenaltyShootoutLibrary team1 = new PenaltyShootoutLibrary(); 
        int[] shooter= {1,15};
        int[] keeper={1,15};
        int[] score={0,0};
        int[][] team1players = new int[11][2];
        int teamturn1=0;
        
        PenaltyShootoutLibrary team2 = new PenaltyShootoutLibrary(); 
        int[] shooter1= {0,19};
        int[] keeper1={0,7};
        int[][] team2players = {{0,19},{1,15},{1,13},{0,18},{2,17},{1,11},{0,9},{2,12},{1,10},{0,14},{1,6}};
        int teamturn2=1;
        
        for(int i=0; i<5; i++){
            if(i==0){
            System.out.println();
            System.out.println("This is the 1st round of penalties.");
            }
            else if(i==1){
            System.out.println();
            System.out.println("This is the 2nd round of penalties.");
            }
            else if(i==2){
            System.out.println();
            System.out.println("This is the 3rd round of penalties.");
            }
            else{
            System.out.println();
            System.out.println("This is the "+(i+1)+"th round of penalties.");
            }

            team1.penalty(shooter, keeper, score, teamturn1);
            
            if((score[0]-score[1])>(5-i)){
                System.out.println();
                System.out.println("It's all over!");
                System.out.println("Team 1 have won by " + score[0] + "-" + score[1]);
                System.exit(0);
            }
            else if((score[1]-score[0])>(4-i)){
                System.out.println();
                System.out.println("It's all over!");
                System.out.println("Team 2 have won by " + score[1] + "-" + score[0]);
                System.exit(0);
            }
            
            team2.penalty(team2players[i], keeper1, score, teamturn2);
            
            if((score[1]-score[0])>(4-i)){
                System.out.println();
                System.out.println("It's all over!");
                System.out.println("Team 2 have won by " + score[1] + "-" + score[0]);                
                System.exit(0);
            }
            else if((score[0]-score[1])>(4-i)){
                System.out.println();
                System.out.println("It's all over!");
                System.out.println("Team 1 have won by " + score[0] + "-" + score[1]);
                System.exit(0);
            }
        }
        
        System.out.println();
        System.out.println("Sudden death!");

        int j=6;
        while(score[0]==score[1]){
            System.out.println();
            if(j<20){
                System.out.println("This is the "+j+"th round of penalties.");
            }
            else if(j%10==1){
                System.out.println("This is the "+j+"st round of penalties.");                
            }
            else if(j%10==2){
                System.out.println("This is the "+j+"nd round of penalties.");                
            }
            else if(j%10==3){
                System.out.println("This is the "+j+"rd round of penalties.");                
            }
            else{
                System.out.println();
                System.out.println("This is the "+j+"th round of penalties.");
            }
            
            team1.penalty(shooter, keeper, score, teamturn1);
            team2.penalty(team2players[j], keeper1, score, teamturn2);
            
            if(score[0]>score[1]){
            System.out.println();
            System.out.println("It's all over!");
            System.out.println("Team 1 have won by " + score[0] + "-" + score[1]);
            System.exit(0);
            }
            
            else if(score[1]>score[0]){
            System.out.println();
            System.out.println("It's all over!");
            System.out.println("Team 2 have won by " + score[1] + "-" + score[0]);
            System.exit(0);
            }

            j++;
        }
        
    }
} 



//TODO add list of shooters as array to iterate, Print code, timed display, sudden death
// Array of shooters, repeat cycle
// Remove time delay for winning penalty, add delay for between round this and stepping up
// Debug
// Tidy up style eg helper functions?
// Sudden death "this is the 23rd" vs 23th
// add break or exit to improve inefficiency