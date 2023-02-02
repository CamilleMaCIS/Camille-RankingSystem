public class User {
    //properties
    private int rank;
    private int progress;
    //constructor

    public User(){
        this.rank = -8;
        this.progress = 0;
    }
    //methods

    public int getRank(){
        return rank;
    }

    public int getProgress(){
        return progress;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public void setProgress(int progress){
        this.progress = progress;
    }

    public void incProgress(int rankOfActivity){
        //if rank already 8, do nothing
        if (this.rank == 8){
            this.progress = 0;
            this.rank += 0;
        }
        else if (rankOfActivity < -8 || rankOfActivity == 0 || rankOfActivity > 8){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        else if(rankOfActivity > this.rank){
            int d = rankOfActivity - this.rank;
            //if rank was less than 0 and became more than 0, remember 0 is not a level, so difference minus 1
            //e.g. if rankofactivity is 3, rank is -3, d is 5 not 6
            if (this.rank < 0 && rankOfActivity > 0){
                d--;
            }
            this.progress += 10 * d * d;
        }
        else if (rankOfActivity == this.rank){
            this.progress += 3;
        }
        //lower by 1 rank, or if 1 and -1
        else if (rankOfActivity == -1 && this.rank == 1){
            this.progress += 1;
        }
        else if (rankOfActivity == this.rank - 1){
            this.progress += 1;
        }


        //upgrading rank
        if (this.progress >= 100){
            //quotient is how many full rank ups
            int quotient = this.progress / 100;
            int remainder = this.progress % 100;

            //if rank was less than 0 and became more than 0, remember 0 is not a level, skip over
            //e.g. 2 rank ups after -1 should be rank 2, not 1
            if (this.rank < 0 && quotient * -1 <= this.rank){
                rank += quotient + 1;
                progress = remainder;
            }
            else{
                rank += quotient;
                progress = remainder;
            }
        }

        //skip over 0
        if (this.rank == 0){
            rank++;
        }
    }

    public String toString(){
        return "User{rank=" + this.rank + ", progress=" + this.progress + '}';
    }
}
