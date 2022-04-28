package s3_gps_ivanti.model;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void ConstructorBasedOnUserInput() {

        Rating rating = new Rating();

        Application application = new Application(1, "name","description",Collections.emptyList(),"icon",new Creator(1,"creatorName","creatorPassword"),Collections.emptyList(),"appLocation",rating);

        assertEquals(1, application.getId());
        assertEquals("name", application.getName());
        assertEquals("description", application.getDescription());
        assertEquals(Collections.emptyList(), application.getScreenshots());
        assertEquals("icon", application.getIcon());
        assertEquals(1, application.getCreator().getId());
        assertEquals("creatorName", application.getCreator().getUsername());
        assertEquals("creatorPassword", application.getCreator().getPassword());
        assertEquals(Collections.emptyList(), application.getReviews());
        assertEquals("appLocation", application.getAppLocation());
        assertEquals(rating, application.getRating());
    }
    @Test
    void ConstructorBasedOnUpdateApplicationDTO() {

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1, "name","description",Collections.emptyList(),"icon");

        Application application = new Application(updateApplicationDTO);

        assertEquals(1, application.getId());
        assertEquals("name", application.getName());
        assertEquals("description", application.getDescription());
        assertEquals(Collections.emptyList(), application.getScreenshots());
        assertEquals("icon", application.getIcon());
    }
    @Test
    void totalDownloadsForYear() {

        DownloadsPerMonth downloads1 = new DownloadsPerMonth(1,2022,"",25);
        DownloadsPerMonth downloads2 = new DownloadsPerMonth(2,2022,"",50);
        DownloadsPerMonth downloads3 = new DownloadsPerMonth(3,2022,"",25);
        DownloadsPerMonth downloads4 = new DownloadsPerMonth(4,2002,"",25);

        Application application = Application.builder()
                .id(1)
                .name("name")
                .icon("icon")
                .description("description")
                .screenshots(Collections.emptyList())
                .appLocation("appLocation")
                .creator(new Creator(1,"",""))
                .totalDownloads(1)
                .downloads(List.of(downloads1,downloads2,downloads3,downloads4))
                .build();


        Long result = application.totalDownloadsForYear(2022);

        assertEquals(100, result);
    }
}