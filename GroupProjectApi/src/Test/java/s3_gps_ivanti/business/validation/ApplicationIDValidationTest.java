package s3_gps_ivanti.business.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import s3_gps_ivanti.business.exception.ApplicationNotFoundException;
import s3_gps_ivanti.repository.ApplicationRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationIDValidationTest {

    @Mock
    private ApplicationRepository applicationRepository;
    @InjectMocks
    private ApplicationIDValidation applicationIDValidation;

    @Test
    void applicationIdIsValid() {

        when(applicationRepository.existsById("id"))
                .thenReturn(true);

        applicationIDValidation.applicationIdIsValid("id");

        verify(applicationRepository).existsById("id");
    }

    @Test
    void applicationIdIsValid_DosntExist() {

        when(applicationRepository.existsById("id"))
                .thenReturn(false);

       assertThrows(ApplicationNotFoundException.class,() -> applicationIDValidation.applicationIdIsValid("id"));

        verify(applicationRepository).existsById("id");
    }
}