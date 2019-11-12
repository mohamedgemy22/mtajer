package com.enggemy22.matajer2.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.enggemy22.matajer2.HomeFragment.Favourite;
import com.enggemy22.matajer2.HomeFragment.Home;
import com.enggemy22.matajer2.HomeFragment.Settings;
import com.enggemy22.matajer2.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private ImageView imageView;
    private LinearLayout layoutHome;
    private LinearLayout layoutFavorite;
    private LinearLayout layoutHistory;
    private LinearLayout layoutLogOut;
    private RecyclerView recyclerView;
    private MainAdapter mHomeadapter2;
    private TextView texttitle;
    ArrayList<model2> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initeVirews();
    }

    private void initeVirews() {
        drawerLayout=findViewById(R.id.drawer);

        imageView = findViewById(R.id.menue);
        imageView.setOnClickListener(this);

        texttitle=findViewById(R.id.title);
        //Intent intent=getIntent();
        //intent.putExtra("title",texttitle.getText());
        //startActivity(intent);

        layoutHome = findViewById(R.id.home);
        layoutHome.setOnClickListener(this);

        layoutFavorite = findViewById(R.id.favourite);
        layoutFavorite.setOnClickListener(this);

        layoutHistory = findViewById(R.id.history);
        layoutHistory.setOnClickListener(this);

        layoutLogOut=findViewById(R.id.settings);
        layoutLogOut.setOnClickListener(this);

        layoutLogOut=findViewById(R.id.about_us);
        layoutLogOut.setOnClickListener(this);

         setRexyclerView();
    }

    private void setRexyclerView() {
        mlist=new ArrayList<>();
        recyclerView=findViewById(R.id.homerecycler);
        model2 model1 = new model2("mohamed", "1", R.drawable.shome);
        model2 model = new model2("mahmoud", "2", R.drawable.shome);
        model2 model3 = new model2("mostafa", "3", R.drawable.shome);
        model2 model4 = new model2("gemy", "4", R.drawable.shome);
        model2 model5 = new model2("abas", "5", R.drawable.shome);

        mlist.add(model1);
        mlist.add(model);
        mlist.add(model3);
        mlist.add(model4);
        mlist.add(model5);


        mHomeadapter2= new MainAdapter(mlist,getApplicationContext());
        mHomeadapter2.notifyDataSetChanged();
        recyclerView.setAdapter(mHomeadapter2);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager= new GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menue:
                if(drawerLayout.isDrawerOpen(Gravity.LEFT))
                    drawerLayout.closeDrawer(Gravity.LEFT);
                else
                    drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.home:
           FragmentManager manager= getSupportFragmentManager();
           manager.beginTransaction().replace(R.id.pageContent,new Home()).commit();
          texttitle.setText("home");
           drawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),"this is home activity",Toast.LENGTH_LONG).show();
                break;
            case R.id.favourite:
                texttitle.setText("favourite");
                FragmentManager manager1=getSupportFragmentManager();
                manager1.beginTransaction().replace(R.id.pageContent,new Favourite()).commit();
                drawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),"this is favourite activity",Toast.LENGTH_LONG).show();
                break;
            case R.id.history:
                texttitle.setText("History");
                drawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),"this is history activity",Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                texttitle.setText("Settings");
                FragmentManager manager3=getSupportFragmentManager();
                manager3.beginTransaction().replace(R.id.pageContent,new Settings()).commit();
                drawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),"this is settings activity",Toast.LENGTH_LONG).show();
                break;
            case R.id.about_us:
                texttitle.setText("About Us");
                drawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),"this is about Us activity",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
