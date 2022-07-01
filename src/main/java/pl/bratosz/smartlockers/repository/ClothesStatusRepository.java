package pl.bratosz.smartlockers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bratosz.smartlockers.model.clothes.ClothStatusHistory;

@Repository
public interface ClothesStatusRepository extends JpaRepository<ClothStatusHistory, Long> {
    @Transactional
    @Modifying
    @Query("delete from ClothStatusHistory s where s.id = :id ")
    void deleteById(long id);

}
