package com.trains.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trains.model.Graph;

@Configuration
public class AppConfig {

	@Bean
	public ArrayList<Graph> produceGraph() {
		ArrayList<Graph> graphs = new ArrayList<Graph>();

		graphs.add(new Graph("A", "B", 5));
		graphs.add(new Graph("B", "C", 4));
		graphs.add(new Graph("C", "D", 8));
		graphs.add(new Graph("D", "C", 8));
		graphs.add(new Graph("D", "E", 6));
		graphs.add(new Graph("A", "D", 5));
		graphs.add(new Graph("C", "E", 2));
		graphs.add(new Graph("E", "B", 3));
		graphs.add(new Graph("A", "E", 7));

		return graphs;
	}

}
