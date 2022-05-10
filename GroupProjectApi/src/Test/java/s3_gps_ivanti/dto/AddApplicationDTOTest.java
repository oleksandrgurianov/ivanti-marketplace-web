package s3_gps_ivanti.dto;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.model.Version;

import java.util.Collections;
import java.util.List;

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
                .creator(new Creator(1,"",""))
                .totalDownloads(1)
                .versions(List.of(new Version(1,0,"",Collections.emptyList())))
                .build();


        CreateApplicationRequestDTO result = new CreateApplicationRequestDTO(application);

        assertEquals("name", result.getName());
        assertEquals("icon", result.getIcon());
        assertEquals(Collections.emptyList(), result.getScreenshots());
        assertEquals("description", result.getDescription());
        assertEquals(1, result.getCreatorId());

    }
}