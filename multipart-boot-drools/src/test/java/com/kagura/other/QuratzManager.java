package com.kagura.other;

import org.drools.core.time.Scheduler;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/12/5 20:17
 * @since 1.0.0
 */
public class QuratzManager {

    private Scheduler scheduler = null;

    private static QuratzManager qm = QuratzManagerHolder.qm;

    public static QuratzManager getSingletonInstance() {
        return qm;
    }

    private QuratzManager() {
        try {
            scheduler = null;
        } catch (Exception e) {
            System.err.println(1);
        }

    }

    public static class QuratzManagerHolder {
        protected static final QuratzManager qm = new QuratzManager();
    }



}
