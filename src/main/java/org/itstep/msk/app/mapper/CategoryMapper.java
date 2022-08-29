package org.itstep.msk.app.mapper;

import lombok.RequiredArgsConstructor;
import org.itstep.msk.app.entity.Category;
import org.itstep.msk.app.entity.model.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

   private static ModelMapper mapper;

    public static Category fromDto(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setImage(categoryDTO.getImage());
        category.setName(categoryDTO.getName());
        mapper.map(categoryDTO,Category.class);
        return category;
    }

    public static CategoryDTO fromEntity(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setImage(category.getImage());
        categoryDTO.setName(category.getName());
        return mapper.map(category, CategoryDTO.class);
    }

}
