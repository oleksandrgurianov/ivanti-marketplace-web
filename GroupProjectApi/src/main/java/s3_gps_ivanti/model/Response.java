package s3_gps_ivanti.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private int id;

    private Review review;
    private Creator creator;
}
