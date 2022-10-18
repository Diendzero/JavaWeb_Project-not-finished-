package com.summerproject.dao;

import com.summerproject.pojo.HistoryTracking;

import java.util.List;

public interface HistoryTrackingDao {
    public int addHistoryTracking(HistoryTracking historyTracking);

    public int deleteHistoryTrackingByUsername(String username);

    public int deleteHistoryTrackingById(Integer history_tracking_id);

    public int[] resetId();

    public int updateHistoryTracking(HistoryTracking historyTracking);

    public List<HistoryTracking> queryHistoryTrackingByUsername(String username);

    public HistoryTracking queryHisTrackingById(Integer history_tracking_id);

    public List<HistoryTracking> queryAllHistoryTracking();

    public Integer queryForPageTotalCount();

    public List<HistoryTracking> queryForPageItems(Integer begin, Integer pageSize);
}
