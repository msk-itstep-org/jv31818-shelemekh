package org.itstep.msk.app.mapper;

import org.itstep.msk.app.entity.Category;
import org.itstep.msk.app.entity.model.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static Category fromDto(CategoryDTO categoryDTO) {
        MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setImage(categoryDTO.getImage());
        category.setName(categoryDTO.getName());
        return MAPPER.map(categoryDTO, Category.class);
    }

    public static CategoryDTO fromEntity(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setImage(category.getImage());
        categoryDTO.setName(category.getName());
        return MAPPER.map(category, CategoryDTO.class);
    }

}
