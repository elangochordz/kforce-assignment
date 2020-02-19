package com.kforce.reward.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kforce.reward.model.RewardPoint;

@Repository
public interface RewardPointRepository extends PagingAndSortingRepository<RewardPoint, String> {

	List<RewardPoint> findByMonth(String month);
}
