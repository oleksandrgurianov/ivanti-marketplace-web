package s3_gps_ivanti.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3_gps_ivanti.dto.response.ReplyDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateDeleteReplyDTO {
    private String id;
    private ReplyDTO reply;
}
