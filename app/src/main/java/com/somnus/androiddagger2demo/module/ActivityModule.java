package com.somnus.androiddagger2demo.module;

import com.somnus.androiddagger2demo.ScrollingActivity;
import com.somnus.androiddagger2demo.bean.User;
import com.somnus.androiddagger2demo.presenter.DaggerPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Somnus on 2017/6/28.
 *
 * @Description:
 */

//Module是用来生产实例来注入对象的， 主要用来提供依赖
    //为了提供那些没有构造函数的类的依赖，这些类无法用@Inject标注，比如第三方类库，系统类
@Module
public class ActivityModule {
    private ScrollingActivity activity;

    public ActivityModule(ScrollingActivity activity) {
        this.activity = activity;
    }

    /**
     * @Provides 注解表示这个方法是用来创建某个实例对象的，
     * 方法名随便，一般用provideXXX结构
     * @return 返回注入对象
     */
    @Provides
    public ScrollingActivity provideActivity() {
        return activity;
    }

    @Provides
    public User provideUser() {
        return new User("user form ActivityModule");
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(ScrollingActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }

}
