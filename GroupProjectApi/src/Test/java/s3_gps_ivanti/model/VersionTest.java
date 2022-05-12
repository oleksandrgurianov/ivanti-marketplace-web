package s3_gps_ivanti.model;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.dto.CreateVersionDTO;
import s3_gps_ivanti.dto.UpdateVersionDTO;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {

    @Test
    void ConstructorBasedOnstuff() {

        Version version = new Version(1, 0, "here", Collections.emptyList());

        assertEquals(1, version.getNumber());
        assertEquals(0,  version.getTotalDownloads());
        assertEquals("here",  version.getAppLocation());
        assertEquals(Collections.emptyList(), version.getDownloadsPerMonths());
    }

    @Test
    void ConstructorBasedOnUpdateVersionDTO() {

        Version version = new Version(
                new UpdateVersionDTO("thing",1.0,"location"),
                new Version(1l,10,0,"here",Collections.emptyList()));

        assertEquals(1l, version.getId());
        assertEquals(0,  version.getTotalDownloads());
        assertEquals(Collections.emptyList(),  version.getDownloadsPerMonths());
        assertEquals(10, version.getNumber());
        assertEquals("location", version.getAppLocation());
    }

    @Test
    void ConstructorBasedOnCreateVersionDTO() {

        Version version = new Version(new CreateVersionDTO("thing",1.0,"thing"));

        assertEquals(1.0, version.getNumber());
        assertEquals(0,  version.getTotalDownloads());
        assertEquals("thing",  version.getAppLocation());
        assertEquals(Collections.emptyList(), version.getDownloadsPerMonths());
    }
}