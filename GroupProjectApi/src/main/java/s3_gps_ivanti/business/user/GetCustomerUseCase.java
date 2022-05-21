package s3_gps_ivanti.business.user;

import s3_gps_ivanti.repository.entity.User;

public interface GetCustomerUseCase {

    User getCustomer(String username);
}
