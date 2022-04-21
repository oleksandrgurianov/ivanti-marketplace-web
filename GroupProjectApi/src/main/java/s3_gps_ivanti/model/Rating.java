package s3_gps_ivanti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rating {
    private int id;
    private int oneStarAmount;
    private int twoStarAmount;
    private int threeStarAmount;
    private int fourStarAmount;
    private int fiveStarAmount;

    public Rating(){
        this.oneStarAmount = 0;
        this.twoStarAmount = 0;
        this.threeStarAmount = 0;
        this.fourStarAmount = 0;
        this.fiveStarAmount = 0;
    }
    public int totalAmount(){
       return oneStarAmount+twoStarAmount+threeStarAmount+fourStarAmount+fiveStarAmount;
    }
    public double avgStar(){
        return (oneStarAmount+2*twoStarAmount+3*threeStarAmount+4*fourStarAmount+5*fiveStarAmount)/totalAmount();
    }
}
