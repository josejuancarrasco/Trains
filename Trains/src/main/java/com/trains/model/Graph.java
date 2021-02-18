package com.trains.model;

public class Graph {

	private String start;
	private String end;
	private Integer distance;

	public Graph() {

	}

	public Graph(String start, String end, Integer distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	

}
