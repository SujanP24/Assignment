package com.assignment.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.demo.bean.CountBean;
import com.assignment.demo.bean.GetWinnerBean;
import com.assignment.demo.bean.ListCountBean;
import com.assignment.demo.exception.CommonCustomException;

@Service
public interface CandidateService {

	boolean createCandidate(String name);

	CountBean casteVote(String name) throws CommonCustomException;

	CountBean countVote(String name) throws CommonCustomException;

	List<ListCountBean> listVote();

	GetWinnerBean getWinner();



}
