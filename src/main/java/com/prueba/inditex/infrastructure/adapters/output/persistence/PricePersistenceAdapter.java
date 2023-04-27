package com.prueba.inditex.infrastructure.adapters.output.persistence;

import com.prueba.inditex.application.ports.output.PriceOutputPort;
import com.prueba.inditex.domain.model.Price;
import com.prueba.inditex.infrastructure.adapters.output.persistence.entity.PriceEntity;
import com.prueba.inditex.infrastructure.adapters.output.persistence.mapper.PricePersistenceMapper;
import com.prueba.inditex.infrastructure.adapters.output.persistence.repository.PriceRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class PricePersistenceAdapter implements PriceOutputPort {

    private final PriceRepository priceRepository;

    private final PricePersistenceMapper pricePersistenceMapper;

    @PersistenceContext
	EntityManager em;
    
	@Override
    public Price savePrice(Price price) {
        PriceEntity productEntity = pricePersistenceMapper.toPriceEntity(price);
        productEntity = priceRepository.save(productEntity);
        return pricePersistenceMapper.toPrice(productEntity);
    }

    @Override
    public Optional<Price> getPriceById(Long id) {
        Optional<PriceEntity> productEntity = priceRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Price price = pricePersistenceMapper.toPrice(productEntity.get());
        return Optional.of(price);
    }

    @Override
    public Optional<Price> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<PriceEntity> cq = cb.createQuery(PriceEntity.class);	 
	    Root<PriceEntity> rootApplications = cq.from(PriceEntity.class);	 
	    List<Predicate> predicates = new ArrayList<>();	     
	    	    
	    if (productId != null) {
	        predicates.add(cb.equal(rootApplications.get("product_id"), productId));
	    }	    
	    if (brandId != null) {
	        predicates.add(cb.equal(rootApplications.get("brand_id"), brandId));
        }
        if (applicationDate!=null) {	                        
            predicates.add(cb.lessThanOrEqualTo(rootApplications.get("start_date"), applicationDate));
            predicates.add(cb.greaterThanOrEqualTo(rootApplications.get("end_date"), applicationDate));            
	    }
        cq.where(predicates.toArray(new Predicate[0]));       	    
	    TypedQuery<PriceEntity> typed = em.createQuery(cq);  
        
        Comparator<PriceEntity> comparator = Comparator.comparing( PriceEntity::getPriority ); 
        PriceEntity minObject = typed.getResultList().stream().max(comparator).get();

     
	    Price price = pricePersistenceMapper.toPrice(minObject);
        return Optional.of(price);           
        
    }
}
