package com.vku.qlktx.service.Impl;
import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.service.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

     @Override
     public List<Register> getAllRegister() {
         return registerRepository.findAll();
     }

     @Override
     public Optional<Register> getRegisterById(Integer id) {
         return registerRepository.findById(id);
     }

     @Override
     public void save(Register register) {
         
         registerRepository.save(register);
     }

     @Override
     public void remove(Register register) {
         registerRepository.delete(register);

     }
          
}
 