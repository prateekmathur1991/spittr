package com.spittr.data;

import java.util.List;

import com.spittr.Spittle;

public interface SpittleRepository {
	
	 // Queries the spittles database and retrieves the last count no. of spittles,
	 // each having an ID no larger than max.
	List<Spittle> findSpittles(long max, int count);
	
	// Retrieves a single Spittle
	Spittle findOne(long spittleId);
	
	// Persists a created Spittle
	void save(Spittle spittle);
}
