package com.example.demo1.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RecommendationRecord;

@Repository
public interface RecommendationRecordRepository extends JpaRepository<RecommendationRecord,Long>{
    List<RecommendationRecord> findByUserId(Long userId);

}
package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CreditCardRecord;

@Repository
public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord, Long> {

    List<CreditCardRecord> findByUserId(Long userId);
}
