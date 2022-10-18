package com.summerproject.test;

import com.summerproject.pojo.HistoryTracking;
import com.summerproject.pojo.Page;
import com.summerproject.service.HistoryTrackingService;
import com.summerproject.service.impl.HistoryTrackingServiceImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryTrackingServiceTest1 {
    private HistoryTrackingService historyTrackingService = new HistoryTrackingServiceImpl();

    @Test
    public void addHistoryTracking() {
        historyTrackingService.addHistoryTracking(new HistoryTracking(null, "abcabc", "$GPGGA,082006.000,3852.9276,N,11527.4283,E,1,08,1.0,20.6,M,,,,0000*35", new SimpleDateFormat("2022-9-12 11:11:11").format(new Date()), new SimpleDateFormat("2022-9-13 10:11:11").format(new Date()), "N2"));
    }

    @Test
    public void deleteHistoryTrackingByUsername() {
        historyTrackingService.deleteHistoryTrackingByUsername("kevin");
    }

    @Test
    public void deleteHistoryTrackingById() {
        historyTrackingService.deleteHistoryTrackingById(3);
    }

    @Test
    public void updateHistoryTracking() {
        historyTrackingService.updateHistoryTracking(new HistoryTracking("2", "admin", "$GPGGA,082006.000,3852.9276,N,11527.4283,E,1,08,1.0,20.6,M,,,,0000*35", new SimpleDateFormat("2022-10-1 10:10:10").format(new Date()), new SimpleDateFormat("2022-11-9 13:55:23").format(new Date()), "N1"));
    }

    @Test
    public void queryHistoryTrackingByUsername() {
        System.out.println(historyTrackingService.queryHistoryTrackingByUsername("admin"));
    }

    @Test
    public void queryAllHistoryTracking() {
        System.out.println(historyTrackingService.queryAllHistoryTracking());
    }

    @Test
    public void setPage() {
        System.out.println(historyTrackingService.setPage(2, Page.PAGE_SIZE));
    }
}