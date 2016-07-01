package com.spittr.data.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;

// Provides SpittleRepository options using Hibernate
@Component
public class SpittleRepositoryHibernateImpl implements SpittleRepository {

	// Hibernate SessionFactory instance
	private SessionFactory sessionFactory;
	
	// Constructor used so that sessionFactory gets initialized
	public SpittleRepositoryHibernateImpl() {
		sessionFactory = new Configuration().addClass(Spittle.class).buildSessionFactory();
	}
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> allSpitlles = null;
		Transaction tx = null;
		
		try (Session session = sessionFactory.getCurrentSession()) {
			
			// Begin Transaction
			tx = session.beginTransaction();
			
			allSpitlles = session.createQuery("from spittles").list();
			
			// End Transaction
			tx.commit();
		} catch (Exception e) {
			if (null != tx)	{
				tx.rollback();
				tx = null;
			}
			
			e.printStackTrace();
		}
		
		return allSpitlles;
	}

	@Override
	public Spittle findOne(long spittleId) {
		Transaction tx = null;
		Spittle spittle = null;
		
		try (Session session = sessionFactory.openSession()) {
			// Begin transaction
			tx = session.beginTransaction();
			
			spittle = (Spittle) session.get(Spittle.class, spittleId);
			
			// Commit Transaction
			tx.commit();
		} catch (Exception e)	{
			if (null != tx)	{
				// Roll back in case of exception
				tx.rollback();
				tx = null;
			}
			
			e.printStackTrace();
		}
		
		return spittle;
	}

	@Override
	public void save(Spittle spittle) {
		Transaction tx = null;
		
		try (Session session = sessionFactory.openSession()) {
			// Begin transaction
			tx = session.beginTransaction();
			
			Long id = (Long) session.save(spittle);
			
			// Commit Transaction
			tx.commit();
		} catch (Exception e)	{
			if (null != tx)	{
				// Roll back in case of exception
				tx.rollback();
				tx = null;
			}
		}
	}
	
}
