package com.kagura.desgin.责任链模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 15:06
 * @since 1.0.0
 */
public class JobChain {
    private Job job;
    private JobChain nextJob;
    public JobChain(Job job, JobChain nextJob) {
        this.job = job;
        this.nextJob = nextJob;
    }
    public void doChain() {
        if(job != null) {
            job.process();
        }
        if(nextJob != null) {
            nextJob.doChain();
        }
    }
}
