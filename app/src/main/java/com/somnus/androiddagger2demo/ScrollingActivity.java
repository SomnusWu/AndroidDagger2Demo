package com.somnus.androiddagger2demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.somnus.androiddagger2demo.component.DaggerMainActivityComponent;
import com.somnus.androiddagger2demo.module.ActivityModule;
import com.somnus.androiddagger2demo.presenter.DaggerPresenter;

import javax.inject.Inject;


/***
 * @Inject 带有此注解的属性或构造方法将参与到依赖注入中，Dagger2会实例化有此注解的类
 *@Module 带有此注解的类，用来提供依赖，里面定义一些用
           @Provides 注解的以provide开头的方法，这些方法就是所提供的依赖，Dagger2会在该类中寻找实例化某个类所需要的依赖。
 *@Component 用来将@Inject和@Module联系起来的桥梁，从@Module中获取依赖并将依赖注入给@Inject
 */

public class ScrollingActivity extends AppCompatActivity {


    private TextView mTvShow;

    @Inject
    DaggerPresenter mDaggerPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaggerMainActivityComponent.builder().activityModule(new ActivityModule(this)).build().inject(this);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        mDaggerPresenter.showDPName();
        //使用组件进行构造，注入
//        DaggerMainActivityComponent.builder().build().inject(this);

        FloatingActionButton fa = (FloatingActionButton) findViewById(R.id.fab);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, mTest3.getName(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });



    }


    public void showName(String name) {
        mTvShow.setText(name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
