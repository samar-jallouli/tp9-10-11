package com.samar.makeup.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.samar.makeup.entities.Brand;
import com.samar.makeup.entities.Makeup;

public interface MakeupRepository extends JpaRepository<Makeup, Long> {

	List<Makeup> findBynomMakeup(String nom);
	List<Makeup> findBynomMakeupContains(String nom);
	
	/*@Query("select m from Makeup m where m.nomMakeup like %?1 and m.prixMakeup > ?2")
	List<Makeup> findByNomPrix (String nom, Double prix);*/

	@Query("select m from Makeup m where m.nomMakeup like %:nom and m.prixMakeup  > :prix")
	List<Makeup> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select m from Makeup m where m.brand = ?1")
	List<Makeup> findByBrand (Brand brand);
	
	List<Makeup> findByBrandIdB(Long id);
	
	List<Makeup> findByOrderByNomMakeupAsc();
	
	@Query("select m from Makeup m order by m.nomMakeup ASC, m.prixMakeup DESC")
	List<Makeup> trierMakeupNomsPrix ();
	
	
	
	
	
	
	
	
	
	
	
	

}

