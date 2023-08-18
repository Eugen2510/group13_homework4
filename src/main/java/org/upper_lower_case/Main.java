package org.upper_lower_case;

import org.upper_lower_case.mbean.LogSwitcher;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("upper_lower_case:type=LogSwitcher");

        LogSwitcher mbean = new LogSwitcher();
        server.registerMBean(mbean, name);
        CaseConvertor app = new CaseConvertor();
        app.startApp();
    }
}
