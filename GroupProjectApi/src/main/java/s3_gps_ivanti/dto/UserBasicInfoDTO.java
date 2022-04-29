package s3_gps_ivanti.dto;

import lombok.Data;
import s3_gps_ivanti.model.User;

@Data
public class UserBasicInfoDTO {
    int id;
    String firstName;
    String lastName;

    public UserBasicInfoDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
