package com.vku.qlktx.repository;

import com.vku.qlktx.model.Room;

public interface CustomRepository{
    Room searchRoom(String name);
}
