package com.liuqi.myhasor.Component;

import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@DimModule
@Component
public class HasorComponent implements SpringModule {

    private final DataSource dataSource;

    public HasorComponent(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new JdbcModule(Level.Full,this.dataSource));
    }

    @Override
    public void onStart(AppContext appContext) throws Throwable {

    }

    @Override
    public void onStop(AppContext appContext) throws Throwable {

    }
}
