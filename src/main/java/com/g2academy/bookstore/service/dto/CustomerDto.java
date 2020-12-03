package com.g2academy.bookstore.service.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerDto {

    Long id;
    String email;
    String name;
    String phone;
    String address;
}
