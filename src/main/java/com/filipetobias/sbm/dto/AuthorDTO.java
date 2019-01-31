package com.filipetobias.sbm.dto;

import com.filipetobias.sbm.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }
}
