package s3_gps_ivanti.DTO;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AddApplicationDTOTest {

    @Test
    void ConstructorBasedOnApplication() {

        Application application = Application.builder()
                .id(1)
                .name("name")
                .icon("icon")
                .description("description")
                .screenshots(Collections.emptyList())
                .appLocation("appLocation")
                .creator(new Creator(1,"",""))
                .totalDownloads(1)
                .build();


        CreateApplicationRequestDTO result = new CreateApplicationRequestDTO(application);

        assertEquals("name", result.getName());
        assertEquals("icon", result.getIcon());
        assertEquals(Collections.emptyList(), result.getScreenshots());
        assertEquals("description", result.getDescription());
        assertEquals("appLocation", result.getAppLocation());
        assertEquals(1, result.getCreatorId());

    }
}