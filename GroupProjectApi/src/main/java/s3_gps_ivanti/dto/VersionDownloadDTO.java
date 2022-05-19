package s3_gps_ivanti.DTO;
import lombok.Data;
@Data
public class VersionDownloadDTO {
    private String name;
    private String path;
    public VersionDownloadDTO(String name, String path){
        this.name = name;
        this.path = path;
    }
}


