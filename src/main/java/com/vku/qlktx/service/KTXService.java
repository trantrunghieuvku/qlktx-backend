package com.vku.qlktx.service;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;

public interface KTXService {
    List<Register> getAllRegister();
    Optional<Register> getRegisterById(Integer id);
}
