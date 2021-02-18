package com.trains.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trains.model.Graph;

@Service
public class TrainsService implements ITrainsService {

	@Autowired
	private ArrayList<Graph> graphs;

	@SuppressWarnings("unchecked")
	@Override
	public String getDistance(String route) throws Exception {
		Integer result = 0;
		String[] ways;
		Boolean found = false;
		ArrayList<Graph> graphsAux = new ArrayList<Graph>();
		int j = 0;
		
		ways = route.split("-");

		for (int i = 0; i < ways.length - 1; i++) {
			found = false;
			j = 0;
			graphsAux = (ArrayList<Graph>) graphs.clone();
			
			while (!found && j < graphsAux.size()) {
				if (graphsAux.get(j).getStart().equals( ways[ i ] ) && graphsAux.get( j ).getEnd().equals(ways[i + 1])) {
					result += graphsAux.get( j ).getDistance();
					found = true;
					graphsAux.remove(j);
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
