package s3_gps_ivanti.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionDownloadDTOTest {

    @Test
    void ConstructorBasedOn2Strings() {
        String name = "name";
        String path = "path";

        VersionDownloadDTO result = new VersionDownloadDTO(name, path);

        assertEquals("name", result.getName());
        assertEquals("path", result.getPath());
    }
}