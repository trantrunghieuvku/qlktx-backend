package com.vku.qlktx.service.Impl;
import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.service.KTXService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KTXServiceImpl implements KTXService {

    @Autowired
    private RegisterRepository registerRepository;

    public List<Register> getAllRegister() {
        return registerRepository.findAll();
    }

    public Optional<Register> getRegisterById(Integer id) {
         return registerRepository.findById(id);
     }
          
}
