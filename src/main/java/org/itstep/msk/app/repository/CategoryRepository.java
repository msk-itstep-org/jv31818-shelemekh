package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {

    Optional<Category>findFirstByName(String name);

    @Modifying(clearAutomatically = true)
    @Query("update Category  c set c.name = :name")
    void updateCategoryName(@Param("name") String name);



}
