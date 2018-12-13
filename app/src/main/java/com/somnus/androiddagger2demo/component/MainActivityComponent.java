package com.somnus.androiddagger2demo.component;

import com.somnus.androiddagger2demo.ScrollingActivity;
import com.somnus.androiddagger2demo.module.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Somnus on 2017/6/27.
 *
 * @Description:
 */

@Singleton
//用这个标注标识是一个连接器
@Component(modules = ActivityModule.class)
public interface MainActivityComponent {
    //这个连接器要注入的对象。这个inject标注的意思是，我后面的参数对象里面有标注为@Inject的属性，这个标注的属性是需要这个连接器注入进来的。
    void inject(ScrollingActivity activity);
}
