package s3_gps_ivanti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import s3_gps_ivanti.dto.ApplicationBasicInfoDTO;
import s3_gps_ivanti.dto.CreateApplicationRequestDTO;
import s3_gps_ivanti.dto.CreateApplicationResponseDTO;
import s3_gps_ivanti.dto.UpdateApplicationDTO;
import s3_gps_ivanti.business.impl.ApplicationServiceImpl;
import s3_gps_ivanti.business.impl.CreatorServiceImpl;
import s3_gps_ivanti.model.Application;
import s3_gps_ivanti.model.Creator;
import s3_gps_ivanti.model.Rating;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApplicationController.class)
class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ApplicationServiceImpl applicationService;
    @MockBean
    private CreatorServiceImpl creatorService;

    //createApplications
    @Test
    void createApplications() throws Exception {
        CreateApplicationRequestDTO createProductRequestDTO = CreateApplicationRequestDTO.builder()
                .name("name")
                .description("description")
                .icon("icon")
                .appLocation("appLocation")
                .build();

        CreateApplicationResponseDTO createProductResponseDTO = new CreateApplicationResponseDTO(1);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(createProductRequestDTO);

        when(applicationService.createApplications(createProductRequestDTO))
                .thenReturn(createProductResponseDTO);

        mockMvc.perform(post("/application")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(json))
                .andDo(print())
                .andExpect(status().isCreated());

        verify(applicationService).createApplications(createProductRequestDTO);
    }
    @Test
    void createApplications_NotFound() throws Exception {
        CreateApplicationRequestDTO createProductRequestDTO = CreateApplicationRequestDTO.builder()
                .name("name")
                .description("description")
                .icon("icon")
                .appLocation("appLocation")
                .build();


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(createProductRequestDTO);

        when(applicationService.createApplications(createProductRequestDTO))
                .thenReturn(null);

        mockMvc.perform(post("/application")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(json))
                .andDo(print())
                .andExpect(status().isConflict());

        verify(applicationService).createApplications(createProductRequestDTO);
    }

    //updateApplications
    @Test
    void updateApplications() throws Exception {
        UpdateApplicationDTO updateApplicationDTO = UpdateApplicationDTO.builder()
                .id(1)
                .name("name")
                .description("description")
                .icon("icon")
                .images(Collections.emptyList())
                .build();


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(updateApplicationDTO);

        when(applicationService.updateApplications(updateApplicationDTO))
                .thenReturn(true);

        mockMvc.perform(put("/application")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(json))
                .andDo(print())
                .andExpect(status().isNoContent());

        verify(applicationService).updateApplications(updateApplicationDTO);
    }
    @Test
    void updateApplications_NotFound() throws Exception {
        UpdateApplicationDTO updateApplicationDTO = UpdateApplicationDTO.builder()
                .id(1)
                .name("name")
                .description("description")
                .icon("icon")
                .images(Collections.emptyList())
                .build();


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(updateApplicationDTO);

        when(applicationService.updateApplications(updateApplicationDTO))
                .thenReturn(false);

        mockMvc.perform(put("/application")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest());

        verify(applicationService).updateApplications(updateApplicationDTO);
    }

    //getApplicationToUpdate
    @Test
    void getApplicationToUpdate() throws Exception {
        UpdateApplicationDTO updateApplicationDTO = UpdateApplicationDTO.builder()
                .id(1)
                .name("name")
                .description("description")
                .icon("icon")
                .images(Collections.emptyList())
                .build();


        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(updateApplicationDTO);

        when(applicationService.getApplicationToUpdate("name"))
                .thenReturn(updateApplicationDTO );

        mockMvc.perform(get("/application/creator/appToUpdate/name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json(json));


        verify(applicationService).getApplicationToUpdate("name");
    }
    @Test
    void getApplicationToUpdate_NotFound() throws Exception {

        when(applicationService.getApplicationToUpdate("name"))
                .thenReturn(null);

        mockMvc.perform(get("/application/creator/appToUpdate/name"))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(applicationService).getApplicationToUpdate("name");
    }


    //getAllApplications
    @Test
    void getAllApplications() throws Exception {
        ArrayList<Application> applications = new ArrayList<>();

        applications.add(new Application(1,"name","description",Collections.emptyList(),"icon",new Creator(1,"",""),Collections.emptyList(),"appLocation", new Rating()));
        applications.add(new Application(1,"name","description",Collections.emptyList(),"icon",new Creator(1,"",""),Collections.emptyList(),"appLocation", new Rating()));

        when(applicationService.getApplications())
                .thenReturn(applications);

        ArrayList<ApplicationBasicInfoDTO> applicationBasicInfoDTOS = new ArrayList<>();
        ApplicationBasicInfoDTO applicationBasicInfoDTO;

        for (Application app: applications) {
            applicationBasicInfoDTO = new ApplicationBasicInfoDTO(app);
            applicationBasicInfoDTOS.add(applicationBasicInfoDTO);
        }

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(applicationBasicInfoDTOS);

        mockMvc.perform(get("/application"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json(json));

        verify(applicationService).getApplications();
    }
    @Test
    void getAllApplications_EmptyList() throws Exception {
        when(applicationService.getApplications())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/application"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(applicationService).getApplications();
    }
    @Test
    void getAllApplications_NotFound() throws Exception {

        when(applicationService.getApplications())
                .thenReturn(null);

        mockMvc.perform(get("/application"))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(applicationService).getApplications();
    }
}