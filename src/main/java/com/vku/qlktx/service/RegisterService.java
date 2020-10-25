package com.vku.qlktx.service;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;

public interface RegisterService {
    List<Register> getAllRegister();
    Optional<Register> getRegisterById(Integer id);
    void save(Register register);
    void remove(Register register);
}
