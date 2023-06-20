package com.dp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dp.model.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
	
	@Query("from Insumo i where i.location.region = :region and i.type = :type")
	Page<Insumo> list(String region, String type, Pageable pageable);

}
