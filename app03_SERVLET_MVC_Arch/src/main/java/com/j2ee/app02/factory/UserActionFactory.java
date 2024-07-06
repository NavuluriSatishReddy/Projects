package com.j2ee.app02.factory;


import com.j2ee.app02.action.UserAction;

public class UserActionFactory {
    private static UserAction userAction;
    static{
        userAction=new UserAction();
    }
    public static UserAction getUserAction()
    {
        return userAction;
    }
}
