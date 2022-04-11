package s3_gps_ivanti.DTO;

import lombok.Data;

@Data
public class ApplicationBasicInfoDTO {

    private String name;
    private String icon;

    public ApplicationBasicInfoDTO(String name, String icon)
    {
        this.name = name;
        this.icon = icon;
    }
}
