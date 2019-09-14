package fpt.bitcoin.repository;

import fpt.bitcoin.entity.Coin;
import fpt.bitcoin.entity.MaketCoin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaketCoinRepository extends JpaRepository<MaketCoin,Long> {
    Page<MaketCoin> findAllByStatus(int i, Pageable pageable);
}
