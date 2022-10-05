package org.itstep.msk.app.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CategoryDTO {

    private Integer id;
    @NotBlank
    private String name;

    private String image;

}
