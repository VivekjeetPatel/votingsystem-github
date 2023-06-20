import java.util.Scanner;



class VotingSystem{
    private String voterlist[];
    private String candidatelist[];
    private String castedvoter[];
    private int castedvotercount = 0;
    private int candidatevotecount[];
    VotingSystem(String invoterlist[],String incandidatelist[]){
        this.voterlist = invoterlist;
        this.candidatelist = incandidatelist;
        this.castedvoter = new String[invoterlist.length];
        this.candidatevotecount = new int[incandidatelist.length];


    }

    boolean castvote(String votername,String chosedcandidate){
        if(votervalidation(votername)){
            castedvoter[castedvotercount] = votername;
            castedvotercount++;
            for(int i = 0;i<candidatelist.length;i++){
                if(candidatelist[i].equals(chosedcandidate)){
                    candidatevotecount[i] = candidatevotecount[i]+1;
                }
            }
            return true;
        }
        return false;


    }

    private boolean votervalidation(String votername){
        boolean knownvoter = false;
        boolean falsevote = true;
        f1 : for(String x : this.voterlist){
             if(votername.equals(x)){
                knownvoter = true;
                break f1;
            }
        }
        f2 : for(String y :  this.castedvoter){
            if(votername.equals(y)){
                falsevote = false;
                break f2;

            }
        }
        return knownvoter&falsevote;
    }

    String winner(){ // # adding multiple winners
        int max = candidatevotecount[0];
        int maxi = 0;
        for(int i = 0;i<candidatevotecount.length;i++ ){
            if(max<candidatevotecount[i]){
                max = candidatevotecount[i];
                maxi = i;
            }
        }
        System.out.println("Max votes : "+max);
        return candidatelist[maxi];
    }


}

class inputnamecorrection{

    String name(String inname){
        String correctname1 = inname.replaceAll("\\s","");
        String correctname2 = correctname1.toLowerCase();
        return correctname2;

    }
}



public class eighteenjuneone {

    static String voters[] = {"a","b","c"}; //voterlist
    static String candidates[] = {"a","b"}; //candiatelist
   
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        inputnamecorrection io1 = new inputnamecorrection();
        VotingSystem vso1 = new VotingSystem(voters, candidates);
        
        for(int i = 0;i<voters.length;){
            System.out.print("Enter Your Voter Id : ");
            String voter = sc1.nextLine();
           
            for(int j = 0;j<candidates.length;j++){
                System.out.println((j+1)+" : "+candidates[j]);
            }
            System.out.print("Choose Your Candidate : ");
            int candidate = sc2.nextInt();

            boolean increase = vso1.castvote(io1.name(voter), io1.name(candidates[candidate-1]));
            if(increase){
                i++;
            }

        }

        String winner = vso1.winner();
        System.out.println("Winner is : "+winner);
        System.out.println();

        sc1.close();
        sc2.close();
        
    }
    
}
