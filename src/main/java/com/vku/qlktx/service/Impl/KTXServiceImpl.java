package com.vku.qlktx.service.Impl;

import java.util.List;
import java.util.Optional;

import com.vku.qlktx.model.Register;
import com.vku.qlktx.model.Room;
import com.vku.qlktx.repository.FeedbackRepository;
import com.vku.qlktx.repository.RegisterRepository;
import com.vku.qlktx.repository.RoomRepository;
import com.vku.qlktx.service.KTXService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KTXServiceImpl implements KTXService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private RoomRepository roomRepository;
    
    //vd,ok nhớ có autowire cái nào cũng thế// hoang mang ghê, để coi hiếu code
    //dễ hiểu mà,hơi rối ở đoạn implements,k cần interface cũng k sao nhưng mà k biêt  được có những hàm nào bên trong
    // haha ok có j hỏi hiếu, tắt nha ok
    @Autowired 
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Register> getAllRegister() {
        // TODO Auto-generated method stub
        return registerRepository.findAll();
    }

    @Override
    public Optional<Register> getRegisterById(Integer id) {
        // TODO Auto-generated method stub
        return registerRepository.findById(id);
    }

    // ví dụ cái này chuyển qua roomService đc ko
    //1 service thôi, tất cả đều ở trong 1 service luôn để chung service khi thêm vào controller cho dễ
    @Override
    public List<Room> searchRoom(String rName) {
        // TODO Auto-generated method stub
        return roomRepository.findByNameStartingWith(rName);
    }
          
}
 