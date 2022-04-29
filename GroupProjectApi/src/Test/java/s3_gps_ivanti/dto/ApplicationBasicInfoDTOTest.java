package s3_gps_ivanti.dto;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationBasicInfoDTOTest {

    @Test
    void ConstructorBasedOnApplication() {

        Application application = Application.builder()
                .id(1)
                .name("name")
                .icon("icon")
                .description("description")
                .screenshots(Collections.emptyList())
                .appLocation("appLocation")
                .creator(new Creator(1, "", ""))
                .totalDownloads(1)
                .build();

        ApplicationBasicInfoDTO result = new ApplicationBasicInfoDTO(application);

        assertEquals("name", result.getName());
        assertEquals("icon", result.getIcon());
    }

    @Test
    void ConstructorBasedOn2String() {

        String name = "Name";
        String icon = "Icon";

        ApplicationBasicInfoDTO result = new ApplicationBasicInfoDTO(name, icon);

        assertEquals(name, result.getName());
        assertEquals(icon, result.getIcon());


    }
}