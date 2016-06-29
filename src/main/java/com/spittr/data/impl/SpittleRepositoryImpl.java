package com.spittr.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittleList = new ArrayList<Spittle>(count);
		
		for (int i = 0; i < count; i++)	{
			spittleList.add(new Spittle("Spittle " + i, new Date()));
		}
		
		return spittleList;
	}

}
