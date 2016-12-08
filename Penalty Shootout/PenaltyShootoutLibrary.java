public class PenaltyShootoutLibrary {
    
    public int penTakingAbility(int[] stats, int pressure){
        assert (pressure>0);
        if(pressure<=3){
            return (int) ((stats[0]+4*stats[1]+5*stats[2])/10);
        }
        else if(pressure>3&&pressure<8){
            return (int) ((3*stats[0]+3*stats[1]+4*stats[2])/10);
        }
        else
        {
            return (int) ((4*stats[0]+3*stats[1]+3*stats[2])/10);
        }

    }
    // stats[0]= composure, stats[1] = finishing, stats[2]=penalty technique
    
    public int[] penalty(int[] penTaker, int[] keeper, int[] score, int team) {
        System.out.println();
        System.out.println("Player from team "+(team+1)+" stepping up to shoot");
        timeWait(1000);                
        System.out.println("He runs up to shoot");
        timeWait(1000);
        double chanceOfMiss = Math.random();
                                    // System.out.println("chanceOfMiss =" + chanceOfMiss);
        double likelihoodOfMiss = (20.5-penTaker[1]) /20;
                                    // System.out.println("likelihoodOfMiss =" + likelihoodOfMiss);
        if(chanceOfMiss+likelihoodOfMiss>1.05){           //improve algorithms, test for good avg and bad shooters and keepers
            System.out.println("Penalty Missed!");
            timeWait(500);                
            System.out.println("The score is " + score[0] + "-" + score[1]);
            timeWait(1000);                
            return score;
        }
        else{
            if(penTaker[0]==keeper[0]){
                double chanceOfSave = ((double)keeper[1]/20) * Math.random() * Math.random();
                                    // System.out.println("chanceOfSave =" + chanceOfSave);
                double chanceOfGoal = ((double)penTaker[1]/20) * Math.random();
                                    // System.out.println("chanceOfGoal =" + chanceOfGoal);
                if(chanceOfSave>=chanceOfGoal){
                    System.out.println("Penalty Saved!");
                    timeWait(500);                
                    System.out.println("The score is " + score[0] + "-" + score[1]);
                    timeWait(1000);                
                    return score;
                }
                else{
                    System.out.println("Penalty Scored!");
                    score[team]++;
                    timeWait(500);
                    System.out.println("The score is " + score[0] + "-" + score[1]);
                    timeWait(1000);                
                    return score;                
                }
            }
            else{
                System.out.println("Penalty Scored!");
                score[team]++;
                timeWait(500);
                System.out.println("The score is " + score[0] + "-" + score[1]);
                timeWait(1000);                
                return score;                
            }
        }
    }
    // int[] score = new int[2]
    // int[] penTaker = new int[2]
    // penTaker[0] is direction of shot with 0 is center, 1 is left, 2 is right --> add that this is purely tendency to shoot there
    // penTaker[1] is penTaking ability out of 20
    
    private static void timeWait(int timeToWait){       //Understand InterruptedException
        try {
            Thread.sleep(timeToWait);       //delay time in ms (1000ms = 1s)
        }
        catch (InterruptedException a){
            
        }
    }
    /*
    public static int max(int[] data){
        assert(data.length>0);
        int x = data[0];
        for(int i=1;i<data.length;i++){
            if(data[i]>x){
                x = data[i];
            }
        }
        return x;
    }
    
    public static int diffTwo(int[] data){
        return Math.abs(data[0]-data[1]);
    }
    */
}