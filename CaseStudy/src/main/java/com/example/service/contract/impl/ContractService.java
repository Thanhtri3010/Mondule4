package com.example.service.contract.impl;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IAttachFacilityRepository;
import com.example.repository.contract.IContractDetailRepository;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAllAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findContractById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Double> getTotalMoney() {
        List<Double> totalMoneyList = new ArrayList<>();
        List<Contract> contractList = contractRepository.findAll();
        List<ContractDetail> contractDetailList = findAllContractDetail();
        List<AttachFacility> attachFacilityList = findAllAttachFacility();

        double totalMoney = 0;

        for (int i = 0; i < contractList.size(); i++) {
            for (int j = 0; j < contractDetailList.size(); j++) {
                for (int k = 0; k < attachFacilityList.size(); k++) {
                    if (contractList.get(i).getContractId() == contractDetailList.get(j).getContract().getContractId() && contractDetailList.get(j).getAttachFacility().getAttachFacilityId() == attachFacilityList.get(k).getAttachFacilityId()) {
                        totalMoney = totalMoney + (contractDetailList.get(j).getQuantity() * attachFacilityList.get(k).getCost()) + contractList.get(i).getFacility().getCost();
                    }
                }
            }

            totalMoneyList.add(totalMoney - contractList.get(i).getDeposit());
            totalMoney = 0;
        }


        return totalMoneyList;
    }
}
