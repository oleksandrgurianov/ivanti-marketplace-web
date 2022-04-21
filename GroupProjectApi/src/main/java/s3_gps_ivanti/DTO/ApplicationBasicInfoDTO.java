package s3_gps_ivanti.DTO;

import lombok.Data;
import s3_gps_ivanti.model.Application;

@Data
public class ApplicationBasicInfoDTO {

    private String name;
    private String icon;

    public ApplicationBasicInfoDTO(String name, String icon)
    {
        this.name = name;
        this.icon = icon;
    }
    public ApplicationBasicInfoDTO(Application application){
        this.name = application.getName();
        this.icon = application.getIcon();
    }
}
