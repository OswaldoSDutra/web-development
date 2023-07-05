package com.swd.application.config;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.swd.application.usecase.CreateTaskUseCase;

public class GuiceFactory {
    private static Injector injector;

    private GuiceFactory(){

    }

    private static Injector getInjector(){
        if(GuiceFactory.injector == null)
            GuiceFactory.injector = Guice.createInjector(new GuiceConfig());

        return GuiceFactory.injector;
    }

    public static CreateTaskUseCase getCreateTaskUseCase(){
        return GuiceFactory.getInjector().getInstance(CreateTaskUseCase.class);
    }

    public static IAppConfig getAppConfig(){
        return GuiceFactory.getInjector().getInstance(IAppConfig.class);
    }

    public static Gson getGson(){
        return GuiceFactory.getInjector().getInstance(Gson.class);
    }
}
