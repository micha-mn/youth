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

import basic.exception.NoSuchEventAttributesException;

import basic.model.EventAttributes;
import basic.model.impl.EventAttributesImpl;
import basic.model.impl.EventAttributesModelImpl;

import basic.service.persistence.EventAttributesPersistence;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the event attributes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EventAttributesPersistence.class)
@ProviderType
public class EventAttributesPersistenceImpl
	extends BasePersistenceImpl<EventAttributes>
	implements EventAttributesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EventAttributesUtil</code> to access the event attributes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EventAttributesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EventAttributesPersistenceImpl() {
		setModelClass(EventAttributes.class);

		setModelImplClass(EventAttributesImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the event attributes in the entity cache if it is enabled.
	 *
	 * @param eventAttributes the event attributes
	 */
	@Override
	public void cacheResult(EventAttributes eventAttributes) {
		entityCache.putResult(
			entityCacheEnabled, EventAttributesImpl.class,
			eventAttributes.getPrimaryKey(), eventAttributes);

		eventAttributes.resetOriginalValues();
	}

	/**
	 * Caches the event attributeses in the entity cache if it is enabled.
	 *
	 * @param eventAttributeses the event attributeses
	 */
	@Override
	public void cacheResult(List<EventAttributes> eventAttributeses) {
		for (EventAttributes eventAttributes : eventAttributeses) {
			if (entityCache.getResult(
					entityCacheEnabled, EventAttributesImpl.class,
					eventAttributes.getPrimaryKey()) == null) {

				cacheResult(eventAttributes);
			}
			else {
				eventAttributes.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event attributeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventAttributesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event attributes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventAttributes eventAttributes) {
		entityCache.removeResult(
			entityCacheEnabled, EventAttributesImpl.class,
			eventAttributes.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventAttributes> eventAttributeses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventAttributes eventAttributes : eventAttributeses) {
			entityCache.removeResult(
				entityCacheEnabled, EventAttributesImpl.class,
				eventAttributes.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event attributes with the primary key. Does not add the event attributes to the database.
	 *
	 * @param id the primary key for the new event attributes
	 * @return the new event attributes
	 */
	@Override
	public EventAttributes create(long id) {
		EventAttributes eventAttributes = new EventAttributesImpl();

		eventAttributes.setNew(true);
		eventAttributes.setPrimaryKey(id);

		return eventAttributes;
	}

	/**
	 * Removes the event attributes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes that was removed
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	@Override
	public EventAttributes remove(long id)
		throws NoSuchEventAttributesException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the event attributes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event attributes
	 * @return the event attributes that was removed
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	@Override
	public EventAttributes remove(Serializable primaryKey)
		throws NoSuchEventAttributesException {

		Session session = null;

		try {
			session = openSession();

			EventAttributes eventAttributes = (EventAttributes)session.get(
				EventAttributesImpl.class, primaryKey);

			if (eventAttributes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventAttributesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eventAttributes);
		}
		catch (NoSuchEventAttributesException nsee) {
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
	protected EventAttributes removeImpl(EventAttributes eventAttributes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventAttributes)) {
				eventAttributes = (EventAttributes)session.get(
					EventAttributesImpl.class,
					eventAttributes.getPrimaryKeyObj());
			}

			if (eventAttributes != null) {
				session.delete(eventAttributes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventAttributes != null) {
			clearCache(eventAttributes);
		}

		return eventAttributes;
	}

	@Override
	public EventAttributes updateImpl(EventAttributes eventAttributes) {
		boolean isNew = eventAttributes.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eventAttributes.isNew()) {
				session.save(eventAttributes);

				eventAttributes.setNew(false);
			}
			else {
				eventAttributes = (EventAttributes)session.merge(
					eventAttributes);
			}
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
			entityCacheEnabled, EventAttributesImpl.class,
			eventAttributes.getPrimaryKey(), eventAttributes, false);

		eventAttributes.resetOriginalValues();

		return eventAttributes;
	}

	/**
	 * Returns the event attributes with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event attributes
	 * @return the event attributes
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	@Override
	public EventAttributes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventAttributesException {

		EventAttributes eventAttributes = fetchByPrimaryKey(primaryKey);

		if (eventAttributes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventAttributesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eventAttributes;
	}

	/**
	 * Returns the event attributes with the primary key or throws a <code>NoSuchEventAttributesException</code> if it could not be found.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes
	 * @throws NoSuchEventAttributesException if a event attributes with the primary key could not be found
	 */
	@Override
	public EventAttributes findByPrimaryKey(long id)
		throws NoSuchEventAttributesException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the event attributes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the event attributes
	 * @return the event attributes, or <code>null</code> if a event attributes with the primary key could not be found
	 */
	@Override
	public EventAttributes fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the event attributeses.
	 *
	 * @return the event attributeses
	 */
	@Override
	public List<EventAttributes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @return the range of event attributeses
	 */
	@Override
	public List<EventAttributes> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event attributeses
	 */
	@Deprecated
	@Override
	public List<EventAttributes> findAll(
		int start, int end,
		OrderByComparator<EventAttributes> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event attributeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventAttributesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attributeses
	 * @param end the upper bound of the range of event attributeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event attributeses
	 */
	@Override
	public List<EventAttributes> findAll(
		int start, int end,
		OrderByComparator<EventAttributes> orderByComparator) {

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

		List<EventAttributes> list =
			(List<EventAttributes>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EVENTATTRIBUTES);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTATTRIBUTES;

				if (pagination) {
					sql = sql.concat(EventAttributesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventAttributes>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EventAttributes>)QueryUtil.list(
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
	 * Removes all the event attributeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EventAttributes eventAttributes : findAll()) {
			remove(eventAttributes);
		}
	}

	/**
	 * Returns the number of event attributeses.
	 *
	 * @return the number of event attributeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTATTRIBUTES);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EVENTATTRIBUTES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EventAttributesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event attributes persistence.
	 */
	@Activate
	public void activate() {
		EventAttributesModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		EventAttributesModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EventAttributesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EventAttributesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EventAttributesImpl.class.getName());
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
				"value.object.column.bitmask.enabled.basic.model.EventAttributes"),
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

	private static final String _SQL_SELECT_EVENTATTRIBUTES =
		"SELECT eventAttributes FROM EventAttributes eventAttributes";

	private static final String _SQL_COUNT_EVENTATTRIBUTES =
		"SELECT COUNT(eventAttributes) FROM EventAttributes eventAttributes";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eventAttributes.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EventAttributes exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EventAttributesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	static {
		try {
			Class.forName(FOOPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}