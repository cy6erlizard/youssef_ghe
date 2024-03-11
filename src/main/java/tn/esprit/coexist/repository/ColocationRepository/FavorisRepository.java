package tn.esprit.coexist.repository.ColocationRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;
import tn.esprit.coexist.entity.ColocationEntity.Favoris;
import tn.esprit.coexist.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris,Integer> {

    Optional<Favoris> findByUserAndAnnoncementCollocation(User user, AnnoncementCollocation annonce);
    List<Favoris> findByAnnoncementCollocation(AnnoncementCollocation annonce);
}
