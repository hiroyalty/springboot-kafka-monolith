package com.hiroyalty.kafka.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    private int id;
    private String firstname;
    private String lastname;
}
