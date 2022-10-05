package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select c from Category c where c.name= :name")
    Category findByName(@Param("name") String name);

    @Modifying(clearAutomatically = true)
    @Query("update Category  c set c.name = :name")
    void updateCategoryName(@Param("name") String name);

    @EntityGraph(value = "category-entity-graph")
    List<Category> findAll();



}
