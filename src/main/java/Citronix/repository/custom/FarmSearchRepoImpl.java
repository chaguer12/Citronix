package Citronix.repository.custom;

import Citronix.dto.records.farm.FarmSearchDTO;
import Citronix.model.Farm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class FarmSearchRepoImpl implements FarmSearchRepo{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Farm> searchFarms(FarmSearchDTO criteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Farm> query = cb.createQuery(Farm.class);
        Root<Farm> farm = query.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();
        if (criteria.name() != null && !criteria.name().isBlank()) {
            predicates.add(cb.like(cb.lower(farm.get("name")), "%" + criteria.name().toLowerCase() + "%"));
        }

        if (criteria.location() != null && !criteria.location().isBlank()) {
            predicates.add(cb.equal(farm.get("location"), criteria.location()));
        }

        if (criteria.superficie() != 0) {
            predicates.add(cb.greaterThanOrEqualTo(farm.get("superficie"), criteria.superficie()));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));
        return em.createQuery(query).getResultList();
    }
}
