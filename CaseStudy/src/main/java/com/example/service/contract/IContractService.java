package com.example.service.contract;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    List<AttachFacility> findAllAttachFacility();

    List<ContractDetail> findAllContractDetail();

    Contract save(Contract contract);

    Optional<Contract> findContractById(int id);

    Page<Contract> findAllContract(Pageable pageable);

    List<Double> getTotalMoney();

}
