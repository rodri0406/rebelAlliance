package com.rebel.alliance.app.services;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.rebel.alliance.app.entities.Coordinate;

@Service
public class LocationService implements ILocationService {

	private double[][] positions = new double[][]{{-500, -200},{100, -100},{500, 100}};

	@Override
	public Coordinate getLocation(double[] distances) {
		NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
		double[] coordinates = solver.solve().getPoint().toArray();
		return new Coordinate(coordinates[0], coordinates[1]);
	
	}	

}
