package org.itstep.msk.app.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {


    private Integer id;
    @NotBlank
    @JsonFormat
    private String name;

    @JsonFormat
    private String image;
}
