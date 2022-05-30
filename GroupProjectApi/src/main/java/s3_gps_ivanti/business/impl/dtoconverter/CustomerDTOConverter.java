package s3_gps_ivanti.business.impl.dtoconverter;

import s3_gps_ivanti.DTO.CustomerDTO;
import s3_gps_ivanti.model.Customer;
import s3_gps_ivanti.model.User;

public class CustomerDTOConverter {
    private CustomerDTOConverter() {

    }
    public static Customer convertToModel(CustomerDTO dto){
        return (Customer) User.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getFirstName())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }
}
