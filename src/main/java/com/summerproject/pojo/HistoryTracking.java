package com.summerproject.pojo;

public class HistoryTracking {
    private String history_tracking_id;
    private String username;
    private String gps_location;
    private String connected_time;
    private String disconnected_time;
    private String district_bs_no;

    public HistoryTracking() {
    }

    public HistoryTracking(String history_tracking_id, String username, String gps_location, String connected_time, String disconnected_time, String district_bs_no) {
        this.history_tracking_id = history_tracking_id;
        this.username = username;
        this.gps_location = gps_location;
        this.connected_time = connected_time;
        this.disconnected_time = disconnected_time;
        this.district_bs_no = district_bs_no;
    }

    public String getHistory_tracking_id() {
        return history_tracking_id;
    }

    public void setHistory_tracking_id(String history_tracking_id) {
        this.history_tracking_id = history_tracking_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGps_location() {
        return gps_location;
    }

    public void setGps_location(String gps_location) {
        this.gps_location = gps_location;
    }

    public String getConnected_time() {
        return connected_time;
    }

    public void setConnected_time(String connected_time) {
        this.connected_time = connected_time;
    }

    public String getDisconnected_time() {
        return disconnected_time;
    }

    public void setDisconnected_time(String disconnected_time) {
        this.disconnected_time = disconnected_time;
    }

    public String getDistrict_bs_no() {
        return district_bs_no;
    }

    public void setDistrict_bs_no(String district_bs_no) {
        this.district_bs_no = district_bs_no;
    }

    @Override
    public String toString() {
        return "HistoryTracking{" +
                "history_tracking_id=" + history_tracking_id +
                ", username='" + username + '\'' +
                ", gps_location='" + gps_location + '\'' +
                ", connected_time=" + connected_time +
                ", disconnected_time=" + disconnected_time +
                ", district_bs_no='" + district_bs_no + '\'' +
                '}';
    }
}
