package com.template.demo.service;

import com.template.demo.bean.PairedComponentDetailsBean;
import org.springframework.stereotype.Service;

/**
 * @author nsingotam
 */
@Service
public interface ComponentDetailsService {

    boolean createComponentDetails(final String applicationName);

    PairedComponentDetailsBean findAll(final String applicationName);

}
