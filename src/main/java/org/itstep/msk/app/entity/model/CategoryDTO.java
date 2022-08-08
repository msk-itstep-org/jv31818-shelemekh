package org.itstep.msk.app.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryDTO {


    private Integer id;
    @NotBlank
    @JsonFormat
    private String name;

    private String image;
}
