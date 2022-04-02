package s3_gps_ivanti.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private int id;
    private ArrayList<Response> responses;
    private Customer customer;
}
