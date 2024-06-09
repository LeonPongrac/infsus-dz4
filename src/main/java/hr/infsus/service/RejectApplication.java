package hr.infsus.service;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
@Named
public class RejectApplication implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String id = delegateExecution.getId();
        System.out.println("Prijava sa task id " + id + " se odbija");
        delegateExecution.setVariable("approved", false);
    }
}
