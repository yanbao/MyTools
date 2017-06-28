package com.nbicc.bugtrapper;

import com.nbicc.bugtrapper.patch.TrapperUnit;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        int tid = TrapperUnit.tid();
        System.out.println("t_id : "+tid );
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder());
        main.run(args);
    }

}

