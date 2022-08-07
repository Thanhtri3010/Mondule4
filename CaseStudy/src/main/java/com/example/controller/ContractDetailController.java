package com.example.controller;

import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract_detail")
public class ContractDetailController {
    @Autowired
    private IContractService contractService;


}