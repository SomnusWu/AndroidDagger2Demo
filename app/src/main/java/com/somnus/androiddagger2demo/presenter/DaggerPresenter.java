package com.somnus.androiddagger2demo.presenter;

import com.somnus.androiddagger2demo.ScrollingActivity;
import com.somnus.androiddagger2demo.bean.User;

/**
 * Created by Somnus on 2017/6/28.
 *
 * @Description:
 */

public class DaggerPresenter {


    ScrollingActivity ativity;
    User user;

    public DaggerPresenter(ScrollingActivity ativity, User user) {
        this.ativity = ativity;
        this.user = user;
    }

    public void showDPName() {
        ativity.showName(user.name);
    }
}
