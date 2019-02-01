package com.filipetobias.sbm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;

    private String minDate;

    private String maxDate;
}
