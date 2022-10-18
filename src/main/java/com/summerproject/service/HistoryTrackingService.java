package com.summerproject.service;

import com.summerproject.pojo.HistoryTracking;
import com.summerproject.pojo.Page;

import java.util.List;

public interface HistoryTrackingService {
    public void addHistoryTracking(HistoryTracking historyTracking);

    public void deleteHistoryTrackingByUsername(String username);

    public void deleteHistoryTrackingById(Integer history_tracking_id);

    public void updateHistoryTracking(HistoryTracking historyTracking);

    public void resetId();

    public List<HistoryTracking> queryHistoryTrackingByUsername(String username);

    public HistoryTracking queryHistoryTrackingById(Integer history_tracking_id);

    public List<HistoryTracking> queryAllHistoryTracking();

    public Page<HistoryTracking> setPage(Integer pageNo, Integer pageSize);
}
