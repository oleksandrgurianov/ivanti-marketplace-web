package com.example.S3_GPS_Ivanti;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.business.CreatorService;
import s3_gps_ivanti.business.impl.ApplicationServiceImpl;
import s3_gps_ivanti.business.impl.CreatorServiceImpl;
import s3_gps_ivanti.repository.CreatorRepository;
import s3_gps_ivanti.repository.impl.ApplicationRepositoryImpl;
import s3_gps_ivanti.repository.impl.CreatorRepositoryImpl;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class tests {

    @Test
    void UpdateApplication_Name_Test()
    {
        ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

        UpdateApplicationDTO app;

        ArrayList<String> images = new ArrayList<>();
        images.add("a");
        images.add("a");

        //Name is null expect false
        app = new UpdateApplicationDTO("1",null, "a",images,"a");
        assertEquals(false, applicationService.updateApplications(app));

        //Name is empty expect false
        app = new UpdateApplicationDTO("1","", "a",images,"a");
        assertEquals(false, applicationService.updateApplications(app));

        //Name is not null or empty expect true
        app = new UpdateApplicationDTO("1","a", "a",images,"a");
        assertEquals(true, applicationService.updateApplications(app));
    }

    @Test
    void UpdateApplication_Id_Test()
    {
        ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

        UpdateApplicationDTO app;

        ArrayList<String> images = new ArrayList<>();
        images.add("a");
        images.add("a");

        //Id is null expect false
        app = new UpdateApplicationDTO(null,"a", "a",images,"a");
        assertEquals(false, applicationService.updateApplications(app));

        //Id is empty expect false
        app = new UpdateApplicationDTO("","a", "a",images,"a");
        assertEquals(false, applicationService.updateApplications(app));

        //Id is not null or empty expect true
        app = new UpdateApplicationDTO("1","a", "a",images,"a");
        assertEquals(true, applicationService.updateApplications(app));

        //Id exist in database expect false
        app = new UpdateApplicationDTO("10","a", "a",images,"a");
        assertEquals(false, applicationService.updateApplications(app));
    }

    @Test
    void UpdateApplication_Description_Test()
    {
        ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

        UpdateApplicationDTO app;

        ArrayList<String> images = new ArrayList<>();
        images.add("a");
        images.add("a");

        //Description is null expect false
        app = new UpdateApplicationDTO("1","a", null,images,"a");
        assertEquals(false, applicationService.updateApplications(app));

        //Description is empty expect false
        app = new UpdateApplicationDTO("1","a", "",images,"a");
        assertEquals(false, applicationService.updateApplications(app));

        //Description is not null or empty expect true
        app = new UpdateApplicationDTO("1","a", "a",images,"a");
        assertEquals(true, applicationService.updateApplications(app));

    }

    @Test
    void UpdateApplication_Image_Test()
    {
        ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

        UpdateApplicationDTO app;

        ArrayList<String> images = new ArrayList<>();

        //Images size is 0 expect false
        app = new UpdateApplicationDTO("1","a", "a", images ,"a");
        assertEquals(0, images.size());
        assertEquals(false, applicationService.updateApplications(app));

        images.add("a");

        //Images size is 1 expect true
        app = new UpdateApplicationDTO("1","a", "a",images,"a");
        assertEquals(1, images.size());
        assertEquals(true, applicationService.updateApplications(app));

        for(int i =0; i < 10; i++) {
            images.add("a");
        }

        //Id is not null or empty expect true
        app = new UpdateApplicationDTO("1","a", "a",images,"a");
        assertEquals(11, images.size());
        assertEquals(false, applicationService.updateApplications(app));
    }

    @Test
    void UpdateApplication_Icon_Test()
    {
        ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

        UpdateApplicationDTO app;

        ArrayList<String> images = new ArrayList<>();
        images.add("a");
        images.add("a");

        //Icon is null expect false
        app = new UpdateApplicationDTO("1","a", "a",images,null);
        assertEquals(false, applicationService.updateApplications(app));

        //Icon is empty expect false
        app = new UpdateApplicationDTO("1","a", "a",images,"");
        assertEquals(false, applicationService.updateApplications(app));

        //Icon is not null or empty expect true
        app = new UpdateApplicationDTO("1","a", "a",images,"a");
        assertEquals(true, applicationService.updateApplications(app));

    }
    @Test
    void getCreatorTest(){
        CreatorRepository creatorRepository = new CreatorRepositoryImpl();
        CreatorService creatorService = new CreatorServiceImpl(creatorRepository);

        assertNotEquals(null,creatorService.getCreator(1));
    }
}
