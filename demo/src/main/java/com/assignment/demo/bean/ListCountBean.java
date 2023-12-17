package com.assignment.demo.bean;

public class ListCountBean {
	private String name;
	private Integer voteCount;


	public ListCountBean(String name, Integer voteCount) {
		super();
		this.name = name;
		this.voteCount = voteCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

}
