package tn.esprit.coexist.repository.ColocationRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;

@Repository
public interface AnnoncementCollocationRepository extends JpaRepository<AnnoncementCollocation,Integer> {


}
