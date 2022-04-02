package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private int id;
    private Creator creator;
    private ArrayList<Review> reviews;

}
