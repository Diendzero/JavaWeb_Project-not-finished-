package com.summerproject.dao.impl;

import com.summerproject.dao.HistoryTrackingDao;
import com.summerproject.pojo.HistoryTracking;

import java.util.ArrayList;
import java.util.List;

public class HistoryTrackingDaoImpl extends BaseDao implements HistoryTrackingDao {
    @Override
    public int addHistoryTracking(HistoryTracking historyTracking) {
        String sql = "insert into history_tracking(`username`, `gps_location`, `connected_time`, `disconnected_time`, `district_bs_no`) value (?,?,?,?,?)";
        return update(sql, historyTracking.getUsername(), historyTracking.getGps_location(), historyTracking.getConnected_time(), historyTracking.getDisconnected_time(), historyTracking.getDistrict_bs_no());
    }

    @Override
    public int deleteHistoryTrackingByUsername(String username) {
        String sql = "delete from history_tracking where username = ?";
        return update(sql, username);
    }

    @Override
    public int deleteHistoryTrackingById(Integer history_tracking_id) {
        String sql = "delete from history_tracking where history_tracking_id = ?";
        return update(sql, history_tracking_id);
    }

    @Override
    public int[] resetId() {
        String sql1 = "SET @rownum = 0";
        String sql2 = "UPDATE history_tracking SET history_tracking_id = @rownum := @rownum + 1";
        String[] sqls = {sql1, sql2};
        return updateSqls(sqls);
    }

    @Override
    public int updateHistoryTracking(HistoryTracking historyTracking) {
        String sql = "update history_tracking set `username` = ?, `gps_location` = ?, `connected_time` = ?, `disconnected_time` = ?, `district_bs_no` = ? where history_tracking_id = ?";
        return update(sql, historyTracking.getUsername(), historyTracking.getGps_location(), historyTracking.getConnected_time(), historyTracking.getDisconnected_time(), historyTracking.getDistrict_bs_no(), historyTracking.getHistory_tracking_id());
    }

    @Override
    public List<HistoryTracking> queryHistoryTrackingByUsername(String username) {
        String sql = "select * from history_tracking where username = ?";
        return queryForList(HistoryTracking.class, sql, username);
    }

    @Override
    public HistoryTracking queryHisTrackingById(Integer history_tracking_id) {
        String sql = "select * from history_tracking where history_tracking_id = ?";
        return queryForOne(HistoryTracking.class, sql, history_tracking_id);
    }

    @Override
    public List<HistoryTracking> queryAllHistoryTracking() {
        String sql = "select history_tracking_id, username, gps_location, connected_time, disconnected_time, district_bs_no from history_tracking";
        return queryForList(HistoryTracking.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from history_tracking";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<HistoryTracking> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select history_tracking_id, username, gps_location, connected_time, disconnected_time, district_bs_no from history_tracking limit ?, ?";
        return queryForList(HistoryTracking.class, sql, begin, pageSize);
    }
}
