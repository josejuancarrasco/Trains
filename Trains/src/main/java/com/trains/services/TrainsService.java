package com.trains.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trains.model.Graph;

@Service
public class TrainsService implements ITrainsService {

	@Autowired
	private ArrayList<Graph> graphs;

	@Override
	public String getDistance(String route) throws Exception {
		Integer result = 0;
		String[] ways;
		Boolean found = false;
		int j = 0;
		ways = route.split("-");

		for (int i = 0; i < ways.length - 1; i++) {
			found = false;
			j = 0;
			while (!found && j < graphs.size()) {
				if (graphs.get(j).getStart().equals( ways[ i ] ) && graphs.get( j ).getEnd().equals(ways[i + 1])) {
					result += graphs.get( j ).getDistance();
					found = true;
				}
				j++;
			}
		}

		if (found)
			return result.toString();
		else
			throw new Exception("No such route");
	}
}
