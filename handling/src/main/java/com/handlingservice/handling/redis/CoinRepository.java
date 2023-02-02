package com.handlingservice.handling.redis;

import com.handlingservice.handling.models.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends CrudRepository<Coin, String> {
}
