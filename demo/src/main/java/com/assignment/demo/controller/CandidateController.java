package com.assignment.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.demo.bean.CountBean;
import com.assignment.demo.bean.GetWinnerBean;
import com.assignment.demo.bean.ListCountBean;
import com.assignment.demo.constants.Constants;
import com.assignment.demo.constants.UrlConstants;
import com.assignment.demo.exception.CommonCustomException;
import com.assignment.demo.service.CandidateService;
import com.assignment.demo.utility.DemoResponse;

@RestController
public class CandidateController {

	public static final Logger LOG = LogManager.getLogger(CandidateController.class);
	
	@Autowired
	CandidateService candidateService;

	/**
	 * @author Sujan P
	 * @description <Create candidate>
	 * @param String name - name of the candidate
	 * @return DemoResponse
	 */
	@PostMapping(value = UrlConstants.CREATE_CANDIDATE)
	public ResponseEntity<DemoResponse> createCandidate(HttpServletRequest request, @RequestParam String name) {
		LOG.info("Entering createCandidate controller");
		DemoResponse response = new DemoResponse();
		boolean isSuccess = false;
		isSuccess = candidateService.createCandidate(name);
		if (isSuccess == true) {
			response.setStatusCode(Constants.APPLICATION_CODE);
			response.setStatus(Constants.SUCCESS);
			response.setMessage(Constants.CANDIDATE_CREATED_MSG);
			response.setUrl(request.getRequestURL() + " ");
		}
		LOG.info("Exiting createCandidate controller");
		return ResponseEntity.status(HttpStatus.OK.value()).body(response);

	}

	/**
	 * @author Sujan P
	 * @description <Cast Vote>
	 * @param String name - name of the candidate
	 * @return DemoResponse
	 */
	@PostMapping(value = UrlConstants.CASTE_VOTE, produces = "application/json")
	public ResponseEntity<DemoResponse> castVote(HttpServletRequest request,
			@RequestParam(name = "name", required = true) String name) throws CommonCustomException {
		LOG.info("Entering castVote controller");
		DemoResponse response = new DemoResponse();
		CountBean count = null;
		try {
			count = candidateService.casteVote(name);
			if (count != null) {
				response.setStatusCode(Constants.APPLICATION_CODE);
				response.setStatus(Constants.SUCCESS);
				response.setResult(Arrays.asList(count));
				response.setMessage(Constants.VOTE_CAST_MSG);
				response.setUrl(request.getRequestURL() + " ");
			}
		} catch (CommonCustomException e) {
			throw new CommonCustomException(e.getStatusCode(), e.getMessage(), e);
		}

		LOG.info("Exiting castVote controller");
		return ResponseEntity.status(HttpStatus.OK.value()).body(response);

	}

	/**
	 * @author Sujan P
	 * @description <Vote Count>
	 * @param String name - name of the candidate
	 * @return DemoResponse
	 */
	@GetMapping(value = UrlConstants.COUNT_VOTE, produces = "application/json")
	public ResponseEntity<DemoResponse> countVote(HttpServletRequest request,
			@RequestParam(name = "name", required = true) String name) throws CommonCustomException {
		LOG.info("Entering countVote controller");
		DemoResponse response = new DemoResponse();
		CountBean count = null;
		try {
			count = candidateService.countVote(name);
			if (count != null) {
				response.setStatusCode(Constants.APPLICATION_CODE);
				response.setStatus(Constants.SUCCESS);
				response.setResult(Arrays.asList(count));
				response.setMessage(Constants.VOTE_COUNT_MSG);
				response.setUrl(request.getRequestURL() + " ");
			}
		} catch (CommonCustomException e) {
			throw new CommonCustomException(e.getStatusCode(), e.getMessage(), e);
		}
		LOG.info("Exiting countVote controller");
		return ResponseEntity.status(HttpStatus.OK.value()).body(response);

	}

	/**
	 * @author Sujan P
	 * @description <List Votes>
	 * @return DemoResponse
	 */
	@GetMapping(value = UrlConstants.LIST_VOTE, produces = "application/json")
	public ResponseEntity<DemoResponse> listVote(HttpServletRequest request) {
		LOG.info("Entering listVote controller");
		DemoResponse response = new DemoResponse();
		List<ListCountBean> output = new ArrayList<>();
		output = candidateService.listVote();
		if (output != null) {
			response.setStatusCode(Constants.APPLICATION_CODE);
			response.setStatus(Constants.SUCCESS);
			response.setResult(Arrays.asList(output));
			response.setMessage(Constants.LIST_VOTE_MSG);
			response.setUrl(request.getRequestURL() + " ");
		} else {
			response.setStatusCode(Constants.APPLICATION_CODE);
			response.setStatus(Constants.SUCCESS);
			response.setResult(null);
			response.setMessage(Constants.NO_RECORD_FOUND_MSG);
			response.setUrl(request.getRequestURL() + " ");

		}
		LOG.info("Exiting listVote controller");
		return ResponseEntity.status(HttpStatus.OK.value()).body(response);

	}

	/**
	 * @author Sujan P
	 * @description <Get Winner>
	 * @return DemoResponse
	 */
	@GetMapping(value = UrlConstants.GET_WINNER, produces = "application/json")
	public ResponseEntity<DemoResponse> getWinner(HttpServletRequest request) {
		LOG.info("Entering getWinner controller");
		DemoResponse response = new DemoResponse();
		GetWinnerBean output = new GetWinnerBean();
		output = candidateService.getWinner();
		if (output != null) {
			response.setStatusCode(Constants.APPLICATION_CODE);
			response.setStatus(Constants.SUCCESS);
			response.setResult(Arrays.asList(output));
			response.setMessage(Constants.WINNER_MSG);
			response.setUrl(request.getRequestURL() + " ");
		} else {
			response.setStatusCode(Constants.APPLICATION_CODE);
			response.setStatus(Constants.SUCCESS);
			response.setResult(null);
			response.setMessage(Constants.NO_RECORD_FOUND_MSG);
			response.setUrl(request.getRequestURL() + " ");

		}
		LOG.info("Exiting getWinner controller");
		return ResponseEntity.status(HttpStatus.OK.value()).body(response);

	}

}
