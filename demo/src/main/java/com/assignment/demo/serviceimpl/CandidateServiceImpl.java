package com.assignment.demo.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.assignment.demo.bean.CountBean;
import com.assignment.demo.bean.GetWinnerBean;
import com.assignment.demo.bean.ListCountBean;
import com.assignment.demo.controller.CandidateController;
import com.assignment.demo.exception.CommonCustomException;
import com.assignment.demo.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {
	public static final Logger LOG = LogManager.getLogger(CandidateServiceImpl.class);

	
	Map<String, Integer> candidateVote = new HashMap<>();

	@Override
	public boolean createCandidate(String name) {
		LOG.info("Entering createCandidate service");
		candidateVote.put(name, 0);
		LOG.info("Exiting createCandidate service");
		return true;
	}

	@Override
	public CountBean casteVote(String name) throws CommonCustomException {
		LOG.info("Entering casteVote service");

		CountBean count = new CountBean();
		Integer voteCount = 0;
		if (candidateVote.containsKey(name)) {
			int currentVotes = candidateVote.get(name);
			candidateVote.put(name, currentVotes + 1);
			voteCount = currentVotes + 1;

		} else {
			throw new CommonCustomException("Invalid candidate name");
		}
		count.setCount(voteCount);
		LOG.info("Exiting casteVote service");
		return count;
	}

	@Override
	public CountBean countVote(String name) throws CommonCustomException {
		LOG.info("Entering countVote service");
		CountBean output = new CountBean();
		Integer count = 0;
		if (candidateVote.containsKey(name)) {
			count = candidateVote.get(name);

		} else {
			throw new CommonCustomException("Invalid candidate name");
		}
		output.setCount(count);
		LOG.info("Exiting countVote service");
		return output;
	}

	@Override
	public List<ListCountBean> listVote() {
		LOG.info("Entering listVote service");
		List<ListCountBean> output = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : candidateVote.entrySet()) {
			String name = entry.getKey();
			int voteCount = entry.getValue();
			output.add(new ListCountBean(name, voteCount));
		}
		LOG.info("Exiting listVote service");
		return output;
	}

	@Override
	public GetWinnerBean getWinner() {
		LOG.info("Entering getWinner service");
		GetWinnerBean bean = new GetWinnerBean();
		String winner = candidateVote.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.orElse(null);

		if (winner != null && !winner.isEmpty()) {
			bean.setCandidateName(winner);
		}
		LOG.info("Exiting getWinner service");
		return bean;
	}

}
