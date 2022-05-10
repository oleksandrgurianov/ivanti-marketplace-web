package s3_gps_ivanti.dto;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.model.User;
import s3_gps_ivanti.model.Version;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GetVersionDTOTest {

    @Test
    void ConstructorBasedOnVersion() {

        GetVersionDTO version = new GetVersionDTO(new Version(1,0,"here", Collections.emptyList()));

        assertEquals(1, version.getNumber());
        assertEquals(0, version.getTotalDownloads());
    }
}