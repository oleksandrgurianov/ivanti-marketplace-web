package s3_gps_ivanti.business.user;

import s3_gps_ivanti.dto.user.CustomerBasicInfoDTO;

import java.util.List;

public interface GetCustomersUseCase {

    List<CustomerBasicInfoDTO> getAllCustomers();
}
