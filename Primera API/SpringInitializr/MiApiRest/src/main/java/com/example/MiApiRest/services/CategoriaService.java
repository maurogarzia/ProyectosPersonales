package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Categoria;
import com.example.MiApiRest.repositories.CategoriaRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService extends BaseService<Categoria,Long>{
    public CategoriaService (CategoriaRespository categoriaRepository){
        super(categoriaRepository);

    }
    @Autowired
    private CategoriaRespository categoriaRepository;

    @Transactional
    public Categoria agregarSubcategoria(Long idCategoriaPadre, Categoria nuevaSubcategoria) throws Exception {
        try {
            // Obtener la categoria existente
            Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).orElse(null);

            if (categoriaPadre != null) {

                // Establecer la categoria existente como padre de la nueva subcategoria
                nuevaSubcategoria.setCategoriaPadre(categoriaPadre);

                //Creo la subCategoria como una nueva Categoria
                categoriaRepository.save(nuevaSubcategoria);

                // Agregar la nueva subcategoria a la lista de subcategorias de la categoria existente
                categoriaPadre.getSubcategorias().add(nuevaSubcategoria);

                // Guardar la categoria existente con la nueva subcategoria
                categoriaRepository.save(categoriaPadre);

                return nuevaSubcategoria;
            } else {
                // Manejar el caso en el que la categoria existente no se encuentre
                return null;
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    //Metodo que liste las subcategorias de una categoria (id)
    @Transactional
    public List<Categoria> listarSubcategorias(Long idCategoriaPadre) throws Exception {
        try{
            // Obtener la categoria existente
            Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).orElse(null);

            if (categoriaPadre != null) {

                return new ArrayList<>(categoriaPadre.getSubcategorias());

            } else {
                // Manejar el caso en el que la categoria existente no se encuentre
                return null;
            }

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorCategoriaPadre(Long idCategoriaPadre) throws Exception {
        try {
            return categoriaRepository.findAllByCategoriaPadre_Id(idCategoriaPadre);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
