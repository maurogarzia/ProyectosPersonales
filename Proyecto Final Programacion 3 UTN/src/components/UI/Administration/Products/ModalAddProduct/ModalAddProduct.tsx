import { ChangeEvent, FC, useEffect, useState } from "react"
import styles from "./ModalAddProduct.module.css"
import { Button } from "react-bootstrap"
import { ICreateProducto } from "../../../../../types/dtos/productos/ICreateProducto"
import { ICategorias } from "../../../../../types/dtos/categorias/ICategorias"
import { categoryService } from "../../../../../Services/categoryServices"
import { ISucursal } from "../../../../../types/dtos/sucursal/ISucursal"
import { IAlergenos } from "../../../../../types/dtos/alergenos/IAlergenos"
import { alergenoService } from "../../../../../Services/alergenoServices"
import Swal from "sweetalert2"
import { articleService } from "../../../../../Services/articleServices"
import { UploadImage } from "../../../../UploadImage"
import { IImagen } from "../../../../../types/IImagen"

interface IModalAddProduct{
    closeModal : () => void //Funcion para cerrar el modal
    sucursal : ISucursal
}


export const ModalAddProduct : FC<IModalAddProduct> = ({closeModal, sucursal}) => {
    const [categories, setCategories] = useState<ICategorias[]>([])
    const [alergenos, setAlergenos] = useState<IAlergenos[]>([])
    const [selectedAlergenos, setSelectedAlergenos] = useState<number[]>([])
    const [isAlergenosOpen, setIsAlergenosOpen] = useState(false);
    const [imageProduct, setImageProduct] = useState<IImagen | null>(null);

    const [newProduct, setNewProduct] = useState<ICreateProducto>({
        denominacion: "",
        precioVenta: 0,
        descripcion: "",
        habilitado: true,
        codigo: "",
        idCategoria: 0,
        idAlergenos: [],
        imagenes: []
    })

    useEffect(() => {
        const fetchSubCategories = async () => {
            try {
                const data = await categoryService.getAllSubCategoriesBySucursalId(sucursal.id);
                setCategories(data);
            } catch (error) {
                console.error("Error al cargar categorías:", error);
                Swal.fire("Error", "No se pudieron cargar las categorías.", "error");
            }
        };
        fetchSubCategories();
    }, []);
    
    useEffect(() => {
        const fetchAlergenos = async () => {
            try {
                const data = await alergenoService.getAllAlergenos();
                setAlergenos(data);
            } catch (error) {
                console.error("Error al cargar alérgenos:", error);
                Swal.fire("Error", "No se pudieron cargar los alérgenos.", "error");
            }
        };
        fetchAlergenos();
    }, []);

    const handleChange = (e : ChangeEvent<HTMLInputElement> | ChangeEvent<HTMLTextAreaElement>) => {
        const {name, value } = e.target;
        setNewProduct((prev) => ({...prev, 
            [name]: value,
        }));
    }

    const handleCategoryChange = (e : ChangeEvent<HTMLSelectElement>) => {
        const idCategoria = parseInt(e.target.value);
        setNewProduct((prev) => ({ ...prev, idCategoria }));
    }

    const handleAlergenosToggle = () => {
        setIsAlergenosOpen(!isAlergenosOpen);
        console.log(selectedAlergenos);
      };

    const toggleAlergeno = (alergenoid: number) => {
        
        setSelectedAlergenos((prev) => {
          if (prev.includes(alergenoid)) {
            return prev.filter((id) => id !== alergenoid);
          } else {
            return [...prev, alergenoid];
          }
        });
        
        
      };

      const handleSubmit = async (e : React.MouseEvent<HTMLButtonElement>) =>{
        e.preventDefault();


        if(!newProduct.denominacion || !newProduct.descripcion || (newProduct.idCategoria <= 0 || newProduct.precioVenta <= 0)  || !newProduct.codigo ){
            alert("Complete todos los campos");
            return;
        }
        
        try{

            const productToCreate = {
                ...newProduct,
                idAlergenos: selectedAlergenos,
                imagenes: imageProduct?[imageProduct] : []
            }
            console.log("Datos enviados:", newProduct);
            await articleService.createArticle(productToCreate);
            
            
            Swal.fire({
                icon: "success",
                title: "Producto agregado",
                showConfirmButton: false,
                timer: 1500,
                willClose: ()=>{
                    closeModal();
                    window.location.reload() 
                }
                });
        }catch(error){
            console.error("El problema es: ", error);
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Something went wrong!",
            });
        }
    }


  return (
    <div className={styles.containerPrincipal}>
        <div className={styles.containerTitle}>
            <h1>Agregar Producto</h1>
        </div>
        <div className={styles.containerBody}>
            <form action="" className={styles.formContainer}>

            <div className={styles.formBlockOne}>
                <label htmlFor="denominacion">Denominacion: </label>
                <input type="text" placeholder="Denominacion" value={newProduct.denominacion} name="denominacion" onChange={handleChange}/>

                <label htmlFor="precioVenta">Precio de venta: </label>
                <input type="number" placeholder="Precio de venta" min={0} value={newProduct.precioVenta} name="precioVenta" onChange={handleChange}/>

                <label htmlFor="descripcion">Descripcion: </label>
                <textarea
                    id="descripcion"
                    placeholder="Descripción"
                    value={newProduct.descripcion}
                    name="descripcion"
                    onChange ={handleChange}
                ></textarea>

            </div>
            
            
            <div className={styles.formBlockTwo}>

                <label htmlFor="codigo">Código: </label>
                <input type="text" placeholder="Código" value={newProduct.codigo} name="codigo" onChange={handleChange} />

                <label htmlFor="categoria">Categoria: </label>
                <select name="" id="" onChange={handleCategoryChange}>
                    <option value="">Seleccione una Categoría</option>
                    {categories.map((category) => (
                        <option key={category.id} value={category.id}>{category.denominacion}</option>
                    ))}
                </select>


                <label htmlFor="alergenos">Alergenos</label>
            <div className={styles.alergenosDropdown}>
              <button type="button" onClick={handleAlergenosToggle}>
                Seleccionar alérgenos
              </button>
              {isAlergenosOpen && (
                <div className={styles.alergenosList}>
                    {alergenos.map((alergeno) => (
                        <div key={alergeno.id} className={styles.alergenoOption}>
                            <input
                                type="checkbox"
                                id={`alergeno-${alergeno.id}`}
                                checked={selectedAlergenos.includes(alergeno.id)}
                                onChange={() => toggleAlergeno(alergeno.id)}
                            />
                            <label htmlFor={`alergeno-${alergeno.id}`}>{alergeno.denominacion}</label>
                    </div>
                  ))}
                </div>
              )}
            </div>

                <UploadImage 
                imageObjeto={imageProduct}
                setImageObjeto={setImageProduct}
                typeElement="images"
                />
                
            </div>

            
            </form>
        </div>


        <div className={styles.containerButtons}>
          <Button onClick={handleSubmit}>Aceptar</Button>
          <Button onClick={closeModal}>Cancelar</Button>
      </div>
    </div>
  )
}
