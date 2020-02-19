package com.kforce.reward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kforce.reward.exception.RecordNotFoundException;
import com.kforce.reward.service.RewardPointService;

@RestController()
@RequestMapping("/rewards")
public class RewardPointController {

	@Autowired
	RewardPointService rewardPointService;

	@GetMapping("/{month}")
	public ResponseEntity<Integer> getRewardPointByMonth(@PathVariable String month) throws RecordNotFoundException {
		Integer reward = rewardPointService.getRewardPointByMonth(month);
		return new ResponseEntity<Integer>(reward, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<Integer> getTotalRewardPoint() {
		Integer totalRewards = rewardPointService.getTotalRewards();
		return new ResponseEntity<Integer>(totalRewards, HttpStatus.OK);
	}
}
