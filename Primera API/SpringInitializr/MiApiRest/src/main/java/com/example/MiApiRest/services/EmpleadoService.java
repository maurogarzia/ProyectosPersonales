package com.example.MiApiRest.services;
import com.example.MiApiRest.entities.Empleado;
import com.example.MiApiRest.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService extends BaseService<Empleado, Long> {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository){
        super(empleadoRepository);
    }

    @Transactional
    public List<Empleado> listarPorSucursal(Long idSucursal)throws Exception{
        try {
            return empleadoRepository.findAllBySucursalId(idSucursal);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
