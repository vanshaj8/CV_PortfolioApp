package com.example.portfolioapp.sidemenu;


import android.view.LayoutInflater;

import com.example.portfolioapp.CV.home.Homefragment;
import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil
{
    public static final int HOME_FRAGMENT_CODE=0;
    public static final int CV_FRAGMENT_CODE=1;
    public static final int PORTFOLIO_FRAGMENT_CODE=2;
    public static final int TEAM_FRAGMENT_CODE=3;

    public  static List<MenuItem> getMenuList()
    {
        List<MenuItem> list=new ArrayList<>();
        // First Item is Selected
        list.add(new MenuItem(R.drawable.ic_baseline_home_24,HOME_FRAGMENT_CODE,true));
        list.add(new MenuItem(R.drawable.ic_baseline_schedule_24,CV_FRAGMENT_CODE,false));
        list.add(new MenuItem(R.drawable.ic_baseline_group_24,PORTFOLIO_FRAGMENT_CODE,false));
        list.add(new MenuItem(R.drawable.ic_baseline_dashboard_24,TEAM_FRAGMENT_CODE,false));

        return  list;
    }
}
