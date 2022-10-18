package com.summerproject.service.impl;

import com.summerproject.dao.HistoryTrackingDao;
import com.summerproject.dao.impl.HistoryTrackingDaoImpl;
import com.summerproject.pojo.HistoryTracking;
import com.summerproject.pojo.Page;
import com.summerproject.service.HistoryTrackingService;

import java.util.List;

public class HistoryTrackingServiceImpl implements HistoryTrackingService {
    private HistoryTrackingDao historyTrackingDao = new HistoryTrackingDaoImpl();

    @Override
    public void addHistoryTracking(HistoryTracking historyTracking) {
        historyTrackingDao.addHistoryTracking(historyTracking);
    }

    @Override
    public void deleteHistoryTrackingByUsername(String username) {
        historyTrackingDao.deleteHistoryTrackingByUsername(username);
    }

    @Override
    public void deleteHistoryTrackingById(Integer history_tracking_id) {
        historyTrackingDao.deleteHistoryTrackingById(history_tracking_id);
    }

    @Override
    public void resetId() {
        historyTrackingDao.resetId();
    }

    @Override
    public void updateHistoryTracking(HistoryTracking historyTracking) {
        historyTrackingDao.updateHistoryTracking(historyTracking);
    }

    @Override
    public List<HistoryTracking> queryHistoryTrackingByUsername(String username) {
        return historyTrackingDao.queryHistoryTrackingByUsername(username);
    }

    @Override
    public HistoryTracking queryHistoryTrackingById(Integer history_tracking_id) {
        return historyTrackingDao.queryHisTrackingById(history_tracking_id);
    }

    @Override
    public List<HistoryTracking> queryAllHistoryTracking() {
        return historyTrackingDao.queryAllHistoryTracking();
    }

    @Override
    public Page<HistoryTracking> setPage(Integer pageNo, Integer pageSize) {
        Page<HistoryTracking> page = new Page<>();
        // 设置当前页码
        page.setPageNo(pageNo);
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = historyTrackingDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 当前页数据
        List<HistoryTracking> items = historyTrackingDao.queryForPageItems(begin, pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
