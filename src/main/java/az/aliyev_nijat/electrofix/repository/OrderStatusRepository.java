package az.aliyev_nijat.electrofix.repository;

import az.aliyev_nijat.electrofix.model.entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatusEntity, Long> {

    Optional<OrderStatusEntity> findByStatus(String status);
}
