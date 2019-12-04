/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package basic.service.persistence.impl;

import basic.exception.NoSuchJourneyException;

import basic.model.Journey;
import basic.model.impl.JourneyImpl;
import basic.model.impl.JourneyModelImpl;

import basic.service.persistence.JourneyPersistence;
import basic.service.persistence.impl.constants.FOOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the journey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = JourneyPersistence.class)
@ProviderType
public class JourneyPersistenceImpl
	extends BasePersistenceImpl<Journey> implements JourneyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JourneyUtil</code> to access the journey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JourneyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public JourneyPersistenceImpl() {
		setModelClass(Journey.class);

		setModelImplClass(JourneyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the journey in the entity cache if it is enabled.
	 *
	 * @param journey the journey
	 */
	@Override
	public void cacheResult(Journey journey) {
		entityCache.putResult(
			entityCacheEnabled, JourneyImpl.class, journey.getPrimaryKey(),
			journey);

		journey.resetOriginalValues();
	}

	/**
	 * Caches the journeies in the entity cache if it is enabled.
	 *
	 * @param journeies the journeies
	 */
	@Override
	public void cacheResult(List<Journey> journeies) {
		for (Journey journey : journeies) {
			if (entityCache.getResult(
					entityCacheEnabled, JourneyImpl.class,
					journey.getPrimaryKey()) == null) {

				cacheResult(journey);
			}
			else {
				journey.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all journeies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JourneyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the journey.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Journey journey) {
		entityCache.removeResult(
			entityCacheEnabled, JourneyImpl.class, journey.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Journey> journeies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Journey journey : journeies) {
			entityCache.removeResult(
				entityCacheEnabled, JourneyImpl.class, journey.getPrimaryKey());
		}
	}

	/**
	 * Creates a new journey with the primary key. Does not add the journey to the database.
	 *
	 * @param journeyId the primary key for the new journey
	 * @return the new journey
	 */
	@Override
	public Journey create(long journeyId) {
		Journey journey = new JourneyImpl();

		journey.setNew(true);
		journey.setPrimaryKey(journeyId);

		return journey;
	}

	/**
	 * Removes the journey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey that was removed
	 * @throws NoSuchJourneyException if a journey with the primary key could not be found
	 */
	@Override
	public Journey remove(long journeyId) throws NoSuchJourneyException {
		return remove((Serializable)journeyId);
	}

	/**
	 * Removes the journey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the journey
	 * @return the journey that was removed
	 * @throws NoSuchJourneyException if a journey with the primary key could not be found
	 */
	@Override
	public Journey remove(Serializable primaryKey)
		throws NoSuchJourneyException {

		Session session = null;

		try {
			session = openSession();

			Journey journey = (Journey)session.get(
				JourneyImpl.class, primaryKey);

			if (journey == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJourneyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(journey);
		}
		catch (NoSuchJourneyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Journey removeImpl(Journey journey) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(journey)) {
				journey = (Journey)session.get(
					JourneyImpl.class, journey.getPrimaryKeyObj());
			}

			if (journey != null) {
				session.delete(journey);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (journey != null) {
			clearCache(journey);
		}

		return journey;
	}

	@Override
	public Journey updateImpl(Journey journey) {
		boolean isNew = journey.isNew();

		Session session = null;

		try {
			session = openSession();

			if (journey.isNew()) {
				session.save(journey);

				journey.setNew(false);
			}
			else {
				session.evict(journey);
				session.saveOrUpdate(journey);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, JourneyImpl.class, journey.getPrimaryKey(),
			journey, false);

		journey.resetOriginalValues();

		return journey;
	}

	/**
	 * Returns the journey with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the journey
	 * @return the journey
	 * @throws NoSuchJourneyException if a journey with the primary key could not be found
	 */
	@Override
	public Journey findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJourneyException {

		Journey journey = fetchByPrimaryKey(primaryKey);

		if (journey == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJourneyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return journey;
	}

	/**
	 * Returns the journey with the primary key or throws a <code>NoSuchJourneyException</code> if it could not be found.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey
	 * @throws NoSuchJourneyException if a journey with the primary key could not be found
	 */
	@Override
	public Journey findByPrimaryKey(long journeyId)
		throws NoSuchJourneyException {

		return findByPrimaryKey((Serializable)journeyId);
	}

	/**
	 * Returns the journey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param journeyId the primary key of the journey
	 * @return the journey, or <code>null</code> if a journey with the primary key could not be found
	 */
	@Override
	public Journey fetchByPrimaryKey(long journeyId) {
		return fetchByPrimaryKey((Serializable)journeyId);
	}

	/**
	 * Returns all the journeies.
	 *
	 * @return the journeies
	 */
	@Override
	public List<Journey> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @return the range of journeies
	 */
	@Override
	public List<Journey> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of journeies
	 */
	@Deprecated
	@Override
	public List<Journey> findAll(
		int start, int end, OrderByComparator<Journey> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the journeies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JourneyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of journeies
	 * @param end the upper bound of the range of journeies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of journeies
	 */
	@Override
	public List<Journey> findAll(
		int start, int end, OrderByComparator<Journey> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Journey> list = (List<Journey>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JOURNEY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOURNEY;

				if (pagination) {
					sql = sql.concat(JourneyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Journey>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Journey>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the journeies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Journey journey : findAll()) {
			remove(journey);
		}
	}

	/**
	 * Returns the number of journeies.
	 *
	 * @return the number of journeies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOURNEY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "journeyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOURNEY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JourneyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the journey persistence.
	 */
	@Activate
	public void activate() {
		JourneyModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		JourneyModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JourneyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JourneyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(JourneyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.basic.model.Journey"),
			true);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_JOURNEY =
		"SELECT journey FROM Journey journey";

	private static final String _SQL_COUNT_JOURNEY =
		"SELECT COUNT(journey) FROM Journey journey";

	private static final String _ORDER_BY_ENTITY_ALIAS = "journey.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Journey exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		JourneyPersistenceImpl.class);

	static {
		try {
			Class.forName(FOOPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}