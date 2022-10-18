package com.summerproject.test;

import com.summerproject.dao.HistoryTrackingDao;
import com.summerproject.dao.impl.HistoryTrackingDaoImpl;
import com.summerproject.pojo.HistoryTracking;
import com.summerproject.pojo.Page;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryTrackingDaoTest {
    private HistoryTrackingDao historyTrackingDao = new HistoryTrackingDaoImpl();

    @Test
    public void addHistoryTracking() {
        historyTrackingDao.addHistoryTracking(new HistoryTracking(null, "admin", "$GPGGA,082006.000,3852.9276,N,11527.4283,E,1,08,1.0,20.6,M,,,,0000*27", new SimpleDateFormat("2022-6-29 11:11:11").format(new Date()), new SimpleDateFormat("2022-7-31 14:14:14").format(new Date()), "W1"));
    }

    @Test
    public void deleteHistoryTrackingByUsername() {
        historyTrackingDao.deleteHistoryTrackingByUsername("abcabc");
    }

    @Test
    public void deleteHistoryTrackingById() {
        historyTrackingDao.deleteHistoryTrackingById(2);
    }

    @Test
    public void resetId() {
        historyTrackingDao.resetId();
    }

    @Test
    public void updateHistoryTracking() {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("2022-08-29 12:12:12");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("2022-08-30 13:13:13");
        Date date = new Date();
        historyTrackingDao.updateHistoryTracking(new HistoryTracking("2", "abcabc", "$GPGGA,082006.000,3852.9276,N,11527.4283,E,1,08,1.0,20.6,M,,,,0000*35", simpleDateFormat1.format(date), simpleDateFormat2.format(date), "C3"));
    }

    @Test
    public void queryHistoryTrackingByUsername() {
        System.out.println(historyTrackingDao.queryHistoryTrackingByUsername("admin"));
    }

    @Test
    public void queryHistoryTrackingById() {
        System.out.println(historyTrackingDao.queryHisTrackingById(1));
    }

    @Test
    public void queryAllHistoryTracking() {
        System.out.println(historyTrackingDao.queryAllHistoryTracking());
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(historyTrackingDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (HistoryTracking historyTracking : historyTrackingDao.queryForPageItems(0, Page.PAGE_SIZE)) {
            System.out.println(historyTracking);
        }
    }
}