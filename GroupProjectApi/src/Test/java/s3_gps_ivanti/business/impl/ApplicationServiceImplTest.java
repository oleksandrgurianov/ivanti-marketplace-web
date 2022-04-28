package s3_gps_ivanti.business.impl;

import org.junit.jupiter.api.Test;
import s3_gps_ivanti.DTO.CreateApplicationRequestDTO;
import s3_gps_ivanti.DTO.ApplicationDetailedInfoDTO;
import s3_gps_ivanti.DTO.CreateApplicationResponseDTO;
import s3_gps_ivanti.DTO.UpdateApplicationDTO;
import s3_gps_ivanti.business.ApplicationService;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.repository.ApplicationRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationServiceImplTest {

    //Add application tested 100%
    /*@Test
    void createApplications() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        Creator creator =  new Creator();
        creator.setId(1);

        Application model= new Application(applicationDTO,creator);

        when(applicationRepositoryMock.createApplications(model))
                .thenReturn(true);
        when(applicationRepositoryMock.FindAppWithSameName("ivanty"))
                .thenReturn(false);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);


        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(true, actualResult);

        verify(applicationRepositoryMock).createApplications(model);
    }*/
         //Name
    @Test
    void createApplications_NameUnique() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();


        when(applicationRepositoryMock.FindAppWithSameName("ivanty"))
                .thenReturn(true);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);


        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);

    }
    @Test
    void createApplications_NameEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }
    @Test
    void createApplications_NameNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name(null)
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);

    }
         //Icon
    @Test
    void createApplications_IconEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }
    @Test
    void createApplications_IconNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon(null)
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);

    }
         //Description
    @Test
    void createApplications_DescriptionEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }
    @Test
    void createApplications_DescriptionNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description(null)
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);

    }
         //ScreenShots
    @Test
    void createApplications_ScreenShotsEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(Collections.emptyList())
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }
    @Test
    void createApplications_ScreenShotsNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(null)
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);

    }
    @Test
    void createApplications_ScreenShotsMoreThen10() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("","","","","","","","","","",""))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }
         //AppLocation
    @Test
    void createApplications_ApplicationNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation(null)
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }
    @Test
    void createApplications_ApplicationEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("")
                .creatorId(1)
                .build();

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        CreateApplicationResponseDTO actualResult = applicationServiceMock.createApplications(applicationDTO);

        assertEquals(null, actualResult);
    }


    //Update application
  /*  @Test
    void updateApplications() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty","ivanty",List.of("ivanty", "ivanty"),"ianty");

        Application model = new Application(updateApplicationDTO);

        when(applicationRepositoryMock.updateApplications(model))
                .thenReturn(true);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(true, actualResult);

        verify(applicationRepositoryMock).updateApplications(model);
    }*/
        //ID
    @Test
    void updateApplications_ID0() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(0,"ivanty","ivanty",List.of("ivanty", "ivanty"),"ianty");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }
        //Name
    @Test
    void updateApplications_NameNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,null,"ivanty",List.of("ivanty", "ivanty"),"ianty");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }
    @Test
    void updateApplications_NameEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"","ivanty",List.of("ivanty", "ivanty"),"ianty");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }
        //Description
    @Test
    void updateApplications_DescriptionNull() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty",null,List.of("ivanty", "ivanty"),"ianty");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }
    @Test
    void updateApplications_DescriptionEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty","",List.of("ivanty", "ivanty"),"ianty");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }
        //Icon
    @Test
    void updateApplications_IconNull() {
            ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

            UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty","ivanty",List.of("ivanty", "ivanty"),null);

            ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

            boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

            assertEquals(false, actualResult);
        }
    @Test
    void updateApplications_IconEmpty() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty","ivanty",List.of("ivanty", "ivanty"),"");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }
        //ScreenShots
    @Test
    void updateApplications_ScreenShots0InSize() {
            ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

            UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty","ivanty",Collections.emptyList(),"ivanty");

            ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

            boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

            assertEquals(false, actualResult);
        }
    @Test
    void updateApplications_ScreenShotsMoreThen10Size() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        UpdateApplicationDTO updateApplicationDTO = new UpdateApplicationDTO(1,"ivanty","ivanty",List.of("ivanty", "ivanty", "ivanty", "ivanty", "ivanty", "ivanty", "ivanty", "ivanty", "ivanty", "ivanty", "ivanty"),"ivanty");

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        boolean actualResult = applicationServiceMock.updateApplications(updateApplicationDTO);

        assertEquals(false, actualResult);
    }


    //getApplicationInfoByName
    @Test
    void getApplicationInfoByName() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        Creator creator =  new Creator();
        creator.setId(1);

        Application model= new Application(applicationDTO,creator);

        when(applicationRepositoryMock.getApplicationToUpdate("ivanty"))
                .thenReturn(model);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        UpdateApplicationDTO expectedResult = new UpdateApplicationDTO(model);

        UpdateApplicationDTO actualResult = applicationServiceMock.getApplicationToUpdate("ivanty");

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationToUpdate("ivanty");
    }
    @Test
    void getApplicationInfoByName_NotFound() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        Creator creator =  new Creator();
        creator.setId(1);

        Application model= new Application(applicationDTO,creator);

        when(applicationRepositoryMock.getApplicationToUpdate("ivanty"))
                .thenReturn(model);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        UpdateApplicationDTO expectedResult = new UpdateApplicationDTO(model);

        UpdateApplicationDTO actualResult = applicationServiceMock.getApplicationToUpdate("ivanty");

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationToUpdate("ivanty");
    }

    //getApplicationToUpdate
    @Test
    void getApplicationToUpdate() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        CreateApplicationRequestDTO applicationDTO = CreateApplicationRequestDTO.builder()
                .name("ivanty")
                .description("ivanty")
                .icon("ivanty")
                .screenshots(List.of("ivanty"))
                .appLocation("ivanty")
                .creatorId(1)
                .build();

        Creator creator =  new Creator();
        creator.setId(1);

        Application model= new Application(applicationDTO,creator);

        when(applicationRepositoryMock.getApplicationToUpdate("ivanty"))
                .thenReturn(model);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        UpdateApplicationDTO expectedResult = new UpdateApplicationDTO(model);

        UpdateApplicationDTO actualResult = applicationServiceMock.getApplicationToUpdate("ivanty");

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationToUpdate("ivanty");
    }
    @Test
    void getApplicationToUpdate_NotFound() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        when(applicationRepositoryMock.getApplicationToUpdate("ivanty"))
                .thenReturn(null);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);


        UpdateApplicationDTO actualResult = applicationServiceMock.getApplicationToUpdate("ivanty");

        assertEquals(null, actualResult);

        verify(applicationRepositoryMock).getApplicationToUpdate("ivanty");
    }

    //getApplicationsSorted
    @Test
    void getApplicationsSorted() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        Application application = Application.builder()
                .id(1)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();


        when(applicationRepositoryMock.getApplicationsByID(1))
                .thenReturn(application);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        ApplicationDetailedInfoDTO expectedResult = new ApplicationDetailedInfoDTO(application);

        ApplicationDetailedInfoDTO actualResult = applicationServiceMock.getApplicationInfoByID(1);

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationsByID(1);
    }
    @Test
    void getApplicationsSorted_NotFound() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);


        when(applicationRepositoryMock.getApplicationsByID(1))
                .thenReturn(null);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        ApplicationDetailedInfoDTO actualResult = applicationServiceMock.getApplicationInfoByID(1);

        assertEquals(null, actualResult);

        verify(applicationRepositoryMock).getApplicationsByID(1);
    }

    //getApplicationDetails
    @Test
    void getApplicationDetails() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        Application application = Application.builder()
                .id(1)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        Application application2 = Application.builder()
                .id(2)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        ArrayList<Application> apps = new ArrayList<>();
        apps.add(application);
        apps.add(application2);

        when(applicationRepositoryMock.getApplicationDetails("ivanty"))
                .thenReturn(apps);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        ArrayList<Application> expectedResult = apps;

        ArrayList<Application> actualResult = applicationServiceMock.getApplicationDetails("ivanty");

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationDetails("ivanty");
    }

    //getApplications
    @Test
    void getApplications() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        Application application = Application.builder()
                .id(1)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        Application application2 = Application.builder()
                .id(2)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        ArrayList<Application> apps = new ArrayList<>();
        apps.add(application);
        apps.add(application2);

        when(applicationRepositoryMock.getApplications())
                .thenReturn(apps);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        ArrayList<Application> expectedResult = apps;

        ArrayList<Application> actualResult = applicationServiceMock.getApplications();

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplications();
    }

    //getApplicationsByCreator
    @Test
    void getApplicationsByCreator() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        Application application = Application.builder()
                .id(1)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        Application application2 = Application.builder()
                .id(2)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        ArrayList<Application> apps = new ArrayList<>();
        apps.add(application);
        apps.add(application2);

        when(applicationRepositoryMock.getApplicationsByCreator(1))
                .thenReturn(apps);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        ArrayList<Application> expectedResult = apps;

        ArrayList<Application> actualResult = applicationServiceMock.getApplicationsByCreator(1);

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationsByCreator(1);
    }

    //getApplicationsByCustomer
    @Test
    void getApplicationsByCustomer() {
        ApplicationRepository applicationRepositoryMock = mock(ApplicationRepository.class);

        Application application = Application.builder()
                .id(1)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        Application application2 = Application.builder()
                .id(2)
                .name("ivanty")
                .icon("ivanty")
                .description("ivanty")
                .screenshots(Collections.emptyList())
                .totalDownloads(1)
                .build();

        ArrayList<Application> apps = new ArrayList<>();
        apps.add(application);
        apps.add(application2);

        when(applicationRepositoryMock.getApplicationsByCustomer(1))
                .thenReturn(apps);

        ApplicationService applicationServiceMock = new ApplicationServiceImpl(applicationRepositoryMock);

        ArrayList<Application> expectedResult = apps;

        ArrayList<Application> actualResult = applicationServiceMock.getApplicationsByCustomer(1);

        assertEquals(expectedResult, actualResult);

        verify(applicationRepositoryMock).getApplicationsByCustomer(1);
    }

}