package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.portfolioapp.CV.CVFragment;
import com.example.portfolioapp.CV.home.Homefragment;
import com.example.portfolioapp.portfolio.PortfolioFragement;
import com.example.portfolioapp.sidemenu.Callback;
import com.example.portfolioapp.sidemenu.MenuAdapter;
import com.example.portfolioapp.sidemenu.MenuItem;
import com.example.portfolioapp.sidemenu.MenuUtil;
import com.example.portfolioapp.team.TeamFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRV;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedmenupos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //Set up Side Menu
        setSideMenu();

        // Set up default screen
        setHomeFragment();

       // setCVFragment();
       // setTeamFragment();
        setPortfolioFragement();
    }

    private void setSideMenu()
    {
        menuRV=findViewById(R.id.rv_side_menu);
        // get menu list item will get data from static data class

        menuItems= MenuUtil.getMenuList();
        adapter=new MenuAdapter(menuItems,this);
        menuRV.setLayoutManager(new LinearLayoutManager(this));
        menuRV.setAdapter(adapter);


    }

    void setPortfolioFragement()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PortfolioFragement()).commit();
    }

    void setTeamFragment()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new TeamFragment()).commit();
    }
    void setCVFragment()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CVFragment()).commit();
    }

    void setHomeFragment()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Homefragment()).commit();


    }

    @Override
    public void onSideMenuItem(int i)
    {

        switch (menuItems.get(i).getCode())
        {
            case MenuUtil.HOME_FRAGMENT_CODE:setHomeFragment();
            break;
            case MenuUtil.CV_FRAGMENT_CODE:setCVFragment();
            break;
            case MenuUtil.TEAM_FRAGMENT_CODE:setTeamFragment();
            break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:setPortfolioFragement();
            break;
            default:setHomeFragment();
        }

        // Highlight the selected menu Item
        menuItems.get(selectedmenupos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedmenupos=i;
        adapter.notifyDataSetChanged();

    }
}