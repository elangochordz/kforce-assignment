package com.kforce.reward.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kforce.reward.model.RewardPoint;
import com.kforce.reward.repository.RewardPointRepository;

@Service
public class RewardPointService {
	@Autowired
	RewardPointRepository rewardPointRepository;

	public Integer getRewardPointByMonth(String month) {
		List<RewardPoint> rewards = rewardPointRepository.findByMonth(month);
		return calculateRewardPoints(rewards);
	}

	public Integer getTotalRewards() {
		List<RewardPoint> rewardsAllMonth = (List<RewardPoint>) rewardPointRepository.findAll();
		return calculateRewardPoints(rewardsAllMonth);
	}

	private Integer calculateRewardPoints(List<RewardPoint> rewards) {

		Integer reward = rewards.stream().filter(minimum -> minimum.getAmount() > 50).map(dollar -> {
			if (dollar.getAmount() > 100) {
				return (dollar.getAmount() - 100) * 2 + 50;
			} else {
				return (dollar.getAmount() - 50);
			}
		}).reduce(0, (c, e) -> c + e);
		return reward;
	}
}
