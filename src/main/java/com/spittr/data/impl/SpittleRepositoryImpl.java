package com.spittr.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;

public class SpittleRepositoryImpl implements SpittleRepository {

	@Override
	// As of now, the method returns a dummy list of 20 spittles
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittleList = new ArrayList<Spittle>(count);
		
		for (int i = 0; i < count; i++)	{
			spittleList.add(new Spittle("Spittle " + (i+1), new Date()));
		}
		
		return spittleList;
	}

	@Override
	public Spittle findOne(long spittleId) {
		return new Spittle(Long.valueOf(spittleId));
	}
	
	@Override
	public void save(Spittle spittle)	{
		// This method will persist the spittle
	}

}
