package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.StuData;

import jakarta.transaction.Transactional;

@Repository
public interface StuRepo extends JpaRepository<StuData, Integer>{
	
	
	@Query("select s from StuData s where s.name = :name and s.area = :area")
    List<StuData> getByNameArea(@Param("name") String name, @Param("area") String area);

	@Transactional
	@Modifying
	@Query("update StuData u set u.name = :name where u.id = :id")
	int updateName(@Param("id") int id, @Param("name") String name);

	@Transactional
	@Modifying
	@Query(value = "update studentdatas st set st.area = :ar where st.id = :id", nativeQuery = true)
	public int updateArea(@Param("id") int id, @Param("area") String ar);

	}
