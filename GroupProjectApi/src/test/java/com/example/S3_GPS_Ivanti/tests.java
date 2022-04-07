package com.example.S3_GPS_Ivanti;


import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import s3_gps_ivanti.DTO.AddApplicationDTO;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.business.impl.ApplicationServiceImpl;
import s3_gps_ivanti.repository.ApplicationRepository;
import s3_gps_ivanti.repository.impl.ApplicationRepositoryImpl;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class tests {

    /*User*/

        @Test
        void CreateApplication_Name_Test()
        {
            ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

            AddApplicationDTO app;

            ArrayList<String> images = new ArrayList<>();
            images.add("a");
            images.add("a");

            //Name is null expect false
            app = new AddApplicationDTO(null, "a",images,"a");
            assertEquals(false, applicationService.createApplications(app));

            //Name is empty expect false
            app = new AddApplicationDTO("", "a",images,"a");
            assertEquals(false, applicationService.createApplications(app));

            //Name is not null or empty expect true
            app = new AddApplicationDTO("a", "a",images,"a");
            assertEquals(true, applicationService.createApplications(app));

            //Name already exists in database expect false
            app = new AddApplicationDTO("a", "a",images,"a");
            assertEquals(false, applicationService.createApplications(app));
        }

        @Test
        void CreateApplication_Description_Test()
        {
            ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

            AddApplicationDTO app;

            ArrayList<String> images = new ArrayList<>();
            images.add("a");
            images.add("a");

            //Description is null expect false
            app = new AddApplicationDTO("a", null,images,"a");
            assertEquals(false, applicationService.createApplications(app));

            //Description is empty expect false
            app = new AddApplicationDTO("a", "",images,"a");
            assertEquals(false,applicationService.createApplications(app));

            //Description is not null or empty expect true
            app = new AddApplicationDTO("a", "a",images,"a");
            assertEquals(true, applicationService.createApplications(app));
        }

        @Test
        void CreateApplication_Images_Test()
        {
            ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

            AddApplicationDTO app;

            ArrayList<String> images = new ArrayList<>();
            images.add("a");
            images.add("a");

            //Image is null expect false
            app = new AddApplicationDTO("a", "a",null,"a");
            assertEquals(false,applicationService.createApplications(app));

            //Image is empty expect false
            app = new AddApplicationDTO("a", "a",new ArrayList<String>(),"a");
            assertEquals(false,applicationService.createApplications(app));

            //Image has 2 size expect false
            app = new AddApplicationDTO("a", "a",images,"a");
            assertEquals(true,applicationService.createApplications(app));

            for(int i=0; i < 10; i++)
            {
                images.add("a");
            }

            //Image has more than 10 size expect false
            app = new AddApplicationDTO("a", "a",images,"a");
            assertEquals(false, applicationService.createApplications(app));

        }

        @Test
        void CreateApplication_Icon_Test()
        {
            ApplicationService applicationService = new ApplicationServiceImpl(new ApplicationRepositoryImpl());

            AddApplicationDTO app;

            ArrayList<String> images = new ArrayList<>();
            images.add("a");
            images.add("a");

            //Icon is null expect false
            app = new AddApplicationDTO("a", "a",images,null);
            assertEquals(false, applicationService.createApplications(app));

            //Icon is empty expect false
            app = new AddApplicationDTO("a", "a",images,"");
            assertEquals(false,applicationService.createApplications(app));

            //Icon is not null or empty expect true
            app = new AddApplicationDTO("a", "a",images,"a");
            assertEquals(true, applicationService.createApplications(app));

    }
}
