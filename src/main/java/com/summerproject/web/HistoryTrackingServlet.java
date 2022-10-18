package com.summerproject.web;

import com.summerproject.pojo.HistoryTracking;
import com.summerproject.pojo.Page;
import com.summerproject.service.HistoryTrackingService;
import com.summerproject.service.impl.HistoryTrackingServiceImpl;
import com.summerproject.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HistoryTrackingServlet extends BaseServlet {
    private HistoryTrackingService historyTrackingService = new HistoryTrackingServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HistoryTracking> historyTrackings = historyTrackingService.queryAllHistoryTracking();
        req.setAttribute("historyTrackings", historyTrackings);
        req.getRequestDispatcher("/pages/Manager/HistoryTrackingManager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HistoryTracking historyTracking = WebUtils.copyParamToBean(req.getParameterMap(), new HistoryTracking());

        historyTrackingService.addHistoryTracking(historyTracking);

        historyTrackingService.resetId();

        resp.sendRedirect(req.getContextPath() + "/Manager/historyTrackingServlet?action=list");
    }

    protected void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int history_tracking_id = WebUtils.parseInt(req.getParameter("history_tracking_id"), 0);

        historyTrackingService.deleteHistoryTrackingById(history_tracking_id);

        historyTrackingService.resetId();

        resp.sendRedirect(req.getContextPath() + "/Manager/historyTrackingServlet?action=list");
    }

    protected void deleteByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        historyTrackingService.deleteHistoryTrackingByUsername(username);

        historyTrackingService.resetId();

        resp.sendRedirect(req.getContextPath() + "/Manager/historyTrackingServlet?action=list");
    }

    protected void updateHistoryTracking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HistoryTracking historyTracking = WebUtils.copyParamToBean(req.getParameterMap(), new HistoryTracking());

        historyTrackingService.updateHistoryTracking(historyTracking);

        resp.sendRedirect(req.getContextPath() + "/Manager/historyTrackingServlet?action=list");
    }

    protected void getHistoryTracking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("history_tracking_id"), 0);

        HistoryTracking historyTracking = historyTrackingService.queryHistoryTrackingById(id);

        req.setAttribute("historyTracking", historyTracking);

        req.getRequestDispatcher("/pages/Manager/EditHistoryTracking.jsp").forward(req, resp);
    }

    protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<HistoryTracking> page = historyTrackingService.setPage(pageNo, pageSize);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/Manager/HistoryTrackingManager.jsp").forward(req, resp);
    }
}
