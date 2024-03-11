package tn.esprit.coexist.service.ColocationService.AnnoncementCollocation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.ColocationEntity.AnnoncementCollocation;
import tn.esprit.coexist.repository.ColocationRepository.AnnoncementCollocationRepository;
import tn.esprit.coexist.service.ICRUDService;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AnnoncementCollocationServiceImp implements ICRUDService<AnnoncementCollocation,Integer>, AnnoncementCollocationService {

  @Autowired
    AnnoncementCollocationRepository annoncementCollocationRepository ;

    @Override
    public List<AnnoncementCollocation> findAll() {
        return annoncementCollocationRepository.findAll();
    }

    @Override
    public AnnoncementCollocation retrieveItem(Integer idItem) {
        return annoncementCollocationRepository.findById(idItem).get();
    }

    @Override
    public AnnoncementCollocation add(AnnoncementCollocation class1) {
        return annoncementCollocationRepository.save(class1);
    }

    @Override
    public void delete(Integer idAnn) {
        annoncementCollocationRepository.deleteById(idAnn);

    }

    @Override
    public AnnoncementCollocation update(Integer id, AnnoncementCollocation Classe1) {
        Optional<AnnoncementCollocation> existingSubjectOptional = annoncementCollocationRepository.findById(id);

        if (existingSubjectOptional.isPresent()) {
            AnnoncementCollocation existingSubject = existingSubjectOptional.get();
            existingSubject.setAddress(Classe1.getAddress());

            return annoncementCollocationRepository.save(existingSubject);
        } else {
            return null;
        }}

}



